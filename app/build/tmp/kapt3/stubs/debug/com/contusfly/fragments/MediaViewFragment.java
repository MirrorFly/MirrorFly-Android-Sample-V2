package com.contusfly.fragments;

import java.lang.System;

/**
 * Media fragment is used to show the selected images to share
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J&\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00104\u001a\u00020(2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\"\u00105\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010\rH\u0002J\b\u00107\u001a\u00020(H\u0002J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u0010\u0010&\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/contusfly/fragments/MediaViewFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "fileImage", "Landroidx/appcompat/widget/AppCompatImageView;", "fileLayout", "Landroid/widget/RelativeLayout;", "fileName", "Lcom/contusfly/views/CustomTextView;", "fileObject", "Lcom/contusfly/models/FileObject;", "filePath", "", "filesCount", "Landroidx/appcompat/widget/AppCompatTextView;", "image", "getImage", "()Landroidx/appcompat/widget/AppCompatImageView;", "setImage", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "isFromQuickShare", "", "isImageFile", "isVideoPathNullOrEmpty", "()Z", "messageData", "Lcom/mirrorflysdk/models/MultipleImages;", "playVideo", "position", "", "getPosition", "()I", "setPosition", "(I)V", "total", "getTotal", "setTotal", "videopath", "onClick", "", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setFileObject", "setMessageData", "isImage", "setViewsForFileTypeMedia", "setViewsForImageAndVideoTypeMedia", "isVideo", "Companion", "app_debug"})
public final class MediaViewFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    public androidx.appcompat.widget.AppCompatImageView image;
    private androidx.appcompat.widget.AppCompatImageView playVideo;
    private android.widget.RelativeLayout fileLayout;
    private com.contusfly.views.CustomTextView fileName;
    private androidx.appcompat.widget.AppCompatImageView fileImage;
    private androidx.appcompat.widget.AppCompatTextView filesCount;
    private int position = 0;
    private int total = 0;
    
    /**
     * Instance of the Message
     */
    private com.mirrorflysdk.models.MultipleImages messageData;
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
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.fragments.MediaViewFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public MediaViewFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.appcompat.widget.AppCompatImageView getImage() {
        return null;
    }
    
    public final void setImage(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatImageView p0) {
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
    
    private final void setFileObject(com.contusfly.models.FileObject fileObject) {
    }
    
    /**
     * Assign the message into the message data.
     *
     * @param messageData instance of the message.
     * @param isImage     true if the selected item is image.
     * @param videopath   the path of the media file.
     */
    private final void setMessageData(com.mirrorflysdk.models.MultipleImages messageData, boolean isImage, java.lang.String videopath) {
    }
    
    @org.jetbrains.annotations.Nullable
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/fragments/MediaViewFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/MediaViewFragment;", "fileObject", "Lcom/contusfly/models/FileObject;", "position", "", "total", "messageData", "Lcom/mirrorflysdk/models/MultipleImages;", "isImage", "", "filepath", "", "app_debug"})
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
        public final com.contusfly.fragments.MediaViewFragment newInstance(@org.jetbrains.annotations.NotNull
        com.mirrorflysdk.models.MultipleImages messageData, boolean isImage, @org.jetbrains.annotations.Nullable
        java.lang.String filepath) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.fragments.MediaViewFragment newInstance(@org.jetbrains.annotations.NotNull
        com.contusfly.models.FileObject fileObject, int position, int total) {
            return null;
        }
    }
}