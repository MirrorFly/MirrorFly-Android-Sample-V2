package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J \u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/contusfly/utils/ContactUtils;", "", "()V", "CONTACTS_COUNT", "", "getCONTACTS_COUNT", "()Ljava/lang/String;", "checkContact", "", "contacts", "", "Lcom/mirrorflysdk/models/Contact;", "number", "checkEmailContactForBlockAndUnblockUser", "", "jid", "status", "checkEmailContactForProfileUpdate", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getContactCount", "", "activity", "Landroid/content/Context;", "getContactsFromCursor", "pCur", "Landroid/database/Cursor;", "name", "handleContactSelection", "context", "data", "Landroid/content/Intent;", "app_debug"})
public final class ContactUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.ContactUtils INSTANCE = null;
    
    /**
     * SharedPreference key for contacts count
     */
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CONTACTS_COUNT = "contacts_count";
    
    private ContactUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCONTACTS_COUNT() {
        return null;
    }
    
    /**
     * This method returns the contacts count
     *
     * @param activity startupActivityContext
     * @return contacts count
     */
    public final int getContactCount(@org.jetbrains.annotations.NotNull
    android.content.Context activity) {
        return 0;
    }
    
    /**
     * Get the contact list from the cursor
     *
     * @param pCur Cursor from the contact
     * @param name Name of the contact
     * @return List<Contact> List of contacts
     *   </Contact>
     */
    private final java.util.List<com.mirrorflysdk.models.Contact> getContactsFromCursor(android.database.Cursor pCur, java.lang.String name) {
        return null;
    }
    
    /**
     * Check the contact is available or not contact.
     *
     * @param contacts List of contacts
     * @param number   The number
     * @return boolean True if successful
     */
    private final boolean checkContact(java.util.List<? extends com.mirrorflysdk.models.Contact> contacts, java.lang.String number) {
        return false;
    }
    
    /**
     * Handle onActivityResult callback Handle contact selection.
     *
     * @param context context of the activity
     * @param data    Intent
     */
    public final void handleContactSelection(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.content.Intent data) {
    }
    
    public final void checkEmailContactForBlockAndUnblockUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, boolean status) {
    }
    
    public final void checkEmailContactForProfileUpdate(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
}