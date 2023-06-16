package com.contusfly.models

import com.google.gson.annotations.SerializedName

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
data class RegisterData(
        @field:SerializedName("data")
        val data: String? = null,

        @field:SerializedName("message")
        val message: String? = null,

        @field:SerializedName("status")
        val status: Int? = null
)
