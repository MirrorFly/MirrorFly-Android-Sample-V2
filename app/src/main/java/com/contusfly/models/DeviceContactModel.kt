package com.contusfly.models

import android.os.Parcelable
import com.mirrorflysdk.api.contacts.ProfileDetails
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DeviceContactModel(val contactId: String, val name: String, var mobileNumbers: MutableList<PhoneNumber>, var profileDetails: ProfileDetails?): Parcelable {
    constructor(contactId: String, name: String) : this(contactId, name, mutableListOf(), null)
}

@Parcelize
data class PhoneNumber(val phoneNumber: String, val numberType: String, var isSelected: Boolean) : Parcelable