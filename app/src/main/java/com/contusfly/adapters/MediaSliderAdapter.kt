/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.contusfly.fragments.MediaFragment
import com.mirrorflysdk.api.models.ChatMessage

/**
 * Display the media file in slider for the single user
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class MediaSliderAdapter(fm: FragmentManager?, private val messageList: List<ChatMessage>) :
    FragmentStatePagerAdapter(fm!!) {

    override fun getItem(position: Int): Fragment {
        return MediaFragment.newInstance(messageList[position])
    }

    override fun getCount(): Int {
        return messageList.size
    }

    override fun getItemPosition(position: Any): Int {
        return POSITION_NONE
    }
}