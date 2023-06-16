package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/contusfly/adapters/PreviewPhoneNumberAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/PreviewPhoneNumberAdapter$PreviewPhoneNumberViewHolder;", "mobileNumbers", "", "Lcom/contusfly/models/PhoneNumber;", "(Ljava/util/List;)V", "getItemCount", "", "handleNumberSelection", "", "number", "holder", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PreviewPhoneNumberViewHolder", "app_debug"})
public final class PreviewPhoneNumberAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.PreviewPhoneNumberAdapter.PreviewPhoneNumberViewHolder> {
    private final java.util.List<com.contusfly.models.PhoneNumber> mobileNumbers = null;
    
    public PreviewPhoneNumberAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.contusfly.models.PhoneNumber> mobileNumbers) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.contusfly.adapters.PreviewPhoneNumberAdapter.PreviewPhoneNumberViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.PreviewPhoneNumberAdapter.PreviewPhoneNumberViewHolder holder, int position) {
    }
    
    private final void handleNumberSelection(com.contusfly.models.PhoneNumber number, com.contusfly.adapters.PreviewPhoneNumberAdapter.PreviewPhoneNumberViewHolder holder) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/PreviewPhoneNumberAdapter$PreviewPhoneNumberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rowPreviewMobileNumberBinding", "Lcom/contusfly/databinding/RowPreviewMobileNumberBinding;", "(Lcom/contusfly/databinding/RowPreviewMobileNumberBinding;)V", "getRowPreviewMobileNumberBinding", "()Lcom/contusfly/databinding/RowPreviewMobileNumberBinding;", "setRowPreviewMobileNumberBinding", "app_debug"})
    public static final class PreviewPhoneNumberViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private com.contusfly.databinding.RowPreviewMobileNumberBinding rowPreviewMobileNumberBinding;
        
        public PreviewPhoneNumberViewHolder(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowPreviewMobileNumberBinding rowPreviewMobileNumberBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.databinding.RowPreviewMobileNumberBinding getRowPreviewMobileNumberBinding() {
            return null;
        }
        
        public final void setRowPreviewMobileNumberBinding(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowPreviewMobileNumberBinding p0) {
        }
    }
}