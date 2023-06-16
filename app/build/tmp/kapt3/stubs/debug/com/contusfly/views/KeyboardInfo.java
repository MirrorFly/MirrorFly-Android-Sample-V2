package com.contusfly.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/views/KeyboardInfo;", "", "()V", "HEIGHT_NOT_COMPUTED", "", "STATE_CLOSED", "STATE_OPENED", "STATE_UNKNOWN", "keyboardHeight", "getKeyboardHeight", "()I", "setKeyboardHeight", "(I)V", "keyboardState", "getKeyboardState", "setKeyboardState", "app_debug"})
public final class KeyboardInfo {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.views.KeyboardInfo INSTANCE = null;
    public static final int HEIGHT_NOT_COMPUTED = -1;
    public static final int STATE_UNKNOWN = -1;
    public static final int STATE_CLOSED = 0;
    public static final int STATE_OPENED = 1;
    
    /**
     * Cached keyboard height. This will keep the last keyboard height value and not
     * it's current height
     */
    private static int keyboardHeight = -1;
    
    /**
     * Real time keyboard state
     */
    private static int keyboardState = -1;
    
    private KeyboardInfo() {
        super();
    }
    
    public final int getKeyboardHeight() {
        return 0;
    }
    
    public final void setKeyboardHeight(int p0) {
    }
    
    public final int getKeyboardState() {
        return 0;
    }
    
    public final void setKeyboardState(int p0) {
    }
}