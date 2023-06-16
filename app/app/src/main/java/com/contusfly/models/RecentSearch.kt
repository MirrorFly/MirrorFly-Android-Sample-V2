package com.contusfly.models

import com.mirrorflysdk.api.contacts.ProfileDetails

class RecentSearch(
    var jid: String,
    var mid: String,
    var searchType: String,
    var chatType: String,
    var search: Boolean,
    var profileDetails: ProfileDetails
) {
    var recentSearchList: List<RecentSearch>? = null

}