package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J*\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J(\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/contusfly/utils/PinTextWatcher;", "Landroid/text/TextWatcher;", "currentIndex", "", "editTexts", "", "Landroidx/appcompat/widget/AppCompatEditText;", "activity", "Landroid/app/Activity;", "(I[Landroidx/appcompat/widget/AppCompatEditText;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "[Landroidx/appcompat/widget/AppCompatEditText;", "isAllEditTextsFilled", "", "()Z", "isFirst", "isLast", "newTypedString", "", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "p2", "p3", "changePreviousViewBackGround", "hideKeyboard", "moveToNext", "moveToPrevious", "onTextChanged", "start", "before", "count", "app_debug"})
public final class PinTextWatcher implements android.text.TextWatcher {
    private final int currentIndex = 0;
    private final androidx.appcompat.widget.AppCompatEditText[] editTexts = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity activity = null;
    private boolean isFirst = false;
    private boolean isLast = false;
    private java.lang.String newTypedString = "";
    
    public PinTextWatcher(int currentIndex, @org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatEditText[] editTexts, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getActivity() {
        return null;
    }
    
    @java.lang.Override()
    public void beforeTextChanged(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence p0, int p1, int p2, int p3) {
    }
    
    @java.lang.Override()
    public void onTextChanged(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence s, int start, int before, int count) {
    }
    
    @java.lang.Override()
    public void afterTextChanged(@org.jetbrains.annotations.NotNull()
    android.text.Editable s) {
    }
    
    private final void moveToNext() {
    }
    
    private final void moveToPrevious() {
    }
    
    private final boolean isAllEditTextsFilled() {
        return false;
    }
    
    private final void hideKeyboard() {
    }
    
    private final void changePreviousViewBackGround() {
    }
}