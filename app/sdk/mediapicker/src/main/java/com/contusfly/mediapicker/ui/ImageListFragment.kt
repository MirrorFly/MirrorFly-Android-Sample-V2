package com.contusfly.mediapicker.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.contusfly.mediapicker.R
import com.contusfly.mediapicker.`interface`.ImageListClickListener
import com.contusfly.mediapicker.databinding.FragmentImageListBinding
import com.contusfly.mediapicker.model.Image
import com.contusfly.mediapicker.ui.adapter.ImageListAdapter
import com.contusfly.mediapicker.viewmodel.MediaViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

open class ImageListFragment : BaseFragment(), ImageListClickListener {

    private var _binding: FragmentImageListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


   private val mediaViewModel: MediaViewModel by activityViewModels()

    private val imageListAdapter: ImageListAdapter by lazy {
        ImageListAdapter(requireContext(), mediaViewModel.selectedPhotoMediaList, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentImageListBinding.inflate(inflater, container, false)
        context?.let { mediaViewModel.getImagesInFolder(it,ImageListFragmentArgs.fromBundle(requireArguments()).folderName, mediaViewModel.imageFolderListAdapter[ImageListFragmentArgs.fromBundle(requireArguments()).imagePosition].images[0]) }!!
        return getPersistentView(binding.root)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageListRecyclerView.apply {
            layoutManager =  CustomStaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            itemAnimator = null
            adapter = imageListAdapter
            addItemDecoration(StaggeredGridItemDecoration(requireContext(), 4))
        }

        setObservers()
    }

    private fun setObservers() {
        mediaViewModel.isMultiSelectEnable.observe(viewLifecycleOwner, {
            if (!it)
                imageListAdapter.notifyDataSetChanged()
        })

        mediaViewModel.deletedPhotoMediaList.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()){
                it.keys.forEach { image ->
                    imageListAdapter.notifyItemChanged(it[image]!!)
                }
            }
        })

        mediaViewModel.itemSelectedPosition.observe(viewLifecycleOwner, {
            if (it >= 0)
                imageListAdapter.notifyItemChanged(it)
        })

        mediaViewModel.isImageListLoaded.observe(viewLifecycleOwner, {
            lifecycleScope.launch() {
                if(mediaViewModel.folderMediaList.size > 0)
                    mediaViewModel.getMediaGroupedListData(mediaViewModel.folderMediaList).collectLatest() {
                        imageListAdapter.submitData(it)
                    }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        requireActivity().menuInflater.inflate(R.menu.image_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.action_select_multiple -> {
                mediaViewModel.enableMultiSelect(true)
            }
        }
        return false
    }

    override fun onItemClicked(imageDetail: Image, position: Int) {
        mediaViewModel.itemClicked(imageDetail, position)
    }

    override fun onItemLongClicked(imageDetail: Image, position: Int) {
        mediaViewModel.itemLongClicked(imageDetail, position)
    }
}