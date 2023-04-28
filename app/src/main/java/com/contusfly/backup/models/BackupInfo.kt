package com.contusfly.backup.models

import com.contusfly.emptyString

data class BackupInfo(var fileSize: String, var date: String, var skipProfile: Boolean = false,var fileId:String = emptyString())