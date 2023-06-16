package com.contusfly.quickShare;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/contusfly/quickShare/FilesDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "fileListAdapter", "Lcom/contusfly/quickShare/FileListAdapter;", "filesDialogBinding", "Lcom/contusfly/databinding/FragmentFilesDialogBinding;", "filesList", "Lcom/contusfly/views/CustomRecyclerView;", "mCallback", "Lcom/contusfly/quickShare/FilesDialogFragment$DialogFragmentInterface;", "mainList", "Ljava/util/ArrayList;", "Lcom/contusfly/models/FileObject;", "enableSwipeToDelete", "", "initView", "filesBinding", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "DialogFragmentInterface", "app_debug"})
public final class FilesDialogFragment extends androidx.fragment.app.DialogFragment {
    private com.contusfly.databinding.FragmentFilesDialogBinding filesDialogBinding;
    private com.contusfly.views.CustomRecyclerView filesList;
    private com.contusfly.quickShare.FileListAdapter fileListAdapter;
    private java.util.ArrayList<com.contusfly.models.FileObject> mainList;
    private com.contusfly.quickShare.FilesDialogFragment.DialogFragmentInterface mCallback;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.quickShare.FilesDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public FilesDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initView(com.contusfly.databinding.FragmentFilesDialogBinding filesBinding) {
    }
    
    private final void enableSwipeToDelete() {
    }
    
    /**
     * The constructor used to create and initialize a new instance of this class object, with the
     * specified initialization parameters.
     *
     * @return a new object created by calling the constructor of this object representation.
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.contusfly.quickShare.FilesDialogFragment newInstance(@org.jetbrains.annotations.Nullable()
    java.util.List<com.contusfly.models.FileObject> mainList) {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/quickShare/FilesDialogFragment$DialogFragmentInterface;", "", "exitShare", "", "removeFile", "fileObject", "Lcom/contusfly/models/FileObject;", "app_debug"})
    public static abstract interface DialogFragmentInterface {
        
        public abstract void removeFile(@org.jetbrains.annotations.Nullable()
        com.contusfly.models.FileObject fileObject);
        
        public abstract void exitShare();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/quickShare/FilesDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/quickShare/FilesDialogFragment;", "mainList", "", "Lcom/contusfly/models/FileObject;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * The constructor used to create and initialize a new instance of this class object, with the
         * specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.contusfly.quickShare.FilesDialogFragment newInstance(@org.jetbrains.annotations.Nullable()
        java.util.List<com.contusfly.models.FileObject> mainList) {
            return null;
        }
    }
}