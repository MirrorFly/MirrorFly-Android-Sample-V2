package com.contusfly.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.R
import com.contusfly.activities.MediaSlideActivity
import com.contusfly.isMessageSent
import com.contusfly.utils.MediaUtils.openMediaFile
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.helpers.LocationUtils
import com.mirrorflysdk.views.CustomToast
import java.io.File

/**
 * This class contains the all chat related common methods
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class ChatClickUtils {
    /**
     * Handle on list click from the chat window for the location and contact message
     * type. If it was location, then opens the location view. And if the message
     * type was contact, then it prompts user to insert the contact.
     *
     * @param messageItem Instance of the message
     * @param context     Context of the activity
     */
    fun handleOnListClick(messageItem: ChatMessage?, context: Context?) {
        context?.let {
            try {
                if (messageItem!!.getMessageType() == MessageType.LOCATION) {
                    if (AppUtils.isNetConnected(context))
                        showLocation(messageItem, context)
                    else
                        CustomToast.show(context, context.getString(R.string.msg_no_internet))
                } else {
                    handleMediaListClick(messageItem, context)
                }
            } catch (e: Exception) {
                LogMessage.e(Constants.TAG, e)
            }
        }

    }

    /**
     * In this method it has been handles how the map view activity is opened
     * when there is a location message was received. Upon clicking on the location
     * message it redirects to the map view activity.
     *
     *
     * Google map's app is necessary to view the location message. isGoogleMapsInstalled
     * Returns google map application availability status. So we first check if the google maps
     * is installed in the device. If installed we get the latitude and longitude. Thereafter,
     * we start the Mapviewactivity with the latitude and longitude sent through
     * the intent.
     *
     *
     * If Google map's is not installed in the device, we set a toast prompting the user
     * as Google map not available.
     *
     * @param message Instance of the MessageDetail
     * @param context       Instance of the Context
     */
    private fun showLocation(message: ChatMessage, context: Context) {
        val locationUtils = LocationUtils()
        if (locationUtils.isGoogleMapsInstalled(context)) {
            val locationMessage = message.getLocationChatMessage()
            val latitude = locationMessage.getLatitude()
            val longitude = locationMessage.getLongitude()
            val label = "Label"
            val uriBegin = "geo:$latitude,$longitude"
            val query = "$latitude,$longitude($label)"
            val encodedQuery = Uri.encode(query)
            val uriString = "$uriBegin?q=$encodedQuery&z=16"
            val uri = Uri.parse(uriString)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)
        } else {
            CustomToast.show(context, context.getString(R.string.error_google_map_not_installed))
        }
    }

    /**
     * Handle the clicked item of the Media that is Audio,Video and Image.
     *
     * @param message Instance of the message
     * @param context Instance of the Context
     */
    private fun handleMediaListClick(message: ChatMessage?, context: Context) {
        /**
         * Here we get the message body and check if the message is image type or video type.
         * And also we check if the media is downloaded or uploading. If the message is of
         * image type, then we send intent to the imageview activity.
         *
         * If the media is downloaded then we opens the mediafile by fetching the
         * local path of the file.
         *
         */
        message?.let {
            val isMediaFileAvailable = MediaChecker.isMediaFileAvailable(message.getMessageType(), message)
            if (isMediaFileAvailable && (message.getMediaChatMessage().getMediaDownloadStatus()
                            == MediaDownloadStatus.MEDIA_DOWNLOADED || (message.getMediaChatMessage().getMediaUploadStatus()
                        == MediaUploadStatus.MEDIA_UPLOADED && !message.isMessageSent()))) {
                if (isMediaExists(message.getMediaChatMessage().getMediaLocalStoragePath())) {
                    if (MessageType.IMAGE == message.getMessageType()) {
                        context.startActivity(Intent(context, MediaSlideActivity::class.java)
                                .putExtra(Constants.MESSAGE_ID, message.getMessageId())
                                .putExtra(Constants.USER_JID, message.getChatUserJid()))
                    } else if (message.getMediaChatMessage().getMediaDownloadStatus()
                            == MediaDownloadStatus.MEDIA_DOWNLOADED || message.getMediaChatMessage()
                                    .getMediaUploadStatus() == MediaUploadStatus.MEDIA_UPLOADED) {
                        openMediaFile(context, message.getMediaChatMessage().getMediaLocalStoragePath())
                    }
                } else CustomToast.showShortToast(context, context.getString(R.string.msg_media_does_not_exists))
            }
        }
    }

    private fun isMediaExists(filePath: String): Boolean {
        val file = File(filePath)
        return file.exists()
    }
}