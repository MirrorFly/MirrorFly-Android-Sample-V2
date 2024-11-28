package com.contusfly.utils;

import java.lang.System;

/**
 * Replace edge effect by a bounce
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/utils/BounceEdgeEffectFactory;", "Landroidx/recyclerview/widget/RecyclerView$EdgeEffectFactory;", "()V", "privateChatListener", "Lcom/contusfly/interfaces/PrivateChatReleaseListener;", "createEdgeEffect", "Landroid/widget/EdgeEffect;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "direction", "", "setListener", "", "listener", "setTranslationValue", "overscrollmagnitude", "", "flingmagnitude", "app_debug"})
public final class BounceEdgeEffectFactory extends androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory {
    private com.contusfly.interfaces.PrivateChatReleaseListener privateChatListener;
    
    public BounceEdgeEffectFactory() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    protected android.widget.EdgeEffect createEdgeEffect(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView recyclerView, int direction) {
        return null;
    }
    
    public final void setTranslationValue(float overscrollmagnitude, float flingmagnitude) {
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull
    com.contusfly.interfaces.PrivateChatReleaseListener listener) {
    }
}