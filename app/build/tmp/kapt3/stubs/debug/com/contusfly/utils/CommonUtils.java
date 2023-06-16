package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/contusfly/utils/CommonUtils;", "", "()V", "Companion", "app_debug"})
public class CommonUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.CommonUtils.Companion Companion = null;
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    private static com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog;
    @org.jetbrains.annotations.NotNull()
    private static android.content.DialogInterface dialogInterface;
    @org.jetbrains.annotations.NotNull()
    private static com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    private static final float MILLISECONDS_PER_INCH = 70.0F;
    private static final int DIMENSION = 2;
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    
    public CommonUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001c\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\"H\u0002J\u0016\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'J\u0016\u0010(\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0004J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020 H\u0003J\u0016\u0010.\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010/\u001a\u000200J$\u00101\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0002J\u0012\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000105J\u000e\u00107\u001a\u0002082\u0006\u0010\u0019\u001a\u00020%J\u000e\u00109\u001a\u0002082\u0006\u0010\u0019\u001a\u00020%J\u0012\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010\"J\u000e\u0010=\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020%J\u000e\u0010>\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020%J\u001e\u0010?\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020@2\u0006\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\u0004J\u001e\u0010C\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010D\u001a\u0002082\u0006\u0010E\u001a\u00020FR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006G"}, d2 = {"Lcom/contusfly/utils/CommonUtils$Companion;", "", "()V", "DIMENSION", "", "HORIZONTAL", "MILLISECONDS_PER_INCH", "", "VERTICAL", "bottomSheetCallback", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "getBottomSheetCallback", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "setBottomSheetCallback", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;)V", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "dialogInterface", "Landroid/content/DialogInterface;", "getDialogInterface", "()Landroid/content/DialogInterface;", "setDialogInterface", "(Landroid/content/DialogInterface;)V", "addContactInMobile", "", "context", "Landroid/app/Activity;", "contactMessage", "Lcom/mirrorflysdk/api/models/ContactChatMessage;", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "chatTagRemoveBottomDialogShow", "mContext", "Landroid/content/Context;", "buttonclick", "Lcom/contusfly/chatTag/interfaces/DialogPositiveButtonClick;", "convertDpToPixel", "dp", "createSnapScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "cropImage", "file", "Ljava/io/File;", "distanceToCenter", "helper", "Landroidx/recyclerview/widget/OrientationHelper;", "getJidFromUser", "", "user", "isNetConnected", "", "isPipModeAllowed", "locateView", "Landroid/graphics/Rect;", "v", "navigateUserToLoggedOutUI", "openPipModeSettings", "scrollToCenter", "Landroidx/recyclerview/widget/LinearLayoutManager;", "recyclerList", "clickPosition", "showBottomSheetView", "hasRemovePhoto", "listener", "Landroid/content/DialogInterface$OnClickListener;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * @param context context required to get system service
         * @return true , if PIP is not disabled by the user
         */
        public final boolean isPipModeAllowed(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return false;
        }
        
        /**
         * opens the pip mode setting for the current app
         *
         * @param context context
         */
        public final void openPipModeSettings(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        /**
         * @param v view to get coordinates on screen
         * @return coordinates of the view on the screen
         */
        @org.jetbrains.annotations.Nullable()
        public final android.graphics.Rect locateView(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
            return null;
        }
        
        /**
         * This method converts dp unit to equivalent pixels, depending on device density.
         *
         * @param context Context to get resources and device specific display metrics
         * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
         * @return A int value to represent px equivalent to dp depending on device density
         */
        public final int convertDpToPixel(@org.jetbrains.annotations.NotNull()
        android.content.Context context, int dp) {
            return 0;
        }
        
        /**
         * Checks if is net connected.
         *
         * @param context The instance of context
         * @return boolean True if is net connected
         */
        public final boolean isNetConnected(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return false;
        }
        
        /**
         * Sign out from the gPlus account.
         *
         * @param context the startupActivityContext of the calling parent.
         */
        public final void navigateUserToLoggedOutUI(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        /**
         * Open the add-contact screen with pre-filled info. The received contact will be stored in
         * local contact. The [ContactMessage] will be used to parse the contact details
         * and to store the contact
         *
         * @param context        Activity context
         * @param contactMessage Instance of ContactMessage
         */
        public final void addContactInMobile(@org.jetbrains.annotations.NotNull()
        android.app.Activity context, @org.jetbrains.annotations.NotNull()
        com.mirrorflysdk.api.models.ContactChatMessage contactMessage) {
        }
        
        /**
         * Show bottom list in the Alter dialog.
         *
         * @param context  Instance of Context
         * @param listener Instance of DialogInterface.OnClickListener
         */
        public final void showBottomSheetView(@org.jetbrains.annotations.NotNull()
        android.app.Activity context, boolean hasRemovePhoto, @org.jetbrains.annotations.NotNull()
        android.content.DialogInterface.OnClickListener listener) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.DialogInterface getDialogInterface() {
            return null;
        }
        
        public final void setDialogInterface(@org.jetbrains.annotations.NotNull()
        android.content.DialogInterface p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback getBottomSheetCallback() {
            return null;
        }
        
        public final void setBottomSheetCallback(@org.jetbrains.annotations.NotNull()
        com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback p0) {
        }
        
        /**
         * Crop the image from the Any size of image at Square.
         *
         * @param context Instance of Context
         * @param file    Instance of File
         */
        public final void cropImage(@org.jetbrains.annotations.NotNull()
        android.app.Activity context, @org.jetbrains.annotations.NotNull()
        java.io.File file) {
        }
        
        /**
         * Get the jabber id of the user
         *
         * @param user    User name
         * @return String Jabber id
         */
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getJidFromUser(@org.jetbrains.annotations.Nullable()
        java.lang.String user) {
            return null;
        }
        
        public final void chatTagRemoveBottomDialogShow(@org.jetbrains.annotations.NotNull()
        android.content.Context mContext, @org.jetbrains.annotations.NotNull()
        com.contusfly.chatTag.interfaces.DialogPositiveButtonClick buttonclick) {
        }
        
        public final void scrollToCenter(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.LinearLayoutManager layoutManager, @org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView recyclerList, int clickPosition) {
        }
        
        @androidx.annotation.Nullable()
        private final androidx.recyclerview.widget.LinearSmoothScroller createSnapScroller(androidx.recyclerview.widget.RecyclerView mRecyclerView, androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
            return null;
        }
        
        private final int[] calculateDistanceToFinalSnap(@androidx.annotation.NonNull()
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, @androidx.annotation.NonNull()
        android.view.View targetView) {
            return null;
        }
        
        private final int distanceToCenter(@androidx.annotation.NonNull()
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, @androidx.annotation.NonNull()
        android.view.View targetView, androidx.recyclerview.widget.OrientationHelper helper) {
            return 0;
        }
    }
}