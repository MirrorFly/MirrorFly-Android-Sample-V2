package com.contusfly.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\u0002\u0010\tB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rB5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0010B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0014BG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\u0002\u0010\u0017B9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u001cB?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\u0002\u0010\u001eB5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\u001f\u001a\u00020 \u00a2\u0006\u0002\u0010!B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u00a2\u0006\u0002\u0010#J\t\u0010Q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\u0003H\u00c6\u0003J\t\u0010U\u001a\u00020\u0019H\u00c6\u0003J\t\u0010V\u001a\u00020\u001bH\u00c6\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00c6\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010 H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010[\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\\\u001a\u00020\u000bH\u00c6\u0003J\t\u0010]\u001a\u00020\u000bH\u00c6\u0003J\t\u0010^\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00c6\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u00b9\u0001\u0010a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u00c6\u0001J\u0013\u0010b\u001a\u00020\u001b2\b\u0010c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010d\u001a\u00020eH\u00d6\u0001J\t\u0010f\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\"\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010:\"\u0004\b;\u0010<R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010>\"\u0004\bB\u0010@R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u00101\"\u0004\bH\u00103R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010)\"\u0004\bJ\u0010+R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010)\"\u0004\bL\u0010+R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010)\"\u0004\bN\u0010+R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010)\"\u0004\bP\u0010+\u00a8\u0006g"}, d2 = {"Lcom/contusfly/models/MessageObject;", "", "toJid", "", "messageType", "textMessage", "replyMessageId", "mentionedUsersIds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "latitude", "", "longitude", "(Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;)V", "contactName", "contactNumbers", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "file", "Ljava/io/File;", "fileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V", "imageCaption", "base64Thumbnail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/util/List;)V", "audioDuration", "", "isAudioRecorded", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;JZLjava/lang/String;)V", "videoCaption", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/util/List;)V", "meetMessageParams", "Lcom/contusfly/models/MeetMessageParams;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/contusfly/models/MeetMessageParams;)V", "caption", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/util/List;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/util/List;Lcom/contusfly/models/MeetMessageParams;)V", "getAudioDuration", "()J", "setAudioDuration", "(J)V", "getBase64Thumbnail", "()Ljava/lang/String;", "setBase64Thumbnail", "(Ljava/lang/String;)V", "getCaption", "setCaption", "getContactName", "setContactName", "getContactNumbers", "()Ljava/util/List;", "setContactNumbers", "(Ljava/util/List;)V", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "getFileName", "setFileName", "()Z", "setAudioRecorded", "(Z)V", "getLatitude", "()D", "setLatitude", "(D)V", "getLongitude", "setLongitude", "getMeetMessageParams", "()Lcom/contusfly/models/MeetMessageParams;", "setMeetMessageParams", "(Lcom/contusfly/models/MeetMessageParams;)V", "getMentionedUsersIds", "setMentionedUsersIds", "getMessageType", "setMessageType", "getReplyMessageId", "setReplyMessageId", "getTextMessage", "setTextMessage", "getToJid", "setToJid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class MessageObject {
    @org.jetbrains.annotations.NotNull
    private java.lang.String toJid;
    @org.jetbrains.annotations.NotNull
    private java.lang.String messageType;
    @org.jetbrains.annotations.NotNull
    private java.lang.String textMessage;
    @org.jetbrains.annotations.NotNull
    private java.lang.String replyMessageId;
    private double latitude;
    private double longitude;
    @org.jetbrains.annotations.NotNull
    private java.lang.String contactName;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.String> contactNumbers;
    @org.jetbrains.annotations.Nullable
    private java.io.File file;
    @org.jetbrains.annotations.NotNull
    private java.lang.String fileName;
    @org.jetbrains.annotations.NotNull
    private java.lang.String caption;
    @org.jetbrains.annotations.NotNull
    private java.lang.String base64Thumbnail;
    private long audioDuration;
    private boolean isAudioRecorded;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.String> mentionedUsersIds;
    @org.jetbrains.annotations.Nullable
    private com.contusfly.models.MeetMessageParams meetMessageParams;
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.models.MessageObject copy(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String textMessage, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId, double latitude, double longitude, @org.jetbrains.annotations.NotNull
    java.lang.String contactName, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> contactNumbers, @org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.NotNull
    java.lang.String fileName, @org.jetbrains.annotations.NotNull
    java.lang.String caption, @org.jetbrains.annotations.NotNull
    java.lang.String base64Thumbnail, long audioDuration, boolean isAudioRecorded, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds, @org.jetbrains.annotations.Nullable
    com.contusfly.models.MeetMessageParams meetMessageParams) {
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
    
    public MessageObject(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String textMessage, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId, double latitude, double longitude, @org.jetbrains.annotations.NotNull
    java.lang.String contactName, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> contactNumbers, @org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.NotNull
    java.lang.String fileName, @org.jetbrains.annotations.NotNull
    java.lang.String caption, @org.jetbrains.annotations.NotNull
    java.lang.String base64Thumbnail, long audioDuration, boolean isAudioRecorded, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds, @org.jetbrains.annotations.Nullable
    com.contusfly.models.MeetMessageParams meetMessageParams) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getToJid() {
        return null;
    }
    
    public final void setToJid(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessageType() {
        return null;
    }
    
    public final void setMessageType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTextMessage() {
        return null;
    }
    
    public final void setTextMessage(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getReplyMessageId() {
        return null;
    }
    
    public final void setReplyMessageId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double getLatitude() {
        return 0.0;
    }
    
    public final void setLatitude(double p0) {
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double getLongitude() {
        return 0.0;
    }
    
    public final void setLongitude(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContactName() {
        return null;
    }
    
    public final void setContactName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getContactNumbers() {
        return null;
    }
    
    public final void setContactNumbers(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.io.File component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.Nullable
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFileName() {
        return null;
    }
    
    public final void setFileName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCaption() {
        return null;
    }
    
    public final void setCaption(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBase64Thumbnail() {
        return null;
    }
    
    public final void setBase64Thumbnail(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final long component13() {
        return 0L;
    }
    
    public final long getAudioDuration() {
        return 0L;
    }
    
    public final void setAudioDuration(long p0) {
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final boolean isAudioRecorded() {
        return false;
    }
    
    public final void setAudioRecorded(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getMentionedUsersIds() {
        return null;
    }
    
    public final void setMentionedUsersIds(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.models.MeetMessageParams component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.models.MeetMessageParams getMeetMessageParams() {
        return null;
    }
    
    public final void setMeetMessageParams(@org.jetbrains.annotations.Nullable
    com.contusfly.models.MeetMessageParams p0) {
    }
    
    /**
     * Text Message Constructor
     */
    public MessageObject(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String textMessage, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds) {
        super();
    }
    
    /**
     * Location Message Constructor
     */
    public MessageObject(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, double latitude, double longitude, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId) {
        super();
    }
    
    /**
     * Contact Message Constructor
     */
    public MessageObject(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String contactName, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> contactNumbers, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId) {
        super();
    }
    
    /**
     * Document Message Constructor
     */
    public MessageObject(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.NotNull
    java.lang.String fileName, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId) {
        super();
    }
    
    /**
     * Image Message Constructor
     */
    public MessageObject(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String imageCaption, @org.jetbrains.annotations.NotNull
    java.lang.String base64Thumbnail, @org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds) {
        super();
    }
    
    /**
     * Audio Message Constructor
     */
    public MessageObject(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.Nullable
    java.io.File file, long audioDuration, boolean isAudioRecorded, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId) {
        super();
    }
    
    /**
     * Video Message Constructor
     */
    public MessageObject(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String videoCaption, @org.jetbrains.annotations.Nullable
    java.io.File file, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds) {
        super();
    }
    
    /**
     * Meet Message Constructor
     */
    public MessageObject(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds, @org.jetbrains.annotations.NotNull
    com.contusfly.models.MeetMessageParams meetMessageParams) {
        super();
    }
}