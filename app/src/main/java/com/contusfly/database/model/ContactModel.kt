package com.contusfly.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactModel (
    @ColumnInfo(name = "jid") @PrimaryKey var jid: String,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "image") var image: String?,
    @ColumnInfo(name = "mobileNumber") var mobileNumber: String?,
    @ColumnInfo(name = "status") var status: String?,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "isMuted") var isMuted: Boolean?,
    @ColumnInfo(name = "isBlocked") var isBlocked: Boolean?,
    @ColumnInfo(name = "isBlockedMe") var isBlockedMe: Boolean?,
    @ColumnInfo(name = "isAdminBlocked") var isAdminBlocked: Boolean?
)