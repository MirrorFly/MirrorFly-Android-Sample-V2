package com.contusfly.chatTag.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020)H\u0002J\u0006\u0010/\u001a\u00020)J\b\u00100\u001a\u00020)H\u0002J\u0012\u00101\u001a\u00020)2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\b\u00104\u001a\u00020)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\t\"\u0004\b\'\u0010\u000b\u00a8\u00066"}, d2 = {"Lcom/contusfly/chatTag/activities/ChatTagActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "binding", "Lcom/contusfly/databinding/ActivityChatTagBinding;", "chatTagId", "getChatTagId", "()Ljava/lang/String;", "setChatTagId", "(Ljava/lang/String;)V", "chatTagadapter", "Lcom/contusfly/chatTag/adapter/ChatTagAdapter;", "getChatTagadapter", "()Lcom/contusfly/chatTag/adapter/ChatTagAdapter;", "setChatTagadapter", "(Lcom/contusfly/chatTag/adapter/ChatTagAdapter;)V", "chatTagnamelist", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "getChatTagnamelist", "()Ljava/util/ArrayList;", "setChatTagnamelist", "(Ljava/util/ArrayList;)V", "isRecommendedTag", "setRecommendedTag", "mContext", "Landroid/content/Context;", "resultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "tagName", "getTagName", "setTagName", "chatTagAdapterset", "", "createChatTagPageLaunch", "editChatTagItemsPageLaunch", "chatTagPosition", "", "editChatTagPageLaunch", "getChatTagData", "onClickListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "recommendedChatTagCheking", "Companion", "app_debug"})
public final class ChatTagActivity extends androidx.appcompat.app.AppCompatActivity {
    private final java.lang.String TAG = null;
    private android.content.Context mContext;
    private com.contusfly.databinding.ActivityChatTagBinding binding;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.chatTag.activities.ChatTagActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> createdChatTagList;
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<java.lang.String> chatTagMemberIdList;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> chatTagnamelist;
    public com.contusfly.chatTag.adapter.ChatTagAdapter chatTagadapter;
    @org.jetbrains.annotations.NotNull
    private java.lang.String isRecommendedTag = "0";
    @org.jetbrains.annotations.NotNull
    private java.lang.String tagName = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String chatTagId = "";
    @org.jetbrains.annotations.NotNull
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> resultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public ChatTagActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> getChatTagnamelist() {
        return null;
    }
    
    public final void setChatTagnamelist(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.chatTag.adapter.ChatTagAdapter getChatTagadapter() {
        return null;
    }
    
    public final void setChatTagadapter(@org.jetbrains.annotations.NotNull
    com.contusfly.chatTag.adapter.ChatTagAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String isRecommendedTag() {
        return null;
    }
    
    public final void setRecommendedTag(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTagName() {
        return null;
    }
    
    public final void setTagName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChatTagId() {
        return null;
    }
    
    public final void setChatTagId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
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
    
    private final void editChatTagItemsPageLaunch(int chatTagPosition) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getResultLauncher() {
        return null;
    }
    
    public final void setResultLauncher(@org.jetbrains.annotations.NotNull
    androidx.activity.result.ActivityResultLauncher<android.content.Intent> p0) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/contusfly/chatTag/activities/ChatTagActivity$Companion;", "", "()V", "chatTagMemberIdList", "Ljava/util/ArrayList;", "", "getChatTagMemberIdList", "()Ljava/util/ArrayList;", "setChatTagMemberIdList", "(Ljava/util/ArrayList;)V", "createdChatTagList", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "getCreatedChatTagList", "setCreatedChatTagList", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> getCreatedChatTagList() {
            return null;
        }
        
        public final void setCreatedChatTagList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<java.lang.String> getChatTagMemberIdList() {
            return null;
        }
        
        public final void setChatTagMemberIdList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<java.lang.String> p0) {
        }
    }
}