package com.contusfly.models

import com.google.gson.annotations.SerializedName

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
data class ContactSyncData(
        @field:SerializedName("data")
        val data: ContusContactList? = null,

        @field:SerializedName("error")
        val error: String? = null,

        @field:SerializedName("message")
        val message: String? = null,

        @field:SerializedName("status")
        val status: Int? = null
)
