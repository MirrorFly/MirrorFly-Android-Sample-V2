package com.contusfly.quickShare;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fJ\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0016\u0010\u0019\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001bJ\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/contusfly/quickShare/FileListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/quickShare/FileListAdapter$FileShareViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mainList", "", "Lcom/contusfly/models/FileObject;", "getFileMimeTypeMessage", "", "getItemCount", "", "handleMimeType", "", "fileObject", "holder", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "setColorAndMessageForUnsupportedInfo", "setDataList", "fileObjects", "Ljava/util/ArrayList;", "validateType", "FileShareViewHolder", "app_debug"})
public final class FileListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.quickShare.FileListAdapter.FileShareViewHolder> {
    
    /**
     * List of countries for the list view
     */
    private java.util.List<com.contusfly.models.FileObject> mainList;
    private android.content.Context context;
    
    public FileListAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void setDataList(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.contusfly.models.FileObject> fileObjects) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.quickShare.FileListAdapter.FileShareViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.quickShare.FileListAdapter.FileShareViewHolder holder, int position) {
    }
    
    private final void validateType(com.contusfly.models.FileObject fileObject, com.contusfly.quickShare.FileListAdapter.FileShareViewHolder holder) {
    }
    
    private final void setColorAndMessageForUnsupportedInfo(com.contusfly.quickShare.FileListAdapter.FileShareViewHolder holder, com.contusfly.models.FileObject fileObject) {
    }
    
    private final java.lang.String getFileMimeTypeMessage() {
        return null;
    }
    
    private final void handleMimeType(com.contusfly.models.FileObject fileObject, com.contusfly.quickShare.FileListAdapter.FileShareViewHolder holder) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void removeItem(int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/quickShare/FileListAdapter$FileShareViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/contusfly/databinding/RowFilesItemBinding;", "(Lcom/contusfly/databinding/RowFilesItemBinding;)V", "getViewBinding", "()Lcom/contusfly/databinding/RowFilesItemBinding;", "setViewBinding", "app_debug"})
    public static final class FileShareViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.contusfly.databinding.RowFilesItemBinding viewBinding;
        
        public FileShareViewHolder(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowFilesItemBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.databinding.RowFilesItemBinding getViewBinding() {
            return null;
        }
        
        public final void setViewBinding(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowFilesItemBinding p0) {
        }
    }
}