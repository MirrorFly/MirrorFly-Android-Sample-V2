package com.contusfly.models;

import java.lang.System;

@kotlinx.android.parcel.Parcelize
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0003J7\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u00d6\u0003J\t\u0010#\u001a\u00020\u001eH\u00d6\u0001J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eH\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006*"}, d2 = {"Lcom/contusfly/models/EditMessageParams;", "Landroid/os/Parcelable;", "messageType", "Lcom/mirrorflysdk/flycommons/models/MessageType;", "messageId", "", "editedText", "mentionedUsersIds", "", "(Lcom/mirrorflysdk/flycommons/models/MessageType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEditedText", "()Ljava/lang/String;", "setEditedText", "(Ljava/lang/String;)V", "getMentionedUsersIds", "()Ljava/util/List;", "setMentionedUsersIds", "(Ljava/util/List;)V", "getMessageId", "setMessageId", "getMessageType", "()Lcom/mirrorflysdk/flycommons/models/MessageType;", "setMessageType", "(Lcom/mirrorflysdk/flycommons/models/MessageType;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class EditMessageParams implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull
    private com.mirrorflysdk.flycommons.models.MessageType messageType;
    @org.jetbrains.annotations.NotNull
    private java.lang.String messageId;
    @org.jetbrains.annotations.NotNull
    private java.lang.String editedText;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.String> mentionedUsersIds;
    public static final android.os.Parcelable.Creator<com.contusfly.models.EditMessageParams> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.models.EditMessageParams copy(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flycommons.models.MessageType messageType, @org.jetbrains.annotations.NotNull
    java.lang.String messageId, @org.jetbrains.annotations.NotNull
    java.lang.String editedText, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public EditMessageParams(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flycommons.models.MessageType messageType, @org.jetbrains.annotations.NotNull
    java.lang.String messageId, @org.jetbrains.annotations.NotNull
    java.lang.String editedText, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.flycommons.models.MessageType component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.flycommons.models.MessageType getMessageType() {
        return null;
    }
    
    public final void setMessageType(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flycommons.models.MessageType p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessageId() {
        return null;
    }
    
    public final void setMessageId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEditedText() {
        return null;
    }
    
    public final void setEditedText(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getMentionedUsersIds() {
        return null;
    }
    
    public final void setMentionedUsersIds(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.contusfly.models.EditMessageParams> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public final com.contusfly.models.EditMessageParams createFromParcel(@org.jetbrains.annotations.NotNull
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public final com.contusfly.models.EditMessageParams[] newArray(int size) {
            return null;
        }
    }
}