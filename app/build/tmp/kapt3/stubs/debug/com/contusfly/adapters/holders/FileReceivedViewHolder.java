package com.contusfly.adapters.holders;

import java.lang.System;

/**
 * This class is used to provide data and views in a [RecyclerView] for the file-type messages
 * received in the chat conversation window.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010%\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b\'\u0010!R\u001a\u0010(\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\u0004R\u001a\u0010,\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\u001c\u0010/\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010*R\u001a\u00103\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010*\"\u0004\b5\u0010\u0004R\u001a\u00106\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010*\"\u0004\b8\u0010\u0004R\u0013\u00109\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010*\u00a8\u0006;"}, d2 = {"Lcom/contusfly/adapters/holders/FileReceivedViewHolder;", "Lcom/contusfly/adapters/holders/SenderNameHolder;", "mainView", "Landroid/view/View;", "(Landroid/view/View;)V", "fileCancelLayout", "Landroid/widget/RelativeLayout;", "getFileCancelLayout", "()Landroid/widget/RelativeLayout;", "setFileCancelLayout", "(Landroid/widget/RelativeLayout;)V", "fileDownloadLayout", "getFileDownloadLayout", "setFileDownloadLayout", "fileDownloadProgress", "Landroid/widget/ProgressBar;", "getFileDownloadProgress", "()Landroid/widget/ProgressBar;", "setFileDownloadProgress", "(Landroid/widget/ProgressBar;)V", "fileDownloadProgressBuffer", "getFileDownloadProgressBuffer", "fileFavoriteImage", "Landroid/widget/ImageView;", "getFileFavoriteImage", "()Landroid/widget/ImageView;", "setFileFavoriteImage", "(Landroid/widget/ImageView;)V", "fileNameText", "Landroidx/appcompat/widget/AppCompatTextView;", "getFileNameText", "()Landroidx/appcompat/widget/AppCompatTextView;", "setFileNameText", "(Landroidx/appcompat/widget/AppCompatTextView;)V", "filePictureImage", "getFilePictureImage", "setFilePictureImage", "fileReceivedTimeText", "getFileReceivedTimeText", "setFileReceivedTimeText", "fileReceivedViewLayout", "getFileReceivedViewLayout", "()Landroid/view/View;", "setFileReceivedViewLayout", "fileSizeText", "getFileSizeText", "setFileSizeText", "imgFileForward", "getImgFileForward", "setImgFileForward", "getMainView", "openFileReceivedViewLayout", "getOpenFileReceivedViewLayout", "setOpenFileReceivedViewLayout", "spaceView", "getSpaceView", "setSpaceView", "viewDiver", "getViewDiver", "app_debug"})
public final class FileReceivedViewHolder extends com.contusfly.adapters.holders.SenderNameHolder {
    @org.jetbrains.annotations.NotNull
    private final android.view.View mainView = null;
    @org.jetbrains.annotations.NotNull
    private android.view.View spaceView;
    @org.jetbrains.annotations.NotNull
    private android.view.View fileReceivedViewLayout;
    @org.jetbrains.annotations.NotNull
    private android.view.View openFileReceivedViewLayout;
    @org.jetbrains.annotations.NotNull
    private android.widget.RelativeLayout fileDownloadLayout;
    @org.jetbrains.annotations.NotNull
    private android.widget.RelativeLayout fileCancelLayout;
    @org.jetbrains.annotations.NotNull
    private android.widget.ImageView filePictureImage;
    @org.jetbrains.annotations.NotNull
    private androidx.appcompat.widget.AppCompatTextView fileNameText;
    @org.jetbrains.annotations.NotNull
    private android.widget.ProgressBar fileDownloadProgress;
    @org.jetbrains.annotations.NotNull
    private final android.widget.ProgressBar fileDownloadProgressBuffer = null;
    @org.jetbrains.annotations.NotNull
    private androidx.appcompat.widget.AppCompatTextView fileSizeText;
    @org.jetbrains.annotations.NotNull
    private android.widget.ImageView fileFavoriteImage;
    @org.jetbrains.annotations.NotNull
    private androidx.appcompat.widget.AppCompatTextView fileReceivedTimeText;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView imgFileForward;
    @org.jetbrains.annotations.Nullable
    private final android.view.View viewDiver = null;
    
    public FileReceivedViewHolder(@org.jetbrains.annotations.NotNull
    android.view.View mainView) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.view.View getMainView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.view.View getSpaceView() {
        return null;
    }
    
    public final void setSpaceView(@org.jetbrains.annotations.NotNull
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.view.View getFileReceivedViewLayout() {
        return null;
    }
    
    public final void setFileReceivedViewLayout(@org.jetbrains.annotations.NotNull
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.view.View getOpenFileReceivedViewLayout() {
        return null;
    }
    
    public final void setOpenFileReceivedViewLayout(@org.jetbrains.annotations.NotNull
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.RelativeLayout getFileDownloadLayout() {
        return null;
    }
    
    public final void setFileDownloadLayout(@org.jetbrains.annotations.NotNull
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.RelativeLayout getFileCancelLayout() {
        return null;
    }
    
    public final void setFileCancelLayout(@org.jetbrains.annotations.NotNull
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.ImageView getFilePictureImage() {
        return null;
    }
    
    public final void setFilePictureImage(@org.jetbrains.annotations.NotNull
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.appcompat.widget.AppCompatTextView getFileNameText() {
        return null;
    }
    
    public final void setFileNameText(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatTextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.ProgressBar getFileDownloadProgress() {
        return null;
    }
    
    public final void setFileDownloadProgress(@org.jetbrains.annotations.NotNull
    android.widget.ProgressBar p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.ProgressBar getFileDownloadProgressBuffer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.appcompat.widget.AppCompatTextView getFileSizeText() {
        return null;
    }
    
    public final void setFileSizeText(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatTextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.ImageView getFileFavoriteImage() {
        return null;
    }
    
    public final void setFileFavoriteImage(@org.jetbrains.annotations.NotNull
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.appcompat.widget.AppCompatTextView getFileReceivedTimeText() {
        return null;
    }
    
    public final void setFileReceivedTimeText(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatTextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getImgFileForward() {
        return null;
    }
    
    public final void setImgFileForward(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.view.View getViewDiver() {
        return null;
    }
}