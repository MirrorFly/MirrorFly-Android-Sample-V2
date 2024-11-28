package com.contusfly.chatTag.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J \u0010#\u001a\u00020!2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`%H\u0016J\b\u0010&\u001a\u00020!H\u0002J\b\u0010\'\u001a\u00020!H\u0002J\u0018\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`%H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0016J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020!H\u0002J\u0018\u00100\u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\nH\u0002J\u0018\u00104\u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\nH\u0002J \u00105\u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\n2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020!H\u0002J\b\u00109\u001a\u00020!H\u0002J\b\u0010:\u001a\u00020!H\u0002J\b\u0010;\u001a\u00020!H\u0002J\b\u0010<\u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006="}, d2 = {"Lcom/contusfly/chatTag/activities/AddPeopleActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/contusfly/chatTag/interfaces/ChatTagClickListener;", "()V", "TAG", "", "binding", "Lcom/contusfly/databinding/ActivityAddPeopleBinding;", "chatSelectedList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/models/RecentChat;", "emptyView", "Landroid/widget/TextView;", "mAdapter", "Lcom/contusfly/chatTag/adapter/PeoplelistAdapter;", "getMAdapter", "()Lcom/contusfly/chatTag/adapter/PeoplelistAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "mContext", "Landroid/content/Context;", "mSelectionAdapter", "Lcom/contusfly/chatTag/adapter/PeopleSelectionListAdapter;", "getMSelectionAdapter", "()Lcom/contusfly/chatTag/adapter/PeopleSelectionListAdapter;", "mSelectionAdapter$delegate", "recentChatList", "viewModel", "Lcom/contusfly/chatTag/viewmodel/ChatTagViewModel;", "getViewModel", "()Lcom/contusfly/chatTag/viewmodel/ChatTagViewModel;", "viewModel$delegate", "addButtonEnableDisable", "", "emptyDataChecking", "filterListUpdated", "filterList", "Lkotlin/collections/ArrayList;", "getChatlist", "getIntentvalues", "getPrivateChatList", "initView", "observer", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onclickListener", "peopleAlreadySelectionChecking", "position", "", "item", "peopleSelectionChecking", "selectUnselectChat", "isSelectionlist", "", "selectionListChecking", "setRecentChatAdapter", "setResult", "setSelectionListChatAdapter", "textChangeListener", "app_debug"})
public final class AddPeopleActivity extends androidx.appcompat.app.AppCompatActivity implements com.contusfly.chatTag.interfaces.ChatTagClickListener {
    private final java.lang.String TAG = null;
    private android.content.Context mContext;
    private com.contusfly.databinding.ActivityAddPeopleBinding binding;
    private android.widget.TextView emptyView;
    private java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> recentChatList;
    private java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> chatSelectedList;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy mAdapter$delegate = null;
    private final kotlin.Lazy mSelectionAdapter$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public AddPeopleActivity() {
        super();
    }
    
    private final com.contusfly.chatTag.viewmodel.ChatTagViewModel getViewModel() {
        return null;
    }
    
    private final com.contusfly.chatTag.adapter.PeoplelistAdapter getMAdapter() {
        return null;
    }
    
    private final com.contusfly.chatTag.adapter.PeopleSelectionListAdapter getMSelectionAdapter() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getIntentvalues() {
    }
    
    private final void initView() {
    }
    
    private final void setRecentChatAdapter() {
    }
    
    private final void setSelectionListChatAdapter() {
    }
    
    private final void getChatlist() {
    }
    
    private final void observer() {
    }
    
    private final java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> getPrivateChatList() {
        return null;
    }
    
    private final void onclickListener() {
    }
    
    private final void textChangeListener() {
    }
    
    @java.lang.Override
    public void selectUnselectChat(int position, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.RecentChat item, boolean isSelectionlist) {
    }
    
    private final void peopleSelectionChecking(int position, com.mirrorflysdk.api.models.RecentChat item) {
    }
    
    private final void peopleAlreadySelectionChecking(int position, com.mirrorflysdk.api.models.RecentChat item) {
    }
    
    @java.lang.Override
    public void filterListUpdated(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> filterList) {
    }
    
    private final void addButtonEnableDisable() {
    }
    
    private final void selectionListChecking() {
    }
    
    private final void emptyDataChecking() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    private final void setResult() {
    }
}