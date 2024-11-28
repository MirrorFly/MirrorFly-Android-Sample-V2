package com.contusfly.call.groupcall;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 O2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002NOB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bJ \u0010\u001d\u001a\u00020\u001b2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001fj\b\u0012\u0004\u0012\u00020\u000b` H\u0007J\b\u0010!\u001a\u00020\u0007H\u0016J$\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001c\u0010\'\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0006\u0010(\u001a\u00020\u001bJ\u001c\u0010)\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0017J*\u0010)\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u00072\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0010H\u0016J\u001c\u0010,\u001a\u00060\u0002R\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0007H\u0016J\u0014\u00100\u001a\u00020\u001b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001b02J\u001a\u00103\u001a\u00020\u001b2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b04J\u000e\u00105\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bJ\u001c\u00106\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001c\u00107\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0018\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u001c\u0010;\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J\u000e\u0010<\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010=\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010>\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001c\u0010?\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001c\u0010@\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001c\u0010A\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001c\u0010B\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010C\u001a\u00020\u0007H\u0002J\u001c\u0010D\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0014\u0010E\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u0000H\u0002J\u001c\u0010F\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001c\u0010G\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010C\u001a\u00020\u0007H\u0002J\u0010\u0010G\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u0007H\u0002J\u001c\u0010H\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0003J\u001c\u0010I\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J$\u0010J\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0002J\u001c\u0010L\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001c\u0010M\u001a\u00020\u001b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00160\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006P"}, d2 = {"Lcom/contusfly/call/groupcall/GroupCallGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/call/groupcall/GroupCallGridAdapter$CallUserGridViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actualScreenHeight", "", "actualScreenWidth", "callUsersGridSurfaceViews", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/mirrorflysdk/flycall/webrtc/TextureViewRenderer;", "getContext", "()Landroid/content/Context;", "gridCallUserList", "", "getGridCallUserList", "()Ljava/util/List;", "setGridCallUserList", "(Ljava/util/List;)V", "surfaceViewGridStatusMap", "", "viewHeight", "getViewHeight", "()I", "addUser", "", "userJid", "addUsers", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "handlePayload", "bundle", "Landroid/os/Bundle;", "holder", "position", "hideSurface", "hideUserSurfaceView", "onBindViewHolder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onTapOnRecyclerView", "fn", "Lkotlin/Function0;", "onUserPinnedGridView", "Lkotlin/Function1;", "removeUser", "setLocalUserInfo", "setMirrorView", "setPinnedUserView", "imageGridPinned", "Landroid/widget/ImageView;", "setRemoteUserInfo", "setScreenHeight", "setScreenWidth", "setSurfaceViewToVideoSink", "setUpAudioMuted", "setUpVideoMuted", "setUserInfo", "showStatusInView", "index", "showSurface", "swapSurfaceViewToVideoSink", "unSwapSurfaceViewToVideoSink", "updateGridConnectionStatus", "updateGridPinnedPosition", "updatePoorNetworkIndicator", "updateUserSpeaking", "audioLevel", "updateUserStoppedSpeaking", "updateViewSize", "CallUserGridViewHolder", "Companion", "app_debug"})
public final class GroupCallGridAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    
    /**
     * The call user list to display in the recycler view.
     */
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.String> gridCallUserList;
    private int actualScreenHeight = 0;
    private int actualScreenWidth = 0;
    
    /**
     * Surface views map
     */
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mirrorflysdk.flycall.webrtc.TextureViewRenderer> callUsersGridSurfaceViews;
    
    /**
     * contains the surface view initialisation status
     */
    private java.util.concurrent.ConcurrentHashMap<com.mirrorflysdk.flycall.webrtc.TextureViewRenderer, java.lang.Boolean> surfaceViewGridStatusMap;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.call.groupcall.GroupCallGridAdapter.Companion Companion = null;
    private static final java.lang.String TAG = null;
    public static kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onPinnedGridView;
    public static kotlin.jvm.functions.Function0<kotlin.Unit> onTapOnRecyclerView;
    
    public GroupCallGridAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getGridCallUserList() {
        return null;
    }
    
    public final void setGridCallUserList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> p0) {
    }
    
    public final void onUserPinnedGridView(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> fn) {
    }
    
    public final void onTapOnRecyclerView(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> fn) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    private final void updateGridPinnedPosition(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    private final void setPinnedUserView(android.widget.ImageView imageGridPinned, java.lang.String userJid) {
    }
    
    private final void setMirrorView(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    private final void setUpAudioMuted(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    private final void setUpVideoMuted(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    private final void setUserInfo(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    private final void setLocalUserInfo(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    private final void setRemoteUserInfo(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    private final void setSurfaceViewToVideoSink(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    private final void swapSurfaceViewToVideoSink(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder) {
    }
    
    private final void unSwapSurfaceViewToVideoSink(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Object> payloads) {
    }
    
    private final void handlePayload(android.os.Bundle bundle, com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    private final void hideSurface(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, java.lang.String userJid) {
    }
    
    private final void showSurface(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, java.lang.String userJid) {
    }
    
    private final void updateViewSize(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    private final int getViewHeight() {
        return 0;
    }
    
    public final void addUser(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void addUsers(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> userList) {
    }
    
    private final void updateGridConnectionStatus(int index) {
    }
    
    private final void updateGridConnectionStatus(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int index) {
    }
    
    private final void showStatusInView(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int index) {
    }
    
    public final void removeUser(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    public final void hideUserSurfaceView() {
    }
    
    private final void updateUserSpeaking(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position, int audioLevel) {
    }
    
    private final void updateUserStoppedSpeaking(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    public final void setScreenHeight(int actualScreenHeight) {
    }
    
    public final void setScreenWidth(int actualScreenWidth) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    private final void updatePoorNetworkIndicator(com.contusfly.call.groupcall.GroupCallGridAdapter.CallUserGridViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/call/groupcall/GroupCallGridAdapter$CallUserGridViewHolder;", "Lcom/contusfly/adapters/BaseViewHolder;", "binding", "Lcom/contusfly/databinding/CallGridUserItemBinding;", "(Lcom/contusfly/call/groupcall/GroupCallGridAdapter;Lcom/contusfly/databinding/CallGridUserItemBinding;)V", "getBinding", "()Lcom/contusfly/databinding/CallGridUserItemBinding;", "app_debug"})
    public final class CallUserGridViewHolder extends com.contusfly.adapters.BaseViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.contusfly.databinding.CallGridUserItemBinding binding = null;
        
        public CallUserGridViewHolder(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.CallGridUserItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.databinding.CallGridUserItemBinding getBinding() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/contusfly/call/groupcall/GroupCallGridAdapter$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "onPinnedGridView", "Lkotlin/Function1;", "", "getOnPinnedGridView", "()Lkotlin/jvm/functions/Function1;", "setOnPinnedGridView", "(Lkotlin/jvm/functions/Function1;)V", "onTapOnRecyclerView", "Lkotlin/Function0;", "getOnTapOnRecyclerView", "()Lkotlin/jvm/functions/Function0;", "setOnTapOnRecyclerView", "(Lkotlin/jvm/functions/Function0;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnPinnedGridView() {
            return null;
        }
        
        public final void setOnPinnedGridView(@org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnTapOnRecyclerView() {
            return null;
        }
        
        public final void setOnTapOnRecyclerView(@org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
        }
    }
}