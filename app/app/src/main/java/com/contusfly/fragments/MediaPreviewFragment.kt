package com.contusfly.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.contusfly.R
import com.contusfly.chat.FileMimeType
import com.contusfly.databinding.FragmentMediaPreviewBinding
import com.contusfly.gone
import com.contusfly.models.FileObject
import com.contusfly.models.MediaPreviewModel
import com.contusfly.show
import com.contusfly.utils.Constants
import com.contusfly.utils.MediaUtils
import com.mirrorflysdk.utils.Utils

/**
 * Media fragment is used to show the selected images to share
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class MediaPreviewFragment : Fragment(), View.OnClickListener {

    var position = 0
    var total = 0

    /**
     * Instance of the Message
     */
    private var messageData: MediaPreviewModel? = null
    private var isFromQuickShare = false

    /**
     * Instance of the Message
     */
    private var fileObject: FileObject? = null

    /**
     * Path of an file
     */
    private var filePath: String? = null

    /**
     * Filepath for the video.
     */
    private var videopath: String? = null

    /**
     * Image selection validation
     */
    private var isImageFile = false

    lateinit var mediaPreviewFragment: FragmentMediaPreviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mediaPreviewFragment = FragmentMediaPreviewBinding.inflate(inflater, container, false)
        return mediaPreviewFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        mediaPreviewFragment.filesCount.text = "${(position + 1)}/$total"

        if (isFromQuickShare) {
            when (fileObject!!.fileMimeType) {
                FileMimeType.IMAGE -> setViewsForImageAndVideoTypeMedia(false)
                FileMimeType.VIDEO -> setViewsForImageAndVideoTypeMedia(true)
                FileMimeType.AUDIO, FileMimeType.APPLICATION, FileMimeType.UNSUPPORTED_FORMAT -> setViewsForFileTypeMedia()
                else -> setViewsForFileTypeMedia()
            }
        } else {
            filePath = messageData?.path ?: Constants.EMPTY_STRING
            if (!messageData!!.isImage) {
                mediaPreviewFragment.playVideo.show()
                mediaPreviewFragment.video.show()
                mediaPreviewFragment.image.gone()
                mediaPreviewFragment.playVideo.setOnClickListener(this)
                mediaPreviewFragment.video.setOnClickListener(this)
                MediaUtils.loadImageWithGlideAnimate(
                    context,
                    filePath,
                    mediaPreviewFragment.video,
                    R.drawable.ic_image_placeholder
                )
            } else {
                mediaPreviewFragment.video.gone()
                mediaPreviewFragment.playVideo.gone()
                mediaPreviewFragment.image.show()
                MediaUtils.loadImageWithGlideAnimate(
                    context,
                    filePath,
                    mediaPreviewFragment.image,
                    R.drawable.ic_image_placeholder
                )
            }
        }
    }

    private val isVideoPathNullOrEmpty: Boolean
        get() = videopath == null || videopath!!.isEmpty()

    /**
     * Set Views for media of File Type
     */
    private fun setViewsForFileTypeMedia() {
        mediaPreviewFragment.fileLayout.show()
        mediaPreviewFragment.fileName.text = fileObject!!.name
        mediaPreviewFragment.image.gone()
        mediaPreviewFragment.video.gone()
        mediaPreviewFragment.playVideo.gone()
        val fileExtension = fileObject!!.fileExtension
        when {
            fileExtension.contains("xls") -> {
                mediaPreviewFragment.fileImage.setImageResource(R.drawable.share_xls)
            }
            fileExtension.contains("doc") -> {
                mediaPreviewFragment.fileImage.setImageResource(R.drawable.docs)
            }
            fileExtension.contains("ppt") -> {
                mediaPreviewFragment.fileImage.setImageResource(R.drawable.ic_ppt)
            }
            fileExtension.contains("pdf") -> {
                mediaPreviewFragment.fileImage.setImageResource(R.drawable.share_pdf)
            }
            fileExtension.contains("txt") -> {
                mediaPreviewFragment.fileImage.setImageResource(R.drawable.ic_txt)
            }
            fileObject!!.fileMimeType == FileMimeType.AUDIO -> {
                mediaPreviewFragment.fileImage.setImageResource(R.drawable.audio_logo)
            }
            else -> {
                mediaPreviewFragment.fileImage.setImageResource(R.drawable.share_file)
            }
        }
    }


    /**
     * Set Views for image and video file type
     *
     * @param isVideo holds the value if its a video or image
     */
    private fun setViewsForImageAndVideoTypeMedia(isVideo: Boolean) {
        mediaPreviewFragment.fileLayout.gone()
        if (isVideo) {
            mediaPreviewFragment.playVideo.show()
            mediaPreviewFragment.playVideo.setOnClickListener(this)
            mediaPreviewFragment.video.setOnClickListener(this)
            mediaPreviewFragment.image.gone()
            mediaPreviewFragment.video.show()
            MediaUtils.loadImageWithGlideAnimate(
                context,
                fileObject!!.filePath,
                mediaPreviewFragment.video,
                R.drawable.ic_image_placeholder
            )
        } else {
            mediaPreviewFragment.playVideo.gone()
            mediaPreviewFragment.video.gone()
            mediaPreviewFragment.image.show()
            MediaUtils.loadImageWithGlideAnimate(
                context,
                fileObject!!.filePath,
                mediaPreviewFragment.image,
                R.drawable.ic_image_placeholder
            )
        }

    }

    override fun onClick(v: View) {
        if (v.id == R.id.play_video || v.id == R.id.video) {
            if (isFromQuickShare) {
                MediaUtils.openMediaFile(requireContext(), fileObject!!.filePath)
            } else {
                MediaUtils.openMediaFile(requireContext(), filePath)
            }
        }
    }

    private fun setFileObject(fileObject: FileObject) {
        this.fileObject = fileObject
        isFromQuickShare = true
    }

    /**
     * Assign the message into the message data.
     *
     * @param messageData instance of the message.
     * @param isImage     true if the selected item is image.
     * @param videoPath   the path of the media file.
     */
    private fun setMessageData(
        messageData: MediaPreviewModel,
        isImage: Boolean,
        videoPath: String?
    ) {
        this.messageData = messageData
        isImageFile = isImage
        this.videopath = videoPath
    }

    companion object {
        /**
         * Use this factory method to create a new instance of this fragment using the provided
         * parameters.
         *
         * @param messageData instance of the message.
         * @param isImage     true if the selected item is image.
         * @param filepath    the path of the media file.
         * @return mediaFragment instance of fragment MediaFragment.
         */
        fun newInstance(
            messageData: MediaPreviewModel, isImage: Boolean,
            filepath: String?
        ): MediaPreviewFragment {
            val fragment = MediaPreviewFragment()
            fragment.setMessageData(messageData, isImage, filepath)
            return fragment
        }

        fun newInstance(fileObject: FileObject, position: Int, total: Int): MediaPreviewFragment {
            val fragment = MediaPreviewFragment()
            fragment.setFileObject(fileObject)
            fragment.position = position
            fragment.total = total
            return fragment
        }
    }
}