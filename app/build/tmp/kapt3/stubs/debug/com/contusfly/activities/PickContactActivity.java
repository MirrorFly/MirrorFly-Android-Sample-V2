package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0014J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\'H\u0016J\u0012\u0010(\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010*\u001a\u00020\u001bH\u0014J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J \u0010-\u001a\u00020\u001b2\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002J\b\u0010/\u001a\u00020\u001bH\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/contusfly/activities/PickContactActivity;", "Lcom/contusfly/activities/BaseActivity;", "()V", "contactsList", "", "Lcom/mirrorflysdk/models/Contact;", "isContactSelected", "", "()Z", "isFromQuickShare", "phoneNumbers", "", "", "shareContactList", "Ljava/util/ArrayList;", "Lcom/contusfly/models/ContactShareModel;", "Lkotlin/collections/ArrayList;", "shareDialog", "Lcom/contusfly/views/ShareDialog;", "shareMessagesController", "Lcom/contusfly/chat/ShareMessagesController;", "getShareMessagesController", "()Lcom/contusfly/chat/ShareMessagesController;", "setShareMessagesController", "(Lcom/contusfly/chat/ShareMessagesController;)V", "userIdList", "finishQuickShare", "", "navigateToAppropriateScreen", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPostCreate", "onPrepareOptionsMenu", "onResume", "prepareAndSendContactMessage", "readPhoneNumberActiveType", "sendContacts", "contactList", "validateSelection", "app_debug"})
public final class PickContactActivity extends com.contusfly.activities.BaseActivity {
    
    /**
     * List of contactsList to set in the recycler view
     */
    private java.util.List<? extends com.mirrorflysdk.models.Contact> contactsList;
    private java.util.ArrayList<com.contusfly.models.ContactShareModel> shareContactList;
    private java.util.ArrayList<java.lang.String> userIdList;
    private java.util.List<java.lang.String> phoneNumbers;
    private boolean isFromQuickShare = false;
    @javax.inject.Inject()
    public com.contusfly.chat.ShareMessagesController shareMessagesController;
    private com.contusfly.views.ShareDialog shareDialog;
    private java.util.HashMap _$_findViewCache;
    
    public PickContactActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.chat.ShareMessagesController getShareMessagesController() {
        return null;
    }
    
    public final void setShareMessagesController(@org.jetbrains.annotations.NotNull()
    com.contusfly.chat.ShareMessagesController p0) {
    }
    
    /**
     * creating the layout
     *
     * @param savedInstanceState instance
     */
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    /**
     * creating the views
     *
     * @param savedInstanceState instance
     */
    @java.lang.Override()
    protected void onPostCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to .
     *
     * @param menu menu
     * @return menu
     */
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    /**
     * Prepare the Screen's standard options menu to be displayed.  This is
     * called right before the menu is shown, every time it is shown.
     *
     * @param menu The options menu as last shown or first initialized by onCreateOptionsMenu().
     * @return You must return true for the menu to be displayed; if you return false it will not be shown.
     */
    @java.lang.Override()
    public boolean onPrepareOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to proceed, true to consume it here.
     * @see .onCreateOptionsMenu
     */
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    /**
     * Validate  the contact selection And send back to the chat view to send the contact to the
     * receiver.
     */
    private final void validateSelection() {
    }
    
    private final boolean isContactSelected() {
        return false;
    }
    
    /**
     * Reads the information about the active type of the phone numbers selected to be shared
     * in the chat window, whether the number is registered with the application or not.
     * Status of 1 represents that the number is registered with the application and vice-versa.
     */
    private final void readPhoneNumberActiveType() {
    }
    
    private final void prepareAndSendContactMessage() {
    }
    
    private final void sendContacts(java.util.ArrayList<com.contusfly.models.ContactShareModel> contactList) {
    }
    
    /**
     * If single user/group, then navigate to it's chat
     * if multiple then navigate to Dashboard screen
     */
    private final void navigateToAppropriateScreen() {
    }
    
    private final void finishQuickShare() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}