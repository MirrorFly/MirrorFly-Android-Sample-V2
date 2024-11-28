package com.contusfly.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/contusfly/utils/DebounceOnClickListener;", "Landroid/view/View$OnClickListener;", "interval", "", "listenerBlock", "Lkotlin/Function1;", "Landroid/view/View;", "", "(JLkotlin/jvm/functions/Function1;)V", "lastClickTime", "onClick", "v", "app_debug"})
public final class DebounceOnClickListener implements android.view.View.OnClickListener {
    private final long interval = 0L;
    private final kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> listenerBlock = null;
    private long lastClickTime = 0L;
    
    public DebounceOnClickListener(long interval, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> listenerBlock) {
        super();
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
}