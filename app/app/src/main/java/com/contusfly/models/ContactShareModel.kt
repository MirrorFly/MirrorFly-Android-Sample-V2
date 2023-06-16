package com.contusfly.models

import com.mirrorflysdk.models.Contact
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Model Class to hold the name and list of phone numbers while sharing contact from Third party apps
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@Parcelize
class ContactShareModel(var name: String, var contactArrayList: ArrayList<Contact>) : Parcelable