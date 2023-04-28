package com.contusfly.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.contusfly.fragments.MediaPreviewFragment
import com.contusfly.models.FileObject
import com.contusfly.models.MediaPreviewModel

class MediaPreviewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentStatePagerAdapter(supportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var filepath: String? = null
    /**
     * List of messages for the user
     */
    private var messageList: List<MediaPreviewModel>? = null

    /**
     * List of messages for the user
     */
    private var fileObjectList: MutableList<FileObject>? = null

    /**
     * Check whether the adapter is initialized from Quick Share
     */
    var isFromQuickShare = false

    private var doNotifyDataSetChangedOnce = false

    /**
     * Validate if it is image or video to preview
     */
    private var isImage = false

    fun setImageList(messageList: List<MediaPreviewModel>?) {
        this.messageList = messageList
        messageList!!.forEach {
            Log.d("selectedImages", "selectedImages after2 path:${it.path}")
        }
    }

    fun setFileObjectList(fileObjectList: List<FileObject>?) {
        doNotifyDataSetChangedOnce = true
        isFromQuickShare = true
        fileObjectList?.let {
            this.fileObjectList = fileObjectList.toMutableList()
        }
    }

    fun removeFileObject(position: Int) {
        doNotifyDataSetChangedOnce = true
        fileObjectList?.removeAt(position)
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

    override fun getItem(position: Int): Fragment {
        val fragment: Fragment
        if (isFromQuickShare) {
            fragment = MediaPreviewFragment.newInstance(fileObjectList!![position], position, fileObjectList!!.size)
        } else {
            isImage = messageList!![position].isImage
            fragment = MediaPreviewFragment.newInstance(messageList!![position], isImage, filepath)
        }
        return fragment
    }
}