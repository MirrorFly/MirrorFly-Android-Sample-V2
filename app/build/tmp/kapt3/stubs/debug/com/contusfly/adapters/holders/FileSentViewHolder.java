package com.contusfly.adapters.holders;

import java.lang.System;

/**
 * This class is used to provide data and views in a [RecyclerView]
 * for the file-type messages posted in the chat conversation window.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u0004R\u001a\u0010!\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001a\u0010$\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u001a\u0010\'\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\nR\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u00100\u001a\u00020+\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u001a\u00102\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR\u0013\u00105\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001fR\u001a\u00108\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001f\"\u0004\b:\u0010\u0004R\u0013\u0010;\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001f\u00a8\u0006="}, d2 = {"Lcom/contusfly/adapters/holders/FileSentViewHolder;", "Lcom/contusfly/adapters/holders/SenderNameHolder;", "mainView", "Landroid/view/View;", "(Landroid/view/View;)V", "fileCarbonDownloadView", "Landroid/widget/RelativeLayout;", "getFileCarbonDownloadView", "()Landroid/widget/RelativeLayout;", "setFileCarbonDownloadView", "(Landroid/widget/RelativeLayout;)V", "fileFavoriteImage", "Landroid/widget/ImageView;", "getFileFavoriteImage", "()Landroid/widget/ImageView;", "setFileFavoriteImage", "(Landroid/widget/ImageView;)V", "fileNameText", "Landroidx/appcompat/widget/AppCompatTextView;", "getFileNameText", "()Landroidx/appcompat/widget/AppCompatTextView;", "setFileNameText", "(Landroidx/appcompat/widget/AppCompatTextView;)V", "filePictureImage", "getFilePictureImage", "setFilePictureImage", "fileSentTimeText", "getFileSentTimeText", "setFileSentTimeText", "fileSentViewLayout", "getFileSentViewLayout", "()Landroid/view/View;", "setFileSentViewLayout", "fileSizeText", "getFileSizeText", "setFileSizeText", "fileStatusImage", "getFileStatusImage", "setFileStatusImage", "fileUploadCancelLayout", "getFileUploadCancelLayout", "setFileUploadCancelLayout", "fileUploadProgress", "Landroid/widget/ProgressBar;", "getFileUploadProgress", "()Landroid/widget/ProgressBar;", "setFileUploadProgress", "(Landroid/widget/ProgressBar;)V", "fileUploadProgressBuffer", "getFileUploadProgressBuffer", "fileUploadViewLayout", "getFileUploadViewLayout", "setFileUploadViewLayout", "imgFileForward", "getImgFileForward", "getMainView", "spaceView", "getSpaceView", "setSpaceView", "viewDiver", "getViewDiver", "app_debug"})
public final class FileSentViewHolder extends com.contusfly.adapters.holders.SenderNameHolder {
    @org.jetbrains.annotations.NotNull()
    private final android.view.View mainView = null;
    
    /**
     * File Name space view
     */
    @org.jetbrains.annotations.NotNull()
    private android.view.View spaceView;
    
    /**
     * view to display the file sent layout
     */
    @org.jetbrains.annotations.NotNull()
    private android.view.View fileSentViewLayout;
    
    /**
     * view to display the upload layout
     */
    @org.jetbrains.annotations.NotNull()
    private android.widget.RelativeLayout fileUploadViewLayout;
    
    /**
     * view to display the carbon download layout
     */
    @org.jetbrains.annotations.Nullable()
    private android.widget.RelativeLayout fileCarbonDownloadView;
    
    /**
     * view to display the progress layout
     */
    @org.jetbrains.annotations.NotNull()
    private android.widget.RelativeLayout fileUploadCancelLayout;
    
    /**
     * ImageView display the file picture
     */
    @org.jetbrains.annotations.NotNull()
    private android.widget.ImageView filePictureImage;
    
    /**
     * CustomTextView display file Name text
     */
    @org.jetbrains.annotations.NotNull()
    private androidx.appcompat.widget.AppCompatTextView fileNameText;
    
    /**
     * Progress dialog
     */
    @org.jetbrains.annotations.NotNull()
    private android.widget.ProgressBar fileUploadProgress;
    
    /**
     * Progress buffer dialog
     */
    @org.jetbrains.annotations.NotNull()
    private final android.widget.ProgressBar fileUploadProgressBuffer = null;
    
    /**
     * CustomTextView display the file size text
     */
    @org.jetbrains.annotations.NotNull()
    private androidx.appcompat.widget.AppCompatTextView fileSizeText;
    
    /**
     * ImageView display the file favourite Image
     */
    @org.jetbrains.annotations.NotNull()
    private android.widget.ImageView fileFavoriteImage;
    
    /**
     * ImageView display the file status Image
     */
    @org.jetbrains.annotations.NotNull()
    private android.widget.ImageView fileStatusImage;
    
    /**
     * CustomTextView display the file sent time text
     */
    @org.jetbrains.annotations.NotNull()
    private androidx.appcompat.widget.AppCompatTextView fileSentTimeText;
    
    /**
     * ImageView display the file status Image
     */
    @org.jetbrains.annotations.Nullable()
    private final android.widget.ImageView imgFileForward = null;
    @org.jetbrains.annotations.Nullable()
    private final android.view.View viewDiver = null;
    
    public FileSentViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.View mainView) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getMainView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getSpaceView() {
        return null;
    }
    
    public final void setSpaceView(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getFileSentViewLayout() {
        return null;
    }
    
    public final void setFileSentViewLayout(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RelativeLayout getFileUploadViewLayout() {
        return null;
    }
    
    public final void setFileUploadViewLayout(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.RelativeLayout getFileCarbonDownloadView() {
        return null;
    }
    
    public final void setFileCarbonDownloadView(@org.jetbrains.annotations.Nullable()
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RelativeLayout getFileUploadCancelLayout() {
        return null;
    }
    
    public final void setFileUploadCancelLayout(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getFilePictureImage() {
        return null;
    }
    
    public final void setFilePictureImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.AppCompatTextView getFileNameText() {
        return null;
    }
    
    public final void setFileNameText(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatTextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ProgressBar getFileUploadProgress() {
        return null;
    }
    
    public final void setFileUploadProgress(@org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ProgressBar getFileUploadProgressBuffer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.AppCompatTextView getFileSizeText() {
        return null;
    }
    
    public final void setFileSizeText(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatTextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getFileFavoriteImage() {
        return null;
    }
    
    public final void setFileFavoriteImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getFileStatusImage() {
        return null;
    }
    
    public final void setFileStatusImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.AppCompatTextView getFileSentTimeText() {
        return null;
    }
    
    public final void setFileSentTimeText(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatTextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ImageView getImgFileForward() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getViewDiver() {
        return null;
    }
}