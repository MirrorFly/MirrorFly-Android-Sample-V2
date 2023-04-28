package com.fxn.modals;

import com.fxn.pix.Options;

public class MediaPreviewIntent {

    private static MediaPreviewIntent mInstance;

    private MediaPreviewIntent() {

    }

    public static MediaPreviewIntent getInstance() {
        if (mInstance == null)
            mInstance = new MediaPreviewIntent();
        return mInstance;
    }

    private String toUser;

    private String chatType;

    private Class mediaClass;

    public Class getMediaClass(Options options) {
        if (mediaClass == null)
            return  options.getMediaClass();
        else
            return mediaClass;
    }

    public void setMediaClass(Class mediaClass) {
        this.mediaClass = mediaClass;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }
}

