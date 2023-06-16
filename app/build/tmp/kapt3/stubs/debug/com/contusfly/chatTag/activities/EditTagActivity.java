package com.contusfly.chatTag.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u00104\u001a\u000205J\b\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u000205H\u0002J\b\u00108\u001a\u000205H\u0002J\u0006\u00109\u001a\u000205J\b\u0010:\u001a\u000205H\u0002J\u0012\u0010;\u001a\u0002052\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u000205H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R(\u0010)\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010+0+0*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\t\"\u0004\b3\u0010\u000b\u00a8\u0006?"}, d2 = {"Lcom/contusfly/chatTag/activities/EditTagActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "binding", "Lcom/contusfly/databinding/ActivityEditTagBinding;", "chatTagId", "getChatTagId", "()Ljava/lang/String;", "setChatTagId", "(Ljava/lang/String;)V", "chatTagadapter", "Lcom/contusfly/chatTag/adapter/EditChatTagAdapter;", "getChatTagadapter", "()Lcom/contusfly/chatTag/adapter/EditChatTagAdapter;", "setChatTagadapter", "(Lcom/contusfly/chatTag/adapter/EditChatTagAdapter;)V", "chatTagnamelist", "", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "getChatTagnamelist", "()Ljava/util/List;", "setChatTagnamelist", "(Ljava/util/List;)V", "deleteTagIdList", "Ljava/util/ArrayList;", "getDeleteTagIdList", "()Ljava/util/ArrayList;", "setDeleteTagIdList", "(Ljava/util/ArrayList;)V", "isRecommendedTag", "setRecommendedTag", "itemSelectedPosition", "", "getItemSelectedPosition", "()I", "setItemSelectedPosition", "(I)V", "mContext", "Landroid/content/Context;", "resultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "tagName", "getTagName", "setTagName", "chatTagAdapterset", "", "chatTagRemoveDialogShow", "createChatTagPageLaunch", "deleteChatTag", "getChatTagData", "onClickListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "recommendedChatTagCheking", "app_debug"})
public final class EditTagActivity extends androidx.appcompat.app.AppCompatActivity {
    private final java.lang.String TAG = null;
    private android.content.Context mContext;
    private com.contusfly.databinding.ActivityEditTagBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.mirrorflysdk.flydatabase.model.ChatTagModel> chatTagnamelist;
    public com.contusfly.chatTag.adapter.EditChatTagAdapter chatTagadapter;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String isRecommendedTag = "0";
    private int itemSelectedPosition = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String chatTagId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String tagName = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> deleteTagIdList;
    @org.jetbrains.annotations.NotNull()
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> resultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public EditTagActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mirrorflysdk.flydatabase.model.ChatTagModel> getChatTagnamelist() {
        return null;
    }
    
    public final void setChatTagnamelist(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mirrorflysdk.flydatabase.model.ChatTagModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.chatTag.adapter.EditChatTagAdapter getChatTagadapter() {
        return null;
    }
    
    public final void setChatTagadapter(@org.jetbrains.annotations.NotNull()
    com.contusfly.chatTag.adapter.EditChatTagAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String isRecommendedTag() {
        return null;
    }
    
    public final void setRecommendedTag(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getItemSelectedPosition() {
        return 0;
    }
    
    public final void setItemSelectedPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChatTagId() {
        return null;
    }
    
    public final void setChatTagId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTagName() {
        return null;
    }
    
    public final void setTagName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getDeleteTagIdList() {
        return null;
    }
    
    public final void setDeleteTagIdList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
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
    
    private final void deleteChatTag() {
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
    
    private final void chatTagRemoveDialogShow() {
    }
}