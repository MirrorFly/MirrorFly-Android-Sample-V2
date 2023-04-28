package com.contusfly.adapters.holders

import android.view.View
import com.contusfly.R

/**
 * The Class AudioViewHolder for the received audio messages.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class AudioReceivedViewHolder(private val mainView: View) : BaseAudioViewHolder(mainView){

    init {
        audRevStarred = mainView.findViewById(R.id.image_audio_favorite)
        viewDiver = mainView.findViewById(R.id.view_divider)
    }

}