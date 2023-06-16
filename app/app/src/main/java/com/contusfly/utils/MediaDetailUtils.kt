package com.contusfly.utils

import android.content.Context
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.R
import com.mirrorflysdk.api.models.ChatMessage
import java.util.concurrent.TimeUnit

/**
 * This class used to get the media details...
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
object MediaDetailUtils {

    /**
     * Sets the downloaded/uploaded view for the video/audio file.
     *
     * @param context            the startupActivityContext of the calling parent.
     * @param txtSendDuration    duration of an audio/video file.
     * @param fileStatus         the status of file.
     * @param starredMessageItem the details of the message.
     * @param imgChatType        chat type image for video.
     */
    fun setMediaView(context: Context?, txtSendDuration: TextView?, fileStatus: Int,
                     starredMessageItem: ChatMessage?, imgChatType: ImageView?) {

        // Check the message type to show the video type
        if (starredMessageItem?.getMessageType() == MessageType.VIDEO) imgChatType?.visibility = View.VISIBLE


        // Check the message type to show the duration for video/audio message
        if (starredMessageItem?.getMessageType() == MessageType.VIDEO || starredMessageItem?.getMessageType() == MessageType.AUDIO) {
            if (fileStatus == MediaDownloadStatus.MEDIA_DOWNLOADED || fileStatus == MediaUploadStatus.MEDIA_UPLOADED) txtSendDuration?.text = getMediaDuration(context, starredMessageItem.getMediaChatMessage().getMediaDuration()) else {
                txtSendDuration?.text = getMediaDuration(context, starredMessageItem.getMediaChatMessage()
                        .getMediaDuration())
            }
        } else txtSendDuration?.visibility = View.GONE
    }

    /**
     * Calling this method to get the audio duration of an audio file
     *
     * @param context   Application startupActivityContext
     * @param duration Audio file duration
     * @return String Audio file duration
     */
    fun getMediaDuration(context: Context?, duration: Long?): String {
        var audioDuration = Constants.EMPTY_STRING
        if (TimeUnit.MILLISECONDS.toHours(duration!!.toLong()) != 0L) {
            audioDuration = String.format(context!!.getString(R.string.text_media_duration_with_hour),
                    TimeUnit.MILLISECONDS.toHours(duration.toLong()),
                    TimeUnit.MILLISECONDS.toMinutes(duration.toLong()) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration.toLong())),
                    TimeUnit.MILLISECONDS.toSeconds(duration.toLong()) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration.toLong())))
        } else if (TimeUnit.MILLISECONDS.toHours(duration.toLong()) == 0L) {
            audioDuration = String.format(context!!.getString(R.string.text_media_duration),
                    TimeUnit.MILLISECONDS.toMinutes(duration.toLong()) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration.toLong())),
                    TimeUnit.MILLISECONDS.toSeconds(duration.toLong()) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration.toLong())))
        }
        return audioDuration
    }

    /**
     * Calling this method to get the audio duration of an audio file
     *
     * @param audioPath Audio file local path
     * @return String Audio file duration
     */
    fun getMediaDuration(audioPath: String?): Long {
        var duration = 0L
        try {
            val mediaPath = Uri.parse(audioPath).path
            val mediaMetadataRetriever = MediaMetadataRetriever()
            mediaMetadataRetriever.setDataSource(mediaPath)
            val extractDuration = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
            mediaMetadataRetriever.release()

            //for rounding audio duration -- if just 1 off, then mostly probably stopped by auto, by reaching limit
            val audioLimit = Constants.AUDIO_DURATION_LIMIT // SharedPreferenceManager.getString(Constants.AUDIO_LIMIT)
            duration = if (extractDuration!!.toLong() / 1000 + 1 == audioLimit.toLong()) audioLimit.toLong() * 1000 else extractDuration.toLong()
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
        return duration
    }

    /**
     * Calling this method to get the audio duration of an audio file
     *
     * @param duration Audio file duration
     * @return String Audio file duration
     */
    fun getMediaDurationInSecs(duration: Long): Int {
        try {
            return (duration / 1000).toInt()
        } catch (e: java.lang.Exception) {
            LogMessage.e(Constants.TAG, e)
        }
        return 0
    }
}