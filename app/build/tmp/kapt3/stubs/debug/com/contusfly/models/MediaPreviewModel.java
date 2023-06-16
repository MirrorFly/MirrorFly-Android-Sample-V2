package com.contusfly.models;

import java.lang.System;

@kotlinx.android.parcel.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001bH\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e\u00a8\u0006%"}, d2 = {"Lcom/contusfly/models/MediaPreviewModel;", "Landroid/os/Parcelable;", "path", "", "caption", "thumbString", "isImage", "", "mentionedUsersIds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "()Z", "setImage", "(Z)V", "getMentionedUsersIds", "()Ljava/util/List;", "setMentionedUsersIds", "(Ljava/util/List;)V", "getPath", "setPath", "getThumbString", "setThumbString", "describeContents", "", "equals", "other", "", "hashCode", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class MediaPreviewModel implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String path;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String caption;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thumbString;
    private boolean isImage;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> mentionedUsersIds;
    public static final android.os.Parcelable.Creator<com.contusfly.models.MediaPreviewModel> CREATOR = null;
    
    public MediaPreviewModel(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String caption, @org.jetbrains.annotations.NotNull()
    java.lang.String thumbString, boolean isImage, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> mentionedUsersIds) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPath() {
        return null;
    }
    
    public final void setPath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCaption() {
        return null;
    }
    
    public final void setCaption(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThumbString() {
        return null;
    }
    
    public final void setThumbString(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isImage() {
        return false;
    }
    
    public final void setImage(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getMentionedUsersIds() {
        return null;
    }
    
    public final void setMentionedUsersIds(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.contusfly.models.MediaPreviewModel> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.contusfly.models.MediaPreviewModel createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.contusfly.models.MediaPreviewModel[] newArray(int size) {
            return null;
        }
    }
}