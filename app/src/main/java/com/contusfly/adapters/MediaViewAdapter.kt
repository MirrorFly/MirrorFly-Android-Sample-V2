package com.contusfly.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.contusfly.fragments.MediaViewFragment
import com.contusfly.models.FileObject
import com.mirrorflysdk.models.MultipleImages

/**
 * This class is used to show the mutiple images in view pager
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
internal class MediaViewAdapter : FragmentStatePagerAdapter {
    /**
     * List of messages for the user
     */
    private var messageList: List<MultipleImages>? = null

    /**
     * List of messages for the user
     */
    private var fileObjectList: MutableList<FileObject>? = null

    /**
     * Check whether the adapter is initialized from Quick Share
     */
    var isFromQuickShare = false

    /**
     * Validate if it is image or video to preview
     */
    private var isImage = false

    /**
     * Absolute file path for the videos.
     */
    private var filepath: String? = null
    private var isImageList: List<Boolean>? = null
    var doNotifyDataSetChangedOnce = false

    /**
     * Initialize the message list for fragment.
     *
     * @param fm          Calls the fragment which contains the fragment manager.
     * @param messageList List of messages.
     * @param filepath    the path of the media file.
     */
    constructor(fm: FragmentManager?, messageList: List<MultipleImages>?, filepath: String?) : super(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        this.messageList = messageList
        this.filepath = filepath
    }

    constructor(fm: FragmentManager?, fileObjectList: List<FileObject>?) : super(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        fileObjectList?.let {
            this.fileObjectList = fileObjectList.toMutableList()
        }
        isFromQuickShare = true
    }

    fun setImageList(messageList: List<MultipleImages>?) {
        this.messageList = messageList
    }

    fun setFileObjectList(fileObjectList: List<FileObject>?) {
        doNotifyDataSetChangedOnce = true
        fileObjectList?.let {
            this.fileObjectList = fileObjectList.toMutableList()
        }
    }

    fun removeFileObject(position: Int) {
        doNotifyDataSetChangedOnce = true
        fileObjectList?.removeAt(position)
    }

    override fun getItem(position: Int): Fragment {
        val fragment: Fragment?
        if (isFromQuickShare) {
            fragment = MediaViewFragment.newInstance(fileObjectList!![position], position, fileObjectList!!.size)
        } else {
            isImage = messageList!![position].isImage
            fragment = if (isImageList != null) MediaViewFragment.newInstance(messageList!![position], isImageList!![position], "") else MediaViewFragment.newInstance(messageList!![position], isImage, filepath)
        }
        return fragment
    }

    override fun getCount(): Int {
        return if (isFromQuickShare) {
            if (doNotifyDataSetChangedOnce) {
                doNotifyDataSetChangedOnce = false
                notifyDataSetChanged()
            }
            fileObjectList!!.size
        } else {
            messageList!!.size
        }
    }
}