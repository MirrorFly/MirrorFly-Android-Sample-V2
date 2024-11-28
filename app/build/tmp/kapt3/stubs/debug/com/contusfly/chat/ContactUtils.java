package com.contusfly.chat;

import java.lang.System;

/**
 * Handles the contact selection from the chat and return back to the chat view and send it to
 * the receiver.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/contusfly/chat/ContactUtils;", "", "()V", "CONTACTS_COUNT", "", "checkContact", "", "contacts", "", "Lcom/mirrorflysdk/models/Contact;", "number", "getContactCount", "", "activity", "Landroid/content/Context;", "getContactsFromCursor", "pCur", "Landroid/database/Cursor;", "name", "app_debug"})
public final class ContactUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.chat.ContactUtils INSTANCE = null;
    
    /**
     * SharedPreference key for contacts count
     */
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CONTACTS_COUNT = "contacts_count";
    
    private ContactUtils() {
        super();
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
}