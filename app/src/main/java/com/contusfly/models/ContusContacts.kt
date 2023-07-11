package com.contusfly.models


import com.google.gson.annotations.SerializedName

/**
 * Retriving the contus contact
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
class ContusContacts {
    @SerializedName("mobileNumber")
    var mobileNumber: String? = null

    @SerializedName("isChatUser")
    var isChatUser = 0

    @SerializedName("name")
    var name: String? = null

    @SerializedName("image")
    var image: String? = null

    @SerializedName("emailId")
    var email: String? = null

    @SerializedName("username")
    var username: String? = null

    @SerializedName("statusMsg")
    var statusMsg: String? = null
    var activeType: String? = null
    var colourCode = 0
}
