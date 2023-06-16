package com.contusfly.activities.parent;

import java.lang.System;

/**
 * The class BaseMessageInfoActivity shows single/group chat message in common.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@android.annotation.SuppressLint(value = {"Registered"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J8\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J8\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020A2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\"\u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020=2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010G\u001a\u00020=H\u0002J\"\u0010H\u001a\u0002002\u0006\u0010F\u001a\u00020=2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010I\u001a\u00020\u0005H\u0002J\u0010\u0010J\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\u00112\u0006\u0010L\u001a\u00020.H\u0002J\u0012\u0010M\u001a\u00020N2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0002J\u001a\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010\u001f2\u0006\u0010Q\u001a\u00020\u0011H\u0002J\u0010\u0010R\u001a\u0002002\u0006\u0010L\u001a\u00020.H\u0002J\u0010\u0010S\u001a\u0002002\u0006\u0010T\u001a\u00020(H\u0016J\u0012\u0010U\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010V\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010W\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010X\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010Y\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u001a\u0010Z\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010[\u001a\u00020\\H\u0002J\u001a\u0010]\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010^\u001a\u00020_H\u0002J\u0012\u0010`\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010a\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010b\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J0\u0010c\u001a\u0002002\u0006\u0010d\u001a\u00020=2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020A2\u0006\u0010e\u001a\u00020\u001fH\u0002J\b\u0010f\u001a\u000200H\u0016J\u0012\u0010g\u001a\u0002002\b\u0010h\u001a\u0004\u0018\u00010iH\u0014J\u001a\u0010j\u001a\u0002002\b\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010m\u001a\u00020:H\u0016J\b\u0010n\u001a\u000200H\u0016J\u0012\u0010o\u001a\u0002002\b\u0010h\u001a\u0004\u0018\u00010iH\u0014J8\u0010p\u001a\u0002002\u0006\u0010d\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020A2\u0006\u0010e\u001a\u00020\u001fH\u0002J\u0018\u0010q\u001a\u0002002\u0006\u0010F\u001a\u00020=2\u0006\u0010L\u001a\u00020.H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u001a\u0010\'\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006r"}, d2 = {"Lcom/contusfly/activities/parent/BaseMessageInfoActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "captionStar", "Landroid/widget/ImageView;", "getCaptionStar", "()Landroid/widget/ImageView;", "setCaptionStar", "(Landroid/widget/ImageView;)V", "chatClickUtils", "Lcom/contusfly/utils/ChatClickUtils;", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "decodeUtils", "Lcom/contusfly/utils/DecodeImageUtils;", "groupJid", "", "getGroupJid", "()Ljava/lang/String;", "setGroupJid", "(Ljava/lang/String;)V", "imgChatStatus", "getImgChatStatus", "setImgChatStatus", "imgFav", "getImgFav", "setImgFav", "mMediaController", "Lcom/contusfly/chat/MediaController;", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "getMessage", "()Lcom/mirrorflysdk/api/models/ChatMessage;", "setMessage", "(Lcom/mirrorflysdk/api/models/ChatMessage;)V", "msgId", "getMsgId", "setMsgId", "seekerPos", "", "getSeekerPos", "()I", "setSeekerPos", "(I)V", "selectedContactMessage", "Lcom/mirrorflysdk/api/models/ContactChatMessage;", "audioPlayClick", "", "filePath", "duration", "", "playImage", "seekBar", "Landroid/widget/SeekBar;", "durationView", "Landroidx/appcompat/widget/AppCompatTextView;", "doesSentMessage", "", "checkAndEnableReplyView", "replyLayout", "Landroid/view/View;", "txtUsername", "Lcom/contusfly/views/CustomTextView;", "imgIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "txtChat", "Lcom/contusfly/views/MessageTextView;", "imgImageVideo", "doOnClick", "view", "itemView", "doOnImageClick", "imgView", "getHtmlChatMessageText", "getJidFromSharedContact", "contactMessage", "getSpannedText", "Landroid/text/Spanned;", "handleContactClick", "clickedMessage", "registeredJid", "inviteUserDialog", "listOptionSelected", "position", "loadAudioItem", "loadContactItem", "loadFileItem", "loadImageItem", "loadLocation", "loadMediaMessageView", "messageType", "Lcom/mirrorflysdk/flycommons/models/MessageType;", "loadMessageTime", "txtTime", "Landroid/widget/TextView;", "loadMessageView", "loadTextItem", "loadVideoItem", "mediaReplyView", "layout", "replyChatMessage", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onPause", "onPostCreate", "replyView", "setInviteClickListener", "app_debug"})
public class BaseMessageInfoActivity extends com.contusfly.activities.BaseActivity implements com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    
    /**
     * Display the receipt status of the message, it may be clock, delivered, ack or seen
     */
    @org.jetbrains.annotations.Nullable()
    private android.widget.ImageView imgChatStatus;
    @org.jetbrains.annotations.Nullable()
    private android.widget.ImageView imgFav;
    @org.jetbrains.annotations.Nullable()
    private android.widget.ImageView captionStar;
    
    /**
     * Message id to load the message info
     */
    @org.jetbrains.annotations.Nullable()
    private java.lang.String msgId;
    
    /**
     * for audion seeker  position
     */
    private int seekerPos = 0;
    
    /**
     * Instance of the Message which info is displayed in this activity
     */
    @org.jetbrains.annotations.Nullable()
    private com.mirrorflysdk.api.models.ChatMessage message;
    
    /**
     * Instance of the chat utils class that contains the common chat methods
     */
    private com.contusfly.utils.ChatClickUtils chatClickUtils;
    
    /**
     * The media controller which used to play the audio in the chat view
     */
    private com.contusfly.chat.MediaController mMediaController;
    private com.contusfly.utils.DecodeImageUtils decodeUtils;
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    
    /**
     * contact msg for invite
     */
    private com.mirrorflysdk.api.models.ContactChatMessage selectedContactMessage;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String groupJid;
    private java.util.HashMap _$_findViewCache;
    
    public BaseMessageInfoActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ImageView getImgChatStatus() {
        return null;
    }
    
    public final void setImgChatStatus(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ImageView getImgFav() {
        return null;
    }
    
    public final void setImgFav(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ImageView getCaptionStar() {
        return null;
    }
    
    public final void setCaptionStar(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsgId() {
        return null;
    }
    
    public final void setMsgId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getSeekerPos() {
        return 0;
    }
    
    public final void setSeekerPos(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mirrorflysdk.api.models.ChatMessage getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGroupJid() {
        return null;
    }
    
    public final void setGroupJid(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onPostCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDialogClosed(@org.jetbrains.annotations.Nullable()
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void listOptionSelected(int position) {
    }
    
    /**
     * Load the message based on the message type in the view
     *
     * @param message Message of the loading item
     */
    private final void loadMessageView(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Display the text message on the view
     *
     * @param message       Message instance of the info message
     */
    private final void loadTextItem(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Display the location message on the view
     *
     * @param message       Message instance of the info message
     */
    private final void loadLocation(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Display the contact message on the view
     *
     * @param message       Message instance of the info message
     */
    private final void loadContactItem(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Handle contact message item click
     *
     * @param clickedMessage Message of the item in view
     */
    private final void handleContactClick(com.mirrorflysdk.api.models.ChatMessage clickedMessage, java.lang.String registeredJid) {
    }
    
    /**
     * handle contact invite click
     * @param view
     * @param contactMessage
     */
    private final void setInviteClickListener(android.view.View view, com.mirrorflysdk.api.models.ContactChatMessage contactMessage) {
    }
    
    private final void inviteUserDialog(com.mirrorflysdk.api.models.ContactChatMessage contactMessage) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    private final java.lang.String getJidFromSharedContact(com.mirrorflysdk.api.models.ContactChatMessage contactMessage) {
        return null;
    }
    
    /**
     * Load the media message based on the message type in the view
     *
     * @param message       Displaying message
     * @param messageType   Type of the message
     */
    private final void loadMediaMessageView(com.mirrorflysdk.api.models.ChatMessage message, com.mirrorflysdk.flycommons.models.MessageType messageType) {
    }
    
    /**
     * Display the Time of message on the view
     *
     * @param message Message item contains message data
     * @param txtTime Time of the message
     */
    private final void loadMessageTime(com.mirrorflysdk.api.models.ChatMessage message, android.widget.TextView txtTime) {
    }
    
    /**
     * The handler to perform the click event.
     *
     * @param view          the view which receives the click event.
     * @param message       the message object to be processed for the click event.
     * @param itemView      the child item inside the view.
     */
    private final void doOnClick(android.view.View view, com.mirrorflysdk.api.models.ChatMessage message, android.view.View itemView) {
    }
    
    /**
     * Display the image message on the view
     *
     * @param message       Message instance of the info message
     */
    private final void loadImageItem(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Display the video message on the view
     *
     * @param message       Message instance of the info message
     */
    private final void loadVideoItem(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Display the audio message on the view
     *
     * @param message Message instance of the info message
     */
    private final void loadAudioItem(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Display the file message on the view
     *
     * @param message Message instance of the info message
     */
    private final void loadFileItem(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * The handler to perform the click event.
     *
     * @param view          the view which receives the click event.
     * @param message       the message object to be processed for the click event.
     * @param imgView       the child image view.
     */
    private final void doOnImageClick(android.view.View view, com.mirrorflysdk.api.models.ChatMessage message, android.widget.ImageView imgView) {
    }
    
    /**
     * Handle the audio play click
     *
     * @param filePath        Local path of the audio
     * @param duration        Local file duration
     * @param playImage       Play button of the audio view
     * @param seekBar         Seek bar of the audio
     * @param durationView    Duration text view
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * chat activity.
     */
    private final void audioPlayClick(java.lang.String filePath, long duration, android.widget.ImageView playImage, android.widget.SeekBar seekBar, androidx.appcompat.widget.AppCompatTextView durationView, boolean doesSentMessage) {
    }
    
    private final void replyView(android.view.View layout, com.contusfly.views.CustomTextView txtUsername, androidx.appcompat.widget.AppCompatImageView imgIcon, com.contusfly.views.MessageTextView txtChat, androidx.appcompat.widget.AppCompatImageView imgImageVideo, com.mirrorflysdk.api.models.ChatMessage replyChatMessage) {
    }
    
    private final void mediaReplyView(android.view.View layout, androidx.appcompat.widget.AppCompatImageView imgIcon, com.contusfly.views.MessageTextView txtChat, androidx.appcompat.widget.AppCompatImageView imgImageVideo, com.mirrorflysdk.api.models.ChatMessage replyChatMessage) {
    }
    
    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    private final android.text.Spanned getSpannedText(java.lang.String message) {
        return null;
    }
    
    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in
     * FrameLayout
     *
     * @param message Message content
     * @return Spanned Result spanned text with space
     */
    private final java.lang.String getHtmlChatMessageText(java.lang.String message) {
        return null;
    }
    
    private final void checkAndEnableReplyView(android.view.View replyLayout, com.contusfly.views.CustomTextView txtUsername, androidx.appcompat.widget.AppCompatImageView imgIcon, com.contusfly.views.MessageTextView txtChat, androidx.appcompat.widget.AppCompatImageView imgImageVideo, com.mirrorflysdk.api.models.ChatMessage message) {
    }
}