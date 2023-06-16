package com.contusfly.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.contusfly.R
import com.contusfly.adapters.ViewAllDocsAdapter
import com.contusfly.databinding.FragmentViewAllMediaBinding
import com.contusfly.gone
import com.contusfly.utils.ChatClickUtils
import com.contusfly.viewmodels.ViewAllMediaViewModel
import com.mirrorflysdk.api.models.ChatMessage

class ViewAllDocsFragment : Fragment() {

    private val viewAllMediaViewModel: ViewAllMediaViewModel by activityViewModels()
    private var _binding: FragmentViewAllMediaBinding? = null

    private val chatClickUtils: ChatClickUtils by lazy { ChatClickUtils() }

    private val viewAllDocsAdapter: ViewAllDocsAdapter by lazy {
        ViewAllDocsAdapter(viewAllMediaViewModel.docsListData)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentViewAllMediaBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.emptyView.text = getString(R.string.label_no_docs)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mediaRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            setEmptyView(binding.emptyView)
            itemAnimator = null
            adapter = viewAllDocsAdapter
        }

        setObservers()
    }

    private fun setObservers() {
        viewAllMediaViewModel.docsListLoaded.observe(viewLifecycleOwner, {
            viewAllDocsAdapter.notifyDataSetChanged()
            binding.progressSpinner.gone()
        })

        viewAllDocsAdapter.onDocsCallback{ item ->
            handleOnSelectMediaItem(item)
        }
    }

    private fun handleOnSelectMediaItem(item: ChatMessage) {
        chatClickUtils.handleOnListClick(item, requireContext())
    }

    companion object {

        @JvmStatic
        fun newInstance(): ViewAllDocsFragment {
            return ViewAllDocsFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}