/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters.holders

import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.contusfly.R

/**
 * The Class Image View Holder for display the image view in the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class ImageSentViewHolder(mainView: View) : BaseSentViewHolder(mainView) {
    val bg: RelativeLayout? = mainView.findViewById(R.id.baloon)
    val viewDiver: View? = mainView.findViewById(R.id.view_divider)
}