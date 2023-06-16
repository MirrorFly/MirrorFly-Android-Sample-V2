package com.contusfly.utils;

import java.lang.System;

/**
 * This Class Which handle emoji keypad and the normal keypad
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 .2\u00020\u0001:\u0002./B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0006\u0010$\u001a\u00020\u001eJ\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0018J\u0010\u0010\'\u001a\u00020\u001e2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\fJ\u000e\u0010*\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0006J\b\u0010-\u001a\u00020\u001eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u00060"}, d2 = {"Lcom/contusfly/utils/EmojiHandler;", "", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragmentCView", "Landroid/view/View;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "handledFrom", "", "icon", "Landroid/widget/ImageView;", "inputManager", "Landroid/view/inputmethod/InputMethodManager;", "isBlackTheme", "", "()Z", "setBlackTheme", "(Z)V", "<set-?>", "isEmojiShowing", "isInflated", "mEmojiKeyBoardListener", "Lcom/contusfly/utils/EmojiHandler$EmojiKeyBoardListener;", "getMEmojiKeyBoardListener", "()Lcom/contusfly/utils/EmojiHandler$EmojiKeyBoardListener;", "setMEmojiKeyBoardListener", "(Lcom/contusfly/utils/EmojiHandler$EmojiKeyBoardListener;)V", "attachKeyboardListeners", "", "yourEditText", "Landroid/widget/EditText;", "changeKeyboardLayout", "showEmoticons", "emojiconEditText", "hideEmoji", "setEmojiKeyBoardListener", "emojiKeyBoardListener", "setHandledFrom", "setIconImageView", "imageView", "setIsBlackTheme", "setKeypad", "view", "viewEmoji", "Companion", "EmojiKeyBoardListener", "app_debug"})
public final class EmojiHandler {
    
    /**
     * Fragment manager for inflating emoji fragment
     */
    private final androidx.fragment.app.FragmentManager fragmentManager = null;
    
    /**
     * Emoji is showing or not
     */
    private boolean isEmojiShowing = false;
    private boolean isBlackTheme = false;
    @org.jetbrains.annotations.Nullable()
    private com.contusfly.utils.EmojiHandler.EmojiKeyBoardListener mEmojiKeyBoardListener;
    
    /**
     * Input manager to handle the soft keypad
     */
    private final android.view.inputmethod.InputMethodManager inputManager = null;
    
    /**
     * Instance of the emoji fragment view
     */
    private final android.view.View fragmentCView = null;
    
    /**
     * Icon for getting Emoji keypad
     */
    private android.widget.ImageView icon;
    
    /**
     * This flag is used to inflate the fragment at first time
     */
    private boolean isInflated = false;
    
    /**
     * Denotes the handling activity
     */
    private java.lang.String handledFrom;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.EmojiHandler.Companion Companion = null;
    
    public EmojiHandler(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity context) {
        super();
    }
    
    public final boolean isEmojiShowing() {
        return false;
    }
    
    public final boolean isBlackTheme() {
        return false;
    }
    
    public final void setBlackTheme(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.contusfly.utils.EmojiHandler.EmojiKeyBoardListener getMEmojiKeyBoardListener() {
        return null;
    }
    
    public final void setMEmojiKeyBoardListener(@org.jetbrains.annotations.Nullable()
    com.contusfly.utils.EmojiHandler.EmojiKeyBoardListener p0) {
    }
    
    /**
     * Set the icon image view which might be keypad or icon
     *
     * @param imageView Instance of the ImageView
     */
    public final void setIconImageView(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView imageView) {
    }
    
    /**
     * Set the handling activity
     *
     * @param handledFrom Instance of the ImageView
     */
    public final void setHandledFrom(@org.jetbrains.annotations.Nullable()
    java.lang.String handledFrom) {
    }
    
    /**
     * Set the keypad
     *
     * @param view View of the edit text
     */
    public final void setKeypad(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    /**
     * change the keypad based on Emoji or text
     *
     * @param showEmoticons    True if emoji keypad going to display
     * @param emojiconEditText View for the edit text
     */
    private final void changeKeyboardLayout(boolean showEmoticons, android.view.View emojiconEditText) {
    }
    
    /**
     * View the emoji keypad
     */
    private final void viewEmoji() {
    }
    
    /**
     * View the emoji keypad
     */
    public final void hideEmoji() {
    }
    
    /**
     * Attach the keypad listener to handle soft keypad is open state or close state
     *
     * @param yourEditText Edit text for the Emoji
     */
    public final void attachKeyboardListeners(@org.jetbrains.annotations.NotNull()
    android.widget.EditText yourEditText) {
    }
    
    public final void setIsBlackTheme(boolean isBlackTheme) {
    }
    
    public final void setEmojiKeyBoardListener(@org.jetbrains.annotations.NotNull()
    com.contusfly.utils.EmojiHandler.EmojiKeyBoardListener emojiKeyBoardListener) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/utils/EmojiHandler$EmojiKeyBoardListener;", "", "onKeyBoardStateChanged", "", "isOpened", "", "app_debug"})
    public static abstract interface EmojiKeyBoardListener {
        
        public abstract void onKeyBoardStateChanged(boolean isOpened);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/utils/EmojiHandler$Companion;", "", "()V", "getEmojiCharLength", "", "text", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Get the length of the string with emoji characters
         *
         * @param text Text for count
         * @return int length of the string
         */
        public final int getEmojiCharLength(@org.jetbrains.annotations.NotNull()
        java.lang.String text) {
            return 0;
        }
    }
}