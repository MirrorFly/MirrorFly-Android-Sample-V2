package com.contusfly.adapters;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u00042\u00020\u0005B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0017H$\u00a2\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010H$\u00a2\u0006\u0002\u0010\u001bJ3\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH$\u00a2\u0006\u0002\u0010\u001fJ\u001d\u0010 \u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010!J+\u0010 \u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016\u00a2\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00028\u00012\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010\'J\u0014\u0010(\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007J\u0015\u0010)\u001a\u00028\u00012\u0006\u0010$\u001a\u00020%H$\u00a2\u0006\u0002\u0010*R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/contusfly/adapters/GenericSearchAdapter;", "T", "ViewBindingVH", "Lcom/contusfly/adapters/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroid/widget/Filterable;", "itemList", "", "(Ljava/util/List;)V", "origList", "clearData", "", "getFilter", "Landroid/widget/Filter;", "getItem", "position", "", "(I)Ljava/lang/Object;", "getItemCount", "hasSearchKey", "", "item", "filterKey", "", "(Ljava/lang/Object;Ljava/lang/String;)Z", "onBindData", "holder", "(Lcom/contusfly/adapters/BaseViewHolder;Ljava/lang/Object;I)V", "payloads", "", "", "(Lcom/contusfly/adapters/BaseViewHolder;Ljava/lang/Object;ILjava/util/List;)V", "onBindViewHolder", "(Lcom/contusfly/adapters/BaseViewHolder;I)V", "(Lcom/contusfly/adapters/BaseViewHolder;ILjava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "(Landroid/view/ViewGroup;I)Lcom/contusfly/adapters/BaseViewHolder;", "setItems", "setViewHolder", "(Landroid/view/ViewGroup;)Lcom/contusfly/adapters/BaseViewHolder;", "app_debug"})
public abstract class GenericSearchAdapter<T extends java.lang.Object, ViewBindingVH extends com.contusfly.adapters.BaseViewHolder> extends androidx.recyclerview.widget.RecyclerView.Adapter<ViewBindingVH> implements android.widget.Filterable {
    private java.util.List<? extends T> itemList;
    private java.util.List<? extends T> origList;
    
    public GenericSearchAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> itemList) {
        super();
    }
    
    protected abstract void onBindData(@org.jetbrains.annotations.NotNull()
    ViewBindingVH holder, T item, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads);
    
    protected abstract void onBindData(@org.jetbrains.annotations.NotNull()
    ViewBindingVH holder, T item, int position);
    
    protected abstract boolean hasSearchKey(T item, @org.jetbrains.annotations.NotNull()
    java.lang.String filterKey);
    
    @org.jetbrains.annotations.NotNull()
    protected abstract ViewBindingVH setViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent);
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ViewBindingVH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    ViewBindingVH holder, int position) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    ViewBindingVH holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final T getItem(int position) {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> itemList) {
    }
    
    public final void clearData() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.widget.Filter getFilter() {
        return null;
    }
}