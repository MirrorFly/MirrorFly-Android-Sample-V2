package com.contusfly.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.activities.ChatActivity
import com.contusfly.adapters.ViewAllLinksAdapter
import com.contusfly.databinding.FragmentViewAllMediaBinding
import com.contusfly.getChatType
import com.contusfly.gone
import com.contusfly.isMeetMessage
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.Constants
import com.contusfly.viewmodels.ViewAllMediaViewModel
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.views.CustomToast

class ViewAllLinksFragment : Fragment() {

    private val viewAllMediaViewModel: ViewAllMediaViewModel by activityViewModels()

    private val viewAllLinksAdapter: ViewAllLinksAdapter by lazy {
        ViewAllLinksAdapter(viewAllMediaViewModel.linkListData)
    }

    private var _binding: FragmentViewAllMediaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentViewAllMediaBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.emptyView.text = getString(R.string.label_no_links)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mediaRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            setEmptyView(binding.emptyView)
            itemAnimator = null
            adapter = viewAllLinksAdapter
        }

        setObservers()
    }

    private fun setObservers() {
        viewAllMediaViewModel.linkListLoaded.observe(viewLifecycleOwner, {
            viewAllLinksAdapter.notifyDataSetChanged()
            binding.progressSpinner.gone()
        })

        viewAllLinksAdapter.onLinkMessageClickedCallback{ clickedMessage ->
            startActivity(
                Intent(requireContext(), ChatActivity::class.java)
                    .putExtra(LibConstants.JID, clickedMessage.getChatUserJid())
                    .putExtra(LibConstants.MESSAGE_ID, clickedMessage.getMessageId())
                    .putExtra(Constants.CHAT_TYPE, clickedMessage.getChatType())
                    .putExtra(Constants.IS_STARRED_MESSAGE, true)
                    .putExtra("externalCall", true)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        }

        viewAllLinksAdapter.onLinkClickedCallback{ clickedMessage ->
            if (AppUtils.isNetConnected(requireContext())) {
                val url =
                    if (clickedMessage.isMeetMessage()) clickedMessage.meetingChatMessage.link else clickedMessage.messageTextContent
                if (url.contains(BuildConfig.WEB_CHAT_LOGIN)) {
                    ChatUtils.navigateToOnGoingCallPreviewScreen(requireContext(), clickedMessage.getChatUserJid(), url)
                } else {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(browserIntent)
                }
            } else {
                CustomToast.show(requireContext(), getString(R.string.msg_no_internet))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): ViewAllLinksFragment {
            return ViewAllLinksFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}