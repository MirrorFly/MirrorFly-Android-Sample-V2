package com.contusfly.call.groupcall.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\nJ\b\u0010\u0012\u001a\u00020\nH\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/contusfly/call/groupcall/helpers/IncomingCallViewHelper;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "binding", "Lcom/contusfly/databinding/LayoutIncomingCallBinding;", "activityOnClickListener", "Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;", "(Landroid/content/Context;Lcom/contusfly/databinding/LayoutIncomingCallBinding;Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;)V", "actionClick", "", "curY", "", "hideIncomingCallLayout", "onClick", "v", "Landroid/view/View;", "setUpCallUI", "setUpIncomingCall", "Companion", "app_debug"})
public final class IncomingCallViewHelper implements android.view.View.OnClickListener {
    private final android.content.Context context = null;
    private final com.contusfly.databinding.LayoutIncomingCallBinding binding = null;
    private final com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.call.groupcall.helpers.IncomingCallViewHelper.Companion Companion = null;
    
    /**
     * This flag indicates whether the call button motion started or not
     */
    private static boolean begin = false;
    private static float answerY = 0.0F;
    private static float oldMove = 0.0F;
    
    public IncomingCallViewHelper(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.contusfly.databinding.LayoutIncomingCallBinding binding, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener) {
        super();
    }
    
    public final void setUpCallUI() {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    public final void setUpIncomingCall() {
    }
    
    /**
     * This function is used to perform the click operation on [.binding.imageCallAnswer] or
     * [.activityBinding.imageCallReject] when the [.binding.btnCallSwipe] is near those buttons.
     *
     * @param curY call swipe button [.binding.btnCallSwipe] y position
     */
    private final void actionClick(float curY) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final void hideIncomingCallLayout() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/call/groupcall/helpers/IncomingCallViewHelper$Companion;", "", "()V", "answerY", "", "getAnswerY", "()F", "setAnswerY", "(F)V", "begin", "", "getBegin", "()Z", "setBegin", "(Z)V", "oldMove", "getOldMove", "setOldMove", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean getBegin() {
            return false;
        }
        
        public final void setBegin(boolean p0) {
        }
        
        public final float getAnswerY() {
            return 0.0F;
        }
        
        public final void setAnswerY(float p0) {
        }
        
        public final float getOldMove() {
            return 0.0F;
        }
        
        public final void setOldMove(float p0) {
        }
    }
}