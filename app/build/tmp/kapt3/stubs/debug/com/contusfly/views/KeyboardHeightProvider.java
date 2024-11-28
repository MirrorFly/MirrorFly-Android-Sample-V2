package com.contusfly.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0011J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/contusfly/views/KeyboardHeightProvider;", "Landroid/widget/PopupWindow;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "keyboardListeners", "Ljava/util/ArrayList;", "Lcom/contusfly/views/KeyboardHeightProvider$KeyboardListener;", "lastKeyboardHeight", "", "parentView", "Landroid/view/View;", "resizableView", "topCutoutHeight", "getTopCutoutHeight", "()I", "addKeyboardListener", "", "listener", "computeKeyboardState", "getGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "hideKeyboard", "notifyKeyboardHeightChanged", "height", "onPause", "onResume", "removeKeyboardListener", "KeyboardListener", "app_debug"})
public final class KeyboardHeightProvider extends android.widget.PopupWindow {
    private final android.app.Activity activity = null;
    private android.view.View resizableView;
    private android.view.View parentView;
    private int lastKeyboardHeight = -1;
    private java.util.ArrayList<com.contusfly.views.KeyboardHeightProvider.KeyboardListener> keyboardListeners;
    
    public KeyboardHeightProvider(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
        super(null);
    }
    
    public final void onResume() {
    }
    
    public final void onPause() {
    }
    
    private final android.view.ViewTreeObserver.OnGlobalLayoutListener getGlobalLayoutListener() {
        return null;
    }
    
    private final void computeKeyboardState() {
    }
    
    private final int getTopCutoutHeight() {
        return 0;
    }
    
    public final void addKeyboardListener(@org.jetbrains.annotations.NotNull
    com.contusfly.views.KeyboardHeightProvider.KeyboardListener listener) {
    }
    
    public final void removeKeyboardListener(@org.jetbrains.annotations.NotNull
    com.contusfly.views.KeyboardHeightProvider.KeyboardListener listener) {
    }
    
    private final void notifyKeyboardHeightChanged(int height) {
    }
    
    public final void hideKeyboard() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/views/KeyboardHeightProvider$KeyboardListener;", "", "onHeightChanged", "", "height", "", "app_debug"})
    public static abstract interface KeyboardListener {
        
        public abstract void onHeightChanged(int height);
    }
}