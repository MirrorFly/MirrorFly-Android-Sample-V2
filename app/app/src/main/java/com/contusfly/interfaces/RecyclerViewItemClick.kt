package com.contusfly.interfaces

import com.mirrorflysdk.api.contacts.ProfileDetails


/**
 * Listener to get the click action on item from file list adapter
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
interface RecyclerViewItemClick {

    /**
     * Callback Method for Clicking an item
     *
     * @param position - position
     * @param profileDetails   - ProfileDetails
     */
    fun onItemClicked(position: Int, profileDetails: ProfileDetails)

    /**
     * Method to check whether this item is selected or not
     */
    fun isSelected(userId: String): Boolean

}