package com.contusfly.models;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlinx.android.parcel.Parcelize
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B{\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014\u00a2\u0006\u0002\u0010\u0015J\t\u00108\u001a\u000209H\u00d6\u0001J\u0019\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000209H\u00d6\u0001R\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006?"}, d2 = {"Lcom/contusfly/models/FileObject;", "Landroid/os/Parcelable;", "()V", "uri", "Landroid/net/Uri;", "filePath", "", "name", "duration", "", "size", "fileValidation", "Ljava/util/HashMap;", "", "fileMimeType", "fileExtension", "readableSize", "readableDuration", "caption", "mentionedUsersIds", "", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;JJLjava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getFileExtension", "setFileExtension", "getFileMimeType", "setFileMimeType", "getFilePath", "setFilePath", "getFileValidation", "()Ljava/util/HashMap;", "setFileValidation", "(Ljava/util/HashMap;)V", "getMentionedUsersIds", "()Ljava/util/List;", "setMentionedUsersIds", "(Ljava/util/List;)V", "getName", "setName", "getReadableDuration", "setReadableDuration", "getReadableSize", "setReadableSize", "getSize", "setSize", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class FileObject implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable
    private android.net.Uri uri;
    @org.jetbrains.annotations.NotNull
    private java.lang.String filePath;
    @org.jetbrains.annotations.NotNull
    private java.lang.String name;
    private long duration;
    private long size;
    @org.jetbrains.annotations.Nullable
    private java.util.HashMap<java.lang.String, java.lang.Boolean> fileValidation;
    @org.jetbrains.annotations.NotNull
    private java.lang.String fileMimeType;
    @org.jetbrains.annotations.NotNull
    private java.lang.String fileExtension;
    @org.jetbrains.annotations.NotNull
    private java.lang.String readableSize;
    @org.jetbrains.annotations.NotNull
    private java.lang.String readableDuration;
    @org.jetbrains.annotations.NotNull
    private java.lang.String caption;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.String> mentionedUsersIds;
    public static final android.os.Parcelable.Creator<com.contusfly.models.FileObject> CREATOR = null;
    
    public FileObject(@org.jetbrains.annotations.Nullable
    android.net.Uri uri, @org.jetbrains.annotations.NotNull
    java.lang.String filePath, @org.jetbrains.annotations.NotNull
    java.lang.String name, long duration, long size, @org.jetbrains.annotations.Nullable
    java.util.HashMap<java.lang.String, java.lang.Boolean> fileValidation, @org.jetbrains.annotations.NotNull
    @com.contusfly.chat.FileMimeType
    java.lang.String fileMimeType, @org.jetbrains.annotations.NotNull
    java.lang.String fileExtension, @org.jetbrains.annotations.NotNull
    java.lang.String readableSize, @org.jetbrains.annotations.NotNull
    java.lang.String readableDuration, @org.jetbrains.annotations.NotNull
    java.lang.String caption, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.net.Uri getUri() {
        return null;
    }
    
    public final void setUri(@org.jetbrains.annotations.Nullable
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFilePath() {
        return null;
    }
    
    public final void setFilePath(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final long getDuration() {
        return 0L;
    }
    
    public final void setDuration(long p0) {
    }
    
    public final long getSize() {
        return 0L;
    }
    
    public final void setSize(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.HashMap<java.lang.String, java.lang.Boolean> getFileValidation() {
        return null;
    }
    
    public final void setFileValidation(@org.jetbrains.annotations.Nullable
    java.util.HashMap<java.lang.String, java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFileMimeType() {
        return null;
    }
    
    public final void setFileMimeType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFileExtension() {
        return null;
    }
    
    public final void setFileExtension(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getReadableSize() {
        return null;
    }
    
    public final void setReadableSize(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getReadableDuration() {
        return null;
    }
    
    public final void setReadableDuration(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCaption() {
        return null;
    }
    
    public final void setCaption(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getMentionedUsersIds() {
        return null;
    }
    
    public final void setMentionedUsersIds(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> p0) {
    }
    
    public FileObject() {
        super();
    }
    
    @java.lang.Override
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override
    public void writeToParcel(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.contusfly.models.FileObject> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public final com.contusfly.models.FileObject createFromParcel(@org.jetbrains.annotations.NotNull
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public final com.contusfly.models.FileObject[] newArray(int size) {
            return null;
        }
    }
}