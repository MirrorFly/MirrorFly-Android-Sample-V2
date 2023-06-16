package com.contusfly.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/utils/ConversationUtils;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createDotNoMediaFile", "", "rootPath", "app_debug"})
public final class ConversationUtils {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String TAG = null;
    
    public ConversationUtils() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTAG() {
        return null;
    }
    
    /**
     * Default applications in Android like Photo Gallery, Android MP3 Player, Android Video Player
     * will display all the photos, songs & videos from all of the folders in your device.
     * But if you add ".nomedia" file in any folder, the media content of that folder will be disappear from the Gallery/Player.
     *
     *
     * ".nomedia" is a simple blank file to hide pictures, songs & videos in Android phone/tablet.
     *
     *
     * Sent Media files to other user will save in "/UIKit/Images/sent".
     * This "sent" folder we don't need to expose to "Gallery" app; So, we are adding ".nomedia" file in "sent" folder
     *
     * @param rootPath sent media file path
     */
    public final void createDotNoMediaFile(@org.jetbrains.annotations.NotNull()
    java.lang.String rootPath) {
    }
}