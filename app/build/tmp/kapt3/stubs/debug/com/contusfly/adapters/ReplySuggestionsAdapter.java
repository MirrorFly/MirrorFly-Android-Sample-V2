package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0018\u0019B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0016\u0010\u0015\u001a\u00020\u000e2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/contusfly/adapters/ReplySuggestionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/ReplySuggestionsAdapter$ReplySuggestionViewHolder;", "context", "Landroid/content/Context;", "suggestionClickListener", "Lcom/contusfly/adapters/ReplySuggestionsAdapter$SuggestionClickListener;", "(Landroid/content/Context;Lcom/contusfly/adapters/ReplySuggestionsAdapter$SuggestionClickListener;)V", "smartReplySuggestions", "", "Lcom/google/firebase/ml/naturallanguage/smartreply/SmartReplySuggestion;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSmartReplySuggestions", "smartReplySuggestion", "", "ReplySuggestionViewHolder", "SuggestionClickListener", "app_debug"})
public final class ReplySuggestionsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.ReplySuggestionsAdapter.ReplySuggestionViewHolder> {
    private final android.content.Context context = null;
    private final com.contusfly.adapters.ReplySuggestionsAdapter.SuggestionClickListener suggestionClickListener = null;
    private final java.util.List<com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion> smartReplySuggestions = null;
    
    public ReplySuggestionsAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ReplySuggestionsAdapter.SuggestionClickListener suggestionClickListener) {
        super();
    }
    
    public final void setSmartReplySuggestions(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion> smartReplySuggestion) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.adapters.ReplySuggestionsAdapter.ReplySuggestionViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ReplySuggestionsAdapter.ReplySuggestionViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/adapters/ReplySuggestionsAdapter$ReplySuggestionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/contusfly/adapters/ReplySuggestionsAdapter;Landroid/view/View;)V", "suggestionText", "Landroidx/emoji/widget/EmojiAppCompatTextView;", "bind", "", "suggestion", "Lcom/google/firebase/ml/naturallanguage/smartreply/SmartReplySuggestion;", "app_debug"})
    public final class ReplySuggestionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private androidx.emoji.widget.EmojiAppCompatTextView suggestionText;
        
        public ReplySuggestionViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion suggestion) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/adapters/ReplySuggestionsAdapter$SuggestionClickListener;", "", "onSuggestionClick", "", "text", "", "app_debug"})
    public static abstract interface SuggestionClickListener {
        
        public abstract void onSuggestionClick(@org.jetbrains.annotations.NotNull
        java.lang.String text);
    }
}