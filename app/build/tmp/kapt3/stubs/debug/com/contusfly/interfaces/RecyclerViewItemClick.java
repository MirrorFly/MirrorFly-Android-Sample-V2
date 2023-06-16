package com.contusfly.interfaces;

import java.lang.System;

/**
 * Listener to get the click action on item from file list adapter
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/contusfly/interfaces/RecyclerViewItemClick;", "", "isSelected", "", "userId", "", "onItemClicked", "", "position", "", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "app_debug"})
public abstract interface RecyclerViewItemClick {
    
    /**
     * Callback Method for Clicking an item
     *
     * @param position - position
     * @param profileDetails   - ProfileDetails
     */
    public abstract void onItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails);
    
    /**
     * Method to check whether this item is selected or not
     */
    public abstract boolean isSelected(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
}