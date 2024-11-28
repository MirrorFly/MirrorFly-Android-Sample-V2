package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/utils/PinOnKeyListener;", "Landroid/view/View$OnKeyListener;", "currentIndex", "", "editTexts", "", "Landroidx/appcompat/widget/AppCompatEditText;", "(I[Landroidx/appcompat/widget/AppCompatEditText;)V", "[Landroidx/appcompat/widget/AppCompatEditText;", "onKey", "", "v", "Landroid/view/View;", "keyCode", "event", "Landroid/view/KeyEvent;", "app_debug"})
public final class PinOnKeyListener implements android.view.View.OnKeyListener {
    private final int currentIndex = 0;
    private final androidx.appcompat.widget.AppCompatEditText[] editTexts = null;
    
    public PinOnKeyListener(int currentIndex, @org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatEditText[] editTexts) {
        super();
    }
    
    @java.lang.Override
    public boolean onKey(@org.jetbrains.annotations.NotNull
    android.view.View v, int keyCode, @org.jetbrains.annotations.NotNull
    android.view.KeyEvent event) {
        return false;
    }
}