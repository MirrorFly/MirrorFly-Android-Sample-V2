package com.contusfly.chatTag.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020\u0011H\u0002J\b\u00102\u001a\u00020\u0011H\u0002J\b\u00103\u001a\u00020.H\u0002JC\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082!\u00109\u001a\u001d\u0012\u0013\u0012\u001108\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020.0:2\u0006\u0010>\u001a\u000208H\u0002J\b\u0010?\u001a\u00020.H\u0002J\u0010\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020\u0011H\u0002J \u0010B\u001a\u00020.2\u0016\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`DH\u0016J\b\u0010E\u001a\u00020.H\u0002J\b\u0010F\u001a\u00020.H\u0002J\b\u0010G\u001a\u00020.H\u0002J\u0010\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020\u000eH\u0016J\b\u0010J\u001a\u00020.H\u0002J\u0012\u0010K\u001a\u00020.2\b\u0010L\u001a\u0004\u0018\u00010MH\u0014J\u001a\u0010N\u001a\u00020.2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020\u0011H\u0016J\u0010\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020\u0006H\u0002J \u0010T\u001a\u00020.2\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u0011H\u0016J\b\u0010W\u001a\u00020.H\u0002J\b\u0010X\u001a\u00020.H\u0002J\b\u0010Y\u001a\u00020.H\u0002J\u0010\u0010Z\u001a\u00020.2\u0006\u0010[\u001a\u00020\u0006H\u0002J\u0010\u0010\\\u001a\u00020.2\u0006\u0010A\u001a\u00020\u0011H\u0002J\b\u0010]\u001a\u00020.H\u0002J-\u0010^\u001a\u00020.*\u0002082!\u00109\u001a\u001d\u0012\u0013\u0012\u001108\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020.0:R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\u001f\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010\'\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u001c\u001a\u0004\b*\u0010+\u00a8\u0006_"}, d2 = {"Lcom/contusfly/chatTag/activities/CreateTagActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/contusfly/chatTag/interfaces/ChatTagClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "TAG", "", "binding", "Lcom/contusfly/databinding/ActivityCreateTagBinding;", "chatSelectedList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/models/RecentChat;", "chatTagId", "clickedTagPosition", "", "finalTagName", "isFromEditTagItem", "", "itemSelectedPosition", "mContext", "Landroid/content/Context;", "mDialog", "Lcom/contusfly/views/CommonAlertDialog;", "mSelectionAdapter", "Lcom/contusfly/chatTag/adapter/PeopleSelectionListAdapter;", "getMSelectionAdapter", "()Lcom/contusfly/chatTag/adapter/PeopleSelectionListAdapter;", "mSelectionAdapter$delegate", "Lkotlin/Lazy;", "memberIdlist", "preDefinedTag", "resultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "tagId", "viewModel", "Lcom/contusfly/chatTag/viewmodel/ChatTagViewModel;", "getViewModel", "()Lcom/contusfly/chatTag/viewmodel/ChatTagViewModel;", "viewModel$delegate", "addSelectedmemberList", "", "addpeoplePageLaunch", "alertDialogShow", "chatTagNameAlreadyExistCheck", "chatTagNameAlreadyExistCheckForUpdate", "createChatTagwithPeople", "drawableClick", "event", "Landroid/view/MotionEvent;", "v", "Landroid/widget/EditText;", "onClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "editText", "editTextDrawableClickListener", "editTextRightDrawableSet", "isSet", "filterListUpdated", "filterList", "Lkotlin/collections/ArrayList;", "getChatTagItems", "getIntentvalues", "initView", "listOptionSelected", "position", "onClickListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "removeSelectedmemberList", "selectedMemberid", "selectUnselectChat", "item", "isSelectionlist", "setObservers", "setSelectionListChatAdapter", "textChangeListener", "titlevalueChecking", "tagname", "toolbarTitleSet", "updateChatTagWithPeople", "onRightDrawableClicked", "app_debug"})
public final class CreateTagActivity extends androidx.appcompat.app.AppCompatActivity implements com.contusfly.chatTag.interfaces.ChatTagClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    private final java.lang.String TAG = null;
    private android.content.Context mContext;
    private com.contusfly.databinding.ActivityCreateTagBinding binding;
    private java.lang.String tagId = "";
    private java.util.ArrayList<java.lang.String> memberIdlist;
    private java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> chatSelectedList;
    private java.lang.String preDefinedTag = "";
    private boolean isFromEditTagItem = false;
    private java.lang.String chatTagId = "";
    private int clickedTagPosition = 0;
    private java.lang.String finalTagName;
    private com.contusfly.views.CommonAlertDialog mDialog;
    private int itemSelectedPosition = 0;
    private final kotlin.Lazy mSelectionAdapter$delegate = null;
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> resultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public CreateTagActivity() {
        super();
    }
    
    private final com.contusfly.chatTag.adapter.PeopleSelectionListAdapter getMSelectionAdapter() {
        return null;
    }
    
    private final com.contusfly.chatTag.viewmodel.ChatTagViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getIntentvalues() {
    }
    
    private final void getChatTagItems() {
    }
    
    private final void setObservers() {
    }
    
    private final void initView() {
    }
    
    private final void setSelectionListChatAdapter() {
    }
    
    private final void onClickListener() {
    }
    
    private final void textChangeListener() {
    }
    
    private final void titlevalueChecking(java.lang.String tagname) {
    }
    
    private final void editTextRightDrawableSet(boolean isSet) {
    }
    
    private final void editTextDrawableClickListener() {
    }
    
    public final void onRightDrawableClicked(@org.jetbrains.annotations.NotNull
    android.widget.EditText $this$onRightDrawableClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.widget.EditText, kotlin.Unit> onClicked) {
    }
    
    private final boolean drawableClick(android.view.MotionEvent event, android.widget.EditText v, kotlin.jvm.functions.Function1<? super android.widget.EditText, kotlin.Unit> onClicked, android.widget.EditText editText) {
        return false;
    }
    
    private final void toolbarTitleSet(boolean isSet) {
    }
    
    private final void updateChatTagWithPeople() {
    }
    
    private final void createChatTagwithPeople() {
    }
    
    private final boolean chatTagNameAlreadyExistCheck() {
        return false;
    }
    
    private final boolean chatTagNameAlreadyExistCheckForUpdate() {
        return false;
    }
    
    private final void addpeoplePageLaunch() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getResultLauncher() {
        return null;
    }
    
    public final void setResultLauncher(@org.jetbrains.annotations.NotNull
    androidx.activity.result.ActivityResultLauncher<android.content.Intent> p0) {
    }
    
    private final void addSelectedmemberList() {
    }
    
    private final void removeSelectedmemberList(java.lang.String selectedMemberid) {
    }
    
    @java.lang.Override
    public void selectUnselectChat(int position, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.RecentChat item, boolean isSelectionlist) {
    }
    
    @java.lang.Override
    public void filterListUpdated(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> filterList) {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    private final void alertDialogShow() {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
}