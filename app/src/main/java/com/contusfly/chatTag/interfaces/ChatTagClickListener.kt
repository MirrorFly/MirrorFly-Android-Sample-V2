package com.contusfly.chatTag.interfaces

import com.mirrorflysdk.api.models.RecentChat

interface ChatTagClickListener {

    fun selectUnselectChat(position:Int,item:RecentChat,isSelectionlist:Boolean)
    fun filterListUpdated(filterList:ArrayList<RecentChat>)
}
