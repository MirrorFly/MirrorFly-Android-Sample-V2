package com.contusfly.interfaces

import androidx.annotation.StringDef

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@StringDef(
    RecentChatEvent.GROUP_EVENT, RecentChatEvent.ARCHIVE_EVENT,
    RecentChatEvent.MESSAGE_RECEIVED, RecentChatEvent.MESSAGE_UPDATED,
    RecentChatEvent.MUTE_EVENT, RecentChatEvent.PIN_EVENT
)
annotation class RecentChatEvent {
    companion object {
        // Define the list of accepted constants
        const val GROUP_EVENT = "group_events"
        const val ARCHIVE_EVENT = "archive_events"
        const val MESSAGE_RECEIVED = "message_received"
        const val MESSAGE_UPDATED = "message_updated"
        const val MUTE_EVENT = "mute_event"
        const val PIN_EVENT = "pin_event"
    }
}
