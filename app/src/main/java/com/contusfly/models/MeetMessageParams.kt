package com.contusfly.models

import com.mirrorflysdk.flycommons.Constants

data class MeetMessageParams(var title: String = Constants.EMPTY_STRING, var link:String, var scheduleMeetDateTime: Long, var editMessageId:String = Constants.EMPTY_STRING)