package com.contusfly.call.groupcall.listeners

import com.mirrorflysdk.api.contacts.ProfileDetails

interface RecyclerViewUserItemClick {
    /**
     * Callback Method for Clicking an item
     *
     * @param position - position
     * @param profileDetails   - ProfileDetails
     */
    fun onItemClicked(position: Int, profileDetails: ProfileDetails)

    /**
     * Callback Method for Clicking an blocked user item
     *
     * @param profileDetails  - ProfileDetails
     */
    fun onSelectBlockedUser(profileDetails: ProfileDetails)

    /**
     * Callback Method for check selected or not
     *
     * @param userId   - User id of the user
     */
    fun isSelected(userId: String) : Boolean
}