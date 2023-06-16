package com.contusfly.chatTag.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&J\b\u0010\'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0002J\u0006\u0010)\u001a\u00020&J\b\u0010*\u001a\u00020&H\u0002J\u0012\u0010+\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017\u00a8\u0006/"}, d2 = {"Lcom/contusfly/chatTag/activities/ChatTagActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "binding", "Lcom/contusfly/databinding/ActivityChatTagBinding;", "chatTagadapter", "Lcom/contusfly/chatTag/adapter/ChatTagAdapter;", "getChatTagadapter", "()Lcom/contusfly/chatTag/adapter/ChatTagAdapter;", "setChatTagadapter", "(Lcom/contusfly/chatTag/adapter/ChatTagAdapter;)V", "chatTagnamelist", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "getChatTagnamelist", "()Ljava/util/ArrayList;", "setChatTagnamelist", "(Ljava/util/ArrayList;)V", "isRecommendedTag", "()Ljava/lang/String;", "setRecommendedTag", "(Ljava/lang/String;)V", "mContext", "Landroid/content/Context;", "resultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "tagName", "getTagName", "setTagName", "chatTagAdapterset", "", "createChatTagPageLaunch", "editChatTagPageLaunch", "getChatTagData", "onClickListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "recommendedChatTagCheking", "app_debug"})
public final class ChatTagActivity extends androidx.appcompat.app.AppCompatActivity {
    private final java.lang.String TAG = null;
    private android.content.Context mContext;
    private com.contusfly.databinding.ActivityChatTagBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> chatTagnamelist;
    public com.contusfly.chatTag.adapter.ChatTagAdapter chatTagadapter;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String isRecommendedTag = "0";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String tagName = "";
    @org.jetbrains.annotations.NotNull()
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> resultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public ChatTagActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> getChatTagnamelist() {
        return null;
    }
    
    public final void setChatTagnamelist(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.chatTag.adapter.ChatTagAdapter getChatTagadapter() {
        return null;
    }
    
    public final void setChatTagadapter(@org.jetbrains.annotations.NotNull()
    com.contusfly.chatTag.adapter.ChatTagAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String isRecommendedTag() {
        return null;
    }
    
    public final void setRecommendedTag(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTagName() {
        return null;
    }
    
    public final void setTagName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void getChatTagData() {
    }
    
    private final void recommendedChatTagCheking() {
    }
    
    public final void chatTagAdapterset() {
    }
    
    private final void onClickListener() {
    }
    
    private final void editChatTagPageLaunch() {
    }
    
    private final void createChatTagPageLaunch() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getResultLauncher() {
        return null;
    }
    
    public final void setResultLauncher(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<android.content.Intent> p0) {
    }
}