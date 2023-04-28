/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.fragments

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.R
import com.contusfly.utils.ChatClickUtils
import com.contusfly.utils.MediaUtils.loadImageWithGlide
import com.contusfly.zoomimageview.ZoomImageView
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.utils.MediaShareUtils
import com.mirrorflysdk.views.CustomToast
import java.util.*

/**
 * This fragment used to display the media files in slider
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class MediaFragment : Fragment(), View.OnClickListener {
    /**
     * Instance of the Message
     */
    private var messageData: ChatMessage? = null

    /**
     * Assign the message into the message data
     *
     * @param messageData Instance of the message
     */
    private fun setMessageData(messageData: ChatMessage) {
        this.messageData = messageData
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity?.window?.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_media, container, false)
    }

    /**
     * OnView Created
     *
     * @param view               The view of the fragment
     * @param savedInstanceState reference to a Bundle object that is passed into the onCreate method of every Android Activity
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val msgType = messageData!!.getMessageType()
        val image = view.findViewById<ZoomImageView>(R.id.img)
        val play = view.findViewById<ImageView>(R.id.play)
        play.setOnClickListener(this)

        // Select p[ace holder based on message type
        when (msgType) {
            MessageType.IMAGE -> {
                loadImageWithGlide(context, messageData!!.getMediaChatMessage().getMediaLocalStoragePath(),
                        image, R.drawable.ic_image_placeholder)
                play.visibility = View.GONE
                image.isZoomable = true
            }
            MessageType.VIDEO -> {
                loadImageWithGlide(context, messageData!!.getMediaChatMessage().getMediaLocalStoragePath(),
                        image, R.drawable.ic_video_placeholder)
                play.visibility = View.VISIBLE
                image.isZoomable = false
            }
            MessageType.AUDIO -> {
                loadImageWithGlide(context, messageData!!.getMediaChatMessage().getMediaLocalStoragePath(), image, if (messageData!!.getMediaChatMessage().isAudioRecorded()) R.drawable.ic_record_audio_placeholder else R.drawable.ic_music_audio_placeholder)
                play.visibility = View.VISIBLE
                image.isZoomable = false
            }
            else -> {
                /*No Implementation Needed*/
            }
        }
    }

    /**
     * Media Message Onclick
     *
     * @param v view
     */
    override fun onClick(v: View) {
        val msgType = messageData!!.getMessageType()
        if (msgType != null) {
            if (msgType == MessageType.VIDEO || msgType == MessageType.AUDIO) // If message type is video or audio start the method openMediaFile from the utils
                ChatClickUtils().handleOnListClick(messageData, context)
        } else CustomToast.show(context, getString(R.string.text_media_not_available))
    }

    /**
     * to specify the options menu for an activity
     *
     * @param menu     instance of the Menu
     * @param inflater instantiate menu XML files into Menu objects
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        try {
            inflater.inflate(R.menu.menu_share, menu)
            val menuItem = menu.findItem(R.id.action_share_image)
            menuItem.isVisible = true
        } catch (e: Exception) {
            LogMessage.e(e)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        try {
            /**
             * Crop the selected image
             */
            if (item.itemId == R.id.action_share_image) {
                val mid = ArrayList<String>()
                mid.add(messageData!!.getMessageId())
                MediaShareUtils().shareMediaExternal(mid, context)
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of this fragment using the provided
         * parameters.
         *
         * @param messageData Instance of the message
         * @return MediaFragment Instance of fragment MediaFragment.
         */
        fun newInstance(messageData: ChatMessage): MediaFragment {
            val fragment = MediaFragment()
            fragment.setMessageData(messageData)
            return fragment
        }
    }
}