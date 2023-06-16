package com.contusfly.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.contusfly.R
import com.contusfly.activities.MediaSlideActivity
import com.contusfly.adapters.ViewAllMediaAdapter
import com.contusfly.databinding.FragmentViewAllMediaBinding
import com.contusfly.gone
import com.contusfly.mediapicker.ui.CustomStaggeredGridLayoutManager
import com.contusfly.utils.Constants
import com.contusfly.viewmodels.ViewAllMediaViewModel
import com.contusfly.views.GridSpacingItemDecoration
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.views.CustomToast


class ViewAllMediaFragment : Fragment() {

    private val viewAllMediaViewModel: ViewAllMediaViewModel by activityViewModels()
    private var _binding: FragmentViewAllMediaBinding? = null

    private val viewAllMediaAdapter: ViewAllMediaAdapter by lazy {
        ViewAllMediaAdapter(viewAllMediaViewModel.mediaListData)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentViewAllMediaBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.emptyView.text = getString(R.string.label_no_media)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mediaRecyclerView.apply {
            layoutManager = CustomStaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            setEmptyView(binding.emptyView)
            itemAnimator = null
            adapter = viewAllMediaAdapter
            addItemDecoration(GridSpacingItemDecoration(requireContext(), 4))
        }
        setObservers()
    }

    private fun setObservers() {
        viewAllMediaViewModel.mediaListLoaded.observe(viewLifecycleOwner, {
            viewAllMediaAdapter.notifyDataSetChanged()
            binding.progressSpinner.gone()
        })

        viewAllMediaAdapter.onMediaClickedCallback{item ->
            handleOnSelectMediaItem(item)
        }
    }

    /**
     * Handle while the user selects media item.
     *
     * @param item the selected message
     */
    private fun handleOnSelectMediaItem(item: ChatMessage) {
        val msgType = item.getMessageType()
        if (msgType != null) {
            // If message type is image start the ActivityImageView
            startActivity(
                Intent(requireContext(), MediaSlideActivity::class.java)
                    .putExtra(Constants.MESSAGE_ID, item.getMessageId())
                    .putExtra(Constants.USER_JID, viewAllMediaViewModel.jid)
            )
        } else CustomToast.show(requireContext(), getString(R.string.text_media_not_available))
    }

    companion object {

        @JvmStatic
        fun newInstance(): ViewAllMediaFragment {
            return ViewAllMediaFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}