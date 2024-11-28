package com.contusfly.fragments;

import java.lang.System;

/**
 * Media fragment is used to show the selected images to share
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0016J$\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010-\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\"\u0010.\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\t2\b\u00100\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u00101\u001a\u00020 H\u0002J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/contusfly/fragments/MediaPreviewFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "fileObject", "Lcom/contusfly/models/FileObject;", "filePath", "", "isFromQuickShare", "", "isImageFile", "isVideoPathNullOrEmpty", "()Z", "mediaPreviewFragment", "Lcom/contusfly/databinding/FragmentMediaPreviewBinding;", "getMediaPreviewFragment", "()Lcom/contusfly/databinding/FragmentMediaPreviewBinding;", "setMediaPreviewFragment", "(Lcom/contusfly/databinding/FragmentMediaPreviewBinding;)V", "messageData", "Lcom/contusfly/models/MediaPreviewModel;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "total", "getTotal", "setTotal", "videopath", "initViews", "", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setFileObject", "setMessageData", "isImage", "videoPath", "setViewsForFileTypeMedia", "setViewsForImageAndVideoTypeMedia", "isVideo", "Companion", "app_debug"})
public final class MediaPreviewFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private int position = 0;
    private int total = 0;
    
    /**
     * Instance of the Message
     */
    private com.contusfly.models.MediaPreviewModel messageData;
    private boolean isFromQuickShare = false;
    
    /**
     * Instance of the Message
     */
    private com.contusfly.models.FileObject fileObject;
    
    /**
     * Path of an file
     */
    private java.lang.String filePath;
    
    /**
     * Filepath for the video.
     */
    private java.lang.String videopath;
    
    /**
     * Image selection validation
     */
    private boolean isImageFile = false;
    public com.contusfly.databinding.FragmentMediaPreviewBinding mediaPreviewFragment;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.fragments.MediaPreviewFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public MediaPreviewFragment() {
        super();
    }
    
    public final int getPosition() {
        return 0;
    }
    
    public final void setPosition(int p0) {
    }
    
    public final int getTotal() {
        return 0;
    }
    
    public final void setTotal(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.databinding.FragmentMediaPreviewBinding getMediaPreviewFragment() {
        return null;
    }
    
    public final void setMediaPreviewFragment(@org.jetbrains.annotations.NotNull
    com.contusfly.databinding.FragmentMediaPreviewBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final boolean isVideoPathNullOrEmpty() {
        return false;
    }
    
    /**
     * Set Views for media of File Type
     */
    private final void setViewsForFileTypeMedia() {
    }
    
    /**
     * Set Views for image and video file type
     *
     * @param isVideo holds the value if its a video or image
     */
    private final void setViewsForImageAndVideoTypeMedia(boolean isVideo) {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    private final void setFileObject(com.contusfly.models.FileObject fileObject) {
    }
    
    /**
     * Assign the message into the message data.
     *
     * @param messageData instance of the message.
     * @param isImage     true if the selected item is image.
     * @param videoPath   the path of the media file.
     */
    private final void setMessageData(com.contusfly.models.MediaPreviewModel messageData, boolean isImage, java.lang.String videoPath) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/fragments/MediaPreviewFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/MediaPreviewFragment;", "fileObject", "Lcom/contusfly/models/FileObject;", "position", "", "total", "messageData", "Lcom/contusfly/models/MediaPreviewModel;", "isImage", "", "filepath", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Use this factory method to create a new instance of this fragment using the provided
         * parameters.
         *
         * @param messageData instance of the message.
         * @param isImage     true if the selected item is image.
         * @param filepath    the path of the media file.
         * @return mediaFragment instance of fragment MediaFragment.
         */
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.fragments.MediaPreviewFragment newInstance(@org.jetbrains.annotations.NotNull
        com.contusfly.models.MediaPreviewModel messageData, boolean isImage, @org.jetbrains.annotations.Nullable
        java.lang.String filepath) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.fragments.MediaPreviewFragment newInstance(@org.jetbrains.annotations.NotNull
        com.contusfly.models.FileObject fileObject, int position, int total) {
            return null;
        }
    }
}