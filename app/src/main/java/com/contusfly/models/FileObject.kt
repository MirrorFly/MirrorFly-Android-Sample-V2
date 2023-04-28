package com.contusfly.models

import android.net.Uri
import android.os.Parcelable
import com.contusfly.chat.FileMimeType
import com.contusfly.utils.Constants
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@Parcelize
class FileObject(var uri: Uri?, var filePath: String, var name: String, var duration: Long,
                 var size: Long, var fileValidation: HashMap<String, Boolean>?, @FileMimeType
                 var fileMimeType: String, var fileExtension: String,
                 var readableSize: String, var readableDuration: String, var caption: String): Parcelable {

    /*
    * Default Constructor */
    constructor() : this(null, Constants.EMPTY_STRING, Constants.EMPTY_STRING, 0L, 0L,
        null, Constants.EMPTY_STRING, Constants.EMPTY_STRING, Constants.EMPTY_STRING, Constants.EMPTY_STRING, Constants.EMPTY_STRING)

                 }