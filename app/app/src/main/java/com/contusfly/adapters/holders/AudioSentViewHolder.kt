package com.contusfly.adapters.holders

import android.view.View
import com.contusfly.R

/**
 * The Class AudioViewHolder for the sent audio messages.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class AudioSentViewHolder(private val mainView: View) : BaseAudioViewHolder(mainView) {

    /**
     * Instantiates a new audio view holder.
     *
     * @param view the view
     */
    init {
        imgSenderStatus = mainView.findViewById(R.id.image_audio_status)
        audSentStarred = mainView.findViewById(R.id.image_audio_favorite)
        viewDiver = mainView.findViewById(R.id.view_divider)
    }
}