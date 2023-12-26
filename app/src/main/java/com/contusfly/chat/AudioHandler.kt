package com.contusfly.chat

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.contusfly.adapters.ChatAdapterHelper

/**
 * Helper class for the audio process handling
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
object AudioHandler {
    /**
     * Sets the audio status. The action contains MEDIA_DOWNLOADED, MEDIA_UPLOADED,
     * MEDIA_DOWNLOADING, MEDIA_UPLOADING, MEDIA_NOT_DOWNLOADED, MEDIA_NOT_UPLOADED
     *
     * @param uploadOrDownloadLayout       Upload or Download action layout
     * @param progressBar       Progress bar of the image view
     * @param status            Status of the message
     * @param imgPlay           Play image of image view
     * @param cancelLayout      Cancel the media Upload or Download layout
     * @param mid               Message id of the message
     */
    fun setAudioStatus(uploadOrDownloadLayout: RelativeLayout?, progressBar: ProgressBar?, status: Int, imgPlay: ImageView, mid: String?, forwardMedia: ImageView?, cancelLayout: RelativeLayout) {
        when (status) {
            MediaDownloadStatus.MEDIA_DOWNLOADED, MediaUploadStatus.MEDIA_UPLOADED -> {
                ChatAdapterHelper(null).mediaUploadView(progressBar, cancelLayout, uploadOrDownloadLayout)
                imgPlay.visibility = View.VISIBLE
                uploadOrDownloadLayout?.visibility = View.GONE
                if (forwardMedia != null) forwardMedia.visibility = View.VISIBLE
                cancelLayout.visibility = View.GONE
            }
            MediaDownloadStatus.MEDIA_DOWNLOADING, MediaUploadStatus.MEDIA_UPLOADING -> {
                ChatAdapterHelper(null).handleProcessing(uploadOrDownloadLayout, progressBar!!,
                        null, status, mid, cancelLayout)
                cancelLayout.visibility = View.VISIBLE
            }
            MediaDownloadStatus.MEDIA_NOT_DOWNLOADED, MediaDownloadStatus.MEDIA_DOWNLOADED_NOT_AVAILABLE, MediaUploadStatus.MEDIA_NOT_UPLOADED, MediaDownloadStatus.STORAGE_NOT_ENOUGH -> {
                ChatAdapterHelper(null).mediaUploadView(progressBar, cancelLayout, uploadOrDownloadLayout)
                uploadOrDownloadLayout?.visibility = View.VISIBLE
                imgPlay.visibility = View.GONE
                cancelLayout.visibility = View.GONE
            }
            else -> {
                /*
                * No Need to Implement
                */
            }
        }
    }
}