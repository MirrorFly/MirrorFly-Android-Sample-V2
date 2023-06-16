package com.contusfly.views;

import java.lang.System;

/**
 * This class used to display the progress dialog for the default 5000 milli seconds for doing any
 * operation at that time.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/views/TimerProgressDialog;", "Lcom/contusfly/views/DoProgressDialog;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "time", "", "(Landroid/app/Activity;J)V", "showToast", "", "(Landroid/app/Activity;JZ)V", "activity", "mTimer", "Ljava/util/Timer;", "dismiss", "", "showProgress", "app_debug"})
public final class TimerProgressDialog extends com.contusfly.views.DoProgressDialog {
    
    /**
     * Activity of the user View.
     */
    private final android.app.Activity activity = null;
    
    /**
     * Duration for the timer
     */
    private final long time = 0L;
    
    /**
     * Timer for the progress dialog delay.
     */
    private java.util.Timer mTimer;
    private boolean showToast = true;
    
    /**
     * Instantiates a new do progress dialog.
     *
     * @param context Instance of the startupActivityContext
     */
    public TimerProgressDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity context) {
        super(null);
    }
    
    /**
     * Instantiates a new do progress dialog.
     *
     * @param context Instance of the startupActivityContext
     * @param time    Duration of the progress dialog
     */
    public TimerProgressDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity context, long time) {
        super(null);
    }
    
    public TimerProgressDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity context, long time, boolean showToast) {
        super(null);
    }
    
    @java.lang.Override()
    public void showProgress() {
    }
    
    @java.lang.Override()
    public void dismiss() {
    }
}