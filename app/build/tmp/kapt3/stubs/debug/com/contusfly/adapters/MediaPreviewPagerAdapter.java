package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0015J\u0016\u0010\u001b\u001a\u00020\u001a2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012J\u0016\u0010\u001c\u001a\u00020\u001a2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/contusfly/adapters/MediaPreviewPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "supportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "doNotifyDataSetChangedOnce", "", "fileObjectList", "", "Lcom/contusfly/models/FileObject;", "filepath", "", "isFromQuickShare", "()Z", "setFromQuickShare", "(Z)V", "isImage", "messageList", "", "Lcom/contusfly/models/MediaPreviewModel;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "removeFileObject", "", "setFileObjectList", "setImageList", "app_debug"})
public final class MediaPreviewPagerAdapter extends androidx.fragment.app.FragmentStatePagerAdapter {
    private java.lang.String filepath;
    
    /**
     * List of messages for the user
     */
    private java.util.List<com.contusfly.models.MediaPreviewModel> messageList;
    
    /**
     * List of messages for the user
     */
    private java.util.List<com.contusfly.models.FileObject> fileObjectList;
    
    /**
     * Check whether the adapter is initialized from Quick Share
     */
    private boolean isFromQuickShare = false;
    private boolean doNotifyDataSetChangedOnce = false;
    
    /**
     * Validate if it is image or video to preview
     */
    private boolean isImage = false;
    
    public MediaPreviewPagerAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager supportFragmentManager) {
        super(null);
    }
    
    public final boolean isFromQuickShare() {
        return false;
    }
    
    public final void setFromQuickShare(boolean p0) {
    }
    
    public final void setImageList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.contusfly.models.MediaPreviewModel> messageList) {
    }
    
    public final void setFileObjectList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.contusfly.models.FileObject> fileObjectList) {
    }
    
    public final void removeFileObject(int position) {
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.fragment.app.Fragment getItem(int position) {
        return null;
    }
}