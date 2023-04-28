/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters.holders

import android.view.View
import android.widget.TextView
import com.contusfly.R

/**
 * The Class Notification View Holder. Which will have the notification on the chat view.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class NotificationViewHolder(view: View) : DateViewHolder(view) {
    /**
     * Notification view for the group operations
     */
    val notificationView: TextView = view.findViewById(R.id.text_notification)

}