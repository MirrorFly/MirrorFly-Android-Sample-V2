/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters.holders

import android.view.View
import com.contusfly.R

/**
 * The Class Image View Holder for display the image view in the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class ImageReceivedViewHolder(mainView: View) : BaseReceivedViewHolder(mainView){
    val viewDiver: View? = mainView.findViewById(R.id.view_divider)
}