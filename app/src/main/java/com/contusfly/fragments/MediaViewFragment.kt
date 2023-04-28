package com.contusfly.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.contusfly.R
import com.contusfly.chat.FileMimeType
import com.contusfly.models.FileObject
import com.contusfly.utils.MediaUtils.loadImageWithGlide
import com.contusfly.utils.MediaUtils.openMediaFile
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.models.MultipleImages
import com.mirrorflysdk.utils.Utils

/**
 * Media fragment is used to show the selected images to share
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class MediaViewFragment : Fragment(), View.OnClickListener {
    lateinit var image: AppCompatImageView
    private lateinit var playVideo: AppCompatImageView
    private lateinit var fileLayout: RelativeLayout
    private lateinit var fileName: CustomTextView
    private lateinit var fileImage: AppCompatImageView
    private lateinit var filesCount: AppCompatTextView
    var position = 0
    var total = 0

    /**
     * Instance of the Message
     */
    private var messageData: MultipleImages? = null
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
    private fun setFileObject(fileObject: FileObject) {
        this.fileObject = fileObject
        isFromQuickShare = true
    }

    /**
     * Assign the message into the message data.
     *
     * @param messageData instance of the message.
     * @param isImage     true if the selected item is image.
     * @param videopath   the path of the media file.
     */
    private fun setMessageData(messageData: MultipleImages, isImage: Boolean, videopath: String?) {
        this.messageData = messageData
        isImageFile = isImage
        this.videopath = videopath
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /**
         * Inflate the layout for this fragment
         */
        return inflater.inflate(R.layout.fragment_selected_media_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.img)
        playVideo = view.findViewById(R.id.play)
        fileLayout = view.findViewById(R.id.fileLayout)
        fileName = view.findViewById(R.id.fileName)
        fileImage = view.findViewById(R.id.fileImage)
        filesCount = view.findViewById(R.id.filesCount)
        filesCount.text = "${(position + 1)}/$total"
        if (isFromQuickShare) {
            when (fileObject!!.fileMimeType) {
                FileMimeType.IMAGE -> setViewsForImageAndVideoTypeMedia(false)
                FileMimeType.VIDEO -> setViewsForImageAndVideoTypeMedia(true)
                FileMimeType.AUDIO, FileMimeType.APPLICATION, FileMimeType.UNSUPPORTED_FORMAT -> setViewsForFileTypeMedia()
                else -> setViewsForFileTypeMedia()
            }
        } else {
            filePath = Utils.returnEmptyStringIfNull(messageData!!.imagePath)
            if (!isImageFile) {
                playVideo.visibility = View.VISIBLE
                image.scaleType = ImageView.ScaleType.FIT_CENTER
                loadImageWithGlide(context, if (isVideoPathNullOrEmpty) filePath else videopath, image,
                        R.drawable.ic_image_placeholder)
                playVideo.setOnClickListener(this)
                image.setOnClickListener(this)
            } else {
                image.scaleType = ImageView.ScaleType.FIT_CENTER
                loadImageWithGlide(context, filePath, image, R.drawable.ic_image_placeholder)
            }
        }
    }

    private val isVideoPathNullOrEmpty: Boolean
        get() = videopath == null || videopath!!.isEmpty()

    /**
     * Set Views for media of File Type
     */
    private fun setViewsForFileTypeMedia() {
        fileLayout.visibility = View.VISIBLE
        fileName.text = fileObject!!.name
        image.visibility = View.GONE
        playVideo.visibility = View.GONE
        val fileExtension = fileObject!!.fileExtension
        when {
            fileExtension.contains("xls") -> {
                fileImage.setImageResource(R.drawable.share_xls)
            }
            fileExtension.contains("doc") -> {
                fileImage.setImageResource(R.drawable.docs)
            }
            fileExtension.contains("ppt") -> {
                fileImage.setImageResource(R.drawable.ic_ppt)
            }
            fileExtension.contains("pdf") -> {
                fileImage.setImageResource(R.drawable.share_pdf)
            }
            fileExtension.contains("txt") -> {
                fileImage.setImageResource(R.drawable.ic_txt)
            }
            fileObject!!.fileMimeType == FileMimeType.AUDIO -> {
                fileImage.setImageResource(R.drawable.audio_logo)
            }
            else -> {
                fileImage.setImageResource(R.drawable.share_file)
            }
        }
    }

    /**
     * Set Views for image and video file type
     *
     * @param isVideo holds the value if its a video or image
     */
    private fun setViewsForImageAndVideoTypeMedia(isVideo: Boolean) {
        fileLayout.visibility = View.GONE
        if (isVideo) {
            playVideo.visibility = View.VISIBLE
            playVideo.setOnClickListener(this)
            image.setOnClickListener(this)
        } else {
            playVideo.visibility = View.GONE
        }
        image.scaleType = ImageView.ScaleType.FIT_CENTER
        loadImageWithGlide(context, fileObject!!.filePath, image, R.drawable.ic_image_placeholder)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.play || v.id == R.id.img) {
            if (isFromQuickShare) {
                openMediaFile(requireContext(), fileObject!!.filePath)
            } else {
                openMediaFile(requireContext(), filePath)
            }
        }
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
        fun newInstance(messageData: MultipleImages, isImage: Boolean,
                        filepath: String?): MediaViewFragment {
            val fragment = MediaViewFragment()
            fragment.setMessageData(messageData, isImage, filepath)
            return fragment
        }

        fun newInstance(fileObject: FileObject, position: Int, total: Int): MediaViewFragment {
            val fragment = MediaViewFragment()
            fragment.setFileObject(fileObject)
            fragment.position = position
            fragment.total = total
            return fragment
        }
    }
}