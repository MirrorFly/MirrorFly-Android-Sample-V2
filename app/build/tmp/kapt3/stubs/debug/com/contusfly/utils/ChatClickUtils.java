package com.contusfly.utils;

import java.lang.System;

/**
 * This class contains the all chat related common methods
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/contusfly/utils/ChatClickUtils;", "", "()V", "canAbleToOpenMedia", "", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "handleMediaListClick", "", "context", "Landroid/content/Context;", "handleOnListClick", "messageItem", "isMediaExists", "filePath", "", "isMediaFileNotAvailable", "isMediaFileAvailable", "showLocation", "app_debug"})
public final class ChatClickUtils {
    
    public ChatClickUtils() {
        super();
    }
    
    /**
     * Handle on list click from the chat window for the location and contact message
     * type. If it was location, then opens the location view. And if the message
     * type was contact, then it prompts user to insert the contact.
     *
     * @param messageItem Instance of the message
     * @param context     Context of the activity
     */
    public final void handleOnListClick(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.Nullable
    android.content.Context context) {
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
    private final void showLocation(com.mirrorflysdk.api.models.ChatMessage message, android.content.Context context) {
    }
    
    /**
     * Handle the clicked item of the Media that is Audio,Video and Image.
     *
     * @param message Instance of the message
     * @param context Instance of the Context
     */
    private final void handleMediaListClick(com.mirrorflysdk.api.models.ChatMessage message, android.content.Context context) {
    }
    
    private final boolean canAbleToOpenMedia(com.mirrorflysdk.api.models.ChatMessage message) {
        return false;
    }
    
    private final boolean isMediaFileNotAvailable(boolean isMediaFileAvailable, com.mirrorflysdk.api.models.ChatMessage message) {
        return false;
    }
    
    private final boolean isMediaExists(java.lang.String filePath) {
        return false;
    }
}