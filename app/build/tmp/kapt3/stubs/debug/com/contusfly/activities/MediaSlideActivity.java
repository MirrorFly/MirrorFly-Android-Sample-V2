package com.contusfly.activities;

import java.lang.System;

/**
 * Which used to display the media files between users or group in slider
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/contusfly/activities/MediaSlideActivity;", "Lcom/contusfly/activities/BaseActivity;", "()V", "mediaMessages", "", "Lcom/mirrorflysdk/api/models/ChatMessage;", "mediaSliderAdapter", "Lcom/contusfly/adapters/MediaSliderAdapter;", "messageData", "Ljava/util/ArrayList;", "messageId", "", "msgType", "Lcom/mirrorflysdk/flycommons/models/MessageType;", "pos", "", "rosterId", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "isMediaLoaded", "", "message", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onMessageEvent", "messageEvent", "Lcom/contusfly/models/PrivateChatAuthenticationModel;", "onMessageStatusUpdated", "msgId", "onStart", "onStop", "setToolbar", "isSender", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "app_debug"})
public final class MediaSlideActivity extends com.contusfly.activities.BaseActivity {
    private java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> messageData;
    private com.mirrorflysdk.flycommons.models.MessageType msgType;
    private java.util.List<com.mirrorflysdk.api.models.ChatMessage> mediaMessages;
    private int pos = 0;
    private com.contusfly.adapters.MediaSliderAdapter mediaSliderAdapter;
    private androidx.viewpager.widget.ViewPager viewPager;
    private java.lang.String rosterId;
    private java.lang.String messageId;
    private java.util.HashMap _$_findViewCache;
    
    public MediaSlideActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onMessageStatusUpdated(@org.jetbrains.annotations.NotNull
    java.lang.String msgId) {
    }
    
    /**
     * Handle Toolbar Title
     *
     * @param isSender LayoutView
     * @param toolbar  Toolbar
     */
    private final void setToolbar(boolean isSender, androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    /**
     * Checks whether media content downloaded/uploaded
     *
     * @param message Message item
     * @return boolean Returns true if media content downloaded/uploaded
     */
    private final boolean isMediaLoaded(com.mirrorflysdk.api.models.ChatMessage message) {
        return false;
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(@org.jetbrains.annotations.Nullable
    com.contusfly.models.PrivateChatAuthenticationModel messageEvent) {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onStop() {
    }
}