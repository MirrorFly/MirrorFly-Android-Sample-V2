package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/utils/StatusDeleteDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "updateAdapterListener", "Lcom/contusfly/utils/StatusDeleteDialog$UpdateAdapterListener;", "setUpdateAdapterListener", "", "showDeleteStatusAlert", "UpdateAdapterListener", "app_debug"})
public final class StatusDeleteDialog {
    
    /**
     * The startupActivityContext of the calling parent.
     */
    private android.content.Context context;
    
    /**
     * Listener used to dispatch user events.
     */
    private com.contusfly.utils.StatusDeleteDialog.UpdateAdapterListener updateAdapterListener;
    
    /**
     * The default instance of the class.
     *
     * @param context The startupActivityContext of the calling parent.
     */
    public StatusDeleteDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Alert to show the user while choose status delete option
     */
    public final void showDeleteStatusAlert() {
    }
    
    public final void setUpdateAdapterListener(@org.jetbrains.annotations.NotNull()
    com.contusfly.utils.StatusDeleteDialog.UpdateAdapterListener updateAdapterListener) {
    }
    
    /**
     * Interface definition for a callback to be invoked when user wants to delete the status.
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/contusfly/utils/StatusDeleteDialog$UpdateAdapterListener;", "", "onNotifyAdapter", "", "app_debug"})
    public static abstract interface UpdateAdapterListener {
        
        /**
         * The callback method to notify the adapter.
         */
        public abstract void onNotifyAdapter();
    }
}