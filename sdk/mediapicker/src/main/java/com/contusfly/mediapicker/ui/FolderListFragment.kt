package com.contusfly.mediapicker.ui

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.contusfly.mediapicker.`interface`.FolderListClickListener
import com.contusfly.mediapicker.databinding.FragmentFolderListBinding
import com.contusfly.mediapicker.model.FolderDetail
import com.contusfly.mediapicker.ui.adapter.FolderListAdapter
import com.contusfly.mediapicker.utils.PickerConstants
import com.contusfly.mediapicker.viewmodel.MediaViewModel


class FolderListFragment : BaseFragment(), FolderListClickListener {

    private var _binding: FragmentFolderListBinding? = null
    private val binding get() = _binding!!

    private val mediaViewModel: MediaViewModel by activityViewModels()

    private var menuApps: Menu? = null

    private val folderListAdapter: FolderListAdapter by lazy {
        FolderListAdapter(requireContext(), mediaViewModel.imageFolderListAdapter, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFolderListBinding.inflate(inflater, container, false)
        return getPersistentView(binding.root)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!hasInitializedRootView) {
            val extras = requireActivity().intent.extras
            if (extras != null) {
                val canImageShow = extras.getBoolean(PickerConstants.IMAGE_CAN_SHOW, true)
                val canVideoShow = extras.getBoolean(PickerConstants.VIDEO_CAN_SHOW, true)
                mediaViewModel.setPreCondition(canImageShow, canVideoShow)
            }
            hasInitializedRootView = true
            Log.d("getImageBuckets", "Called")
            mediaViewModel.getImageBuckets(requireContext())
            mediaViewModel.getMediaPickerApps(requireContext())

            binding.folderListRecyclerView.apply {
                layoutManager = GridLayoutManager(context, 3)
                setItemViewCacheSize(0)
                setHasFixedSize(true)
                adapter = folderListAdapter
                addItemDecoration(GridItemDecoration(requireContext(), 3))
            }
            setObservers()
        }
    }

    private fun setObservers() {
        mediaViewModel.isImageListLoaded.observe(viewLifecycleOwner, {
            Log.d("getImageBuckets", "Finished")
            binding.folderListRecyclerView.setEmptyView(binding.noFoldersView.root)
            folderListAdapter.notifyDataSetChanged()
        })

        mediaViewModel.pickerApplications.observe(viewLifecycleOwner, {
            menuApps?.let { menu ->
                setMenuItems(it, menu)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        mediaViewModel.folderMediaList.clear()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menuApps = menu
        mediaViewModel.pickerApplications.value?.let {
            setMenuItems(it, menu)
        }
    }

    private fun setMenuItems(apps: MutableList<String>, menu: Menu) {
        menu.clear()
        val pm = requireContext().packageManager
        apps.forEachIndexed { index, packageName ->
            try {
                val appInfo = pm.getApplicationInfo(
                    packageName,
                    PackageManager.GET_META_DATA)
                val appName = pm.getApplicationLabel(appInfo)
                menu.add(
                    0, index, Menu.NONE, appName
                ).icon = pm.getApplicationIcon(packageName)
                if (menu is MenuBuilder) {
                    menu.setOptionalIconsVisible(true)
                }
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (mediaViewModel.pickerApplications.value != null && mediaViewModel.pickerApplications.value!!.size > item.itemId) {
            (requireActivity() as MediaPickerActivity).pickMediaFromOtherApp(mediaViewModel.pickerApplications.value!![item.itemId])
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(folderDetail: FolderDetail, position: Int) {
        val action = FolderListFragmentDirections.actionFolderListFragmentToImageListFragment(
            folderDetail.folderName,
            mediaViewModel.imageFolderListAdapter.indexOf(folderDetail)
        )
        findNavController().navigate(action)
    }
}