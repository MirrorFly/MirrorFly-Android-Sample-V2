package com.contusfly.models

import com.mirrorflysdk.api.contacts.ProfileDetails

/**
 * Model Class used to Populate Contact , Recent and group in Quick Share List
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
data class ProfileDetailsShareModel(var type: String, var profileDetails: ProfileDetails)