package com.contusfly.utils

class MediaCaptionMentionList(
var path: String="",
var caption: String = "",
var mentionedUsersIds: List<String> =ArrayList<String>(),
var isImage:Boolean=true) {
    var mediaCaptionParameters=ArrayList<MediaCaptionMentionList>()
}