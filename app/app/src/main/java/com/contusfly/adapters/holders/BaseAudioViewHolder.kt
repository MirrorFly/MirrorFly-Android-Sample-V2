package com.contusfly.adapters.holders

import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.contusfly.R
import com.contusfly.views.MirrorFlySeekBar

open class BaseAudioViewHolder(view: View) : SenderNameHolder(view) {
    /**
     * View for the total chat view
     */
    var viewRowItem: View = view.findViewById(R.id.row_chat_audio)

    /**
     * Space to add when the previous message is different
     */
    var space: View = view.findViewById(R.id.space_view)


    /**
     * Download progress view
     */
    var progressUploadDownloadLayout: RelativeLayout = view.findViewById(R.id.download_progress_layout)

    /**
     * Image view for sender status
     */
    var imgSenderStatus: ImageView? = null

    /**
     * Receiver view of the layout
     */
    val viewReceiver: View? = null

    /**
     * Audio view for sender
     */
    val viewSender: LinearLayout? = null

    /**
     * Sender Text view for time
     */
    val txtSendTime: AppCompatTextView = view.findViewById(R.id.text_audio_time)

    /**
     * Receiver Text view for time
     */
    val txtRevTime: TextView? = null

    /**
     * Text view for audio duration
     */
    val txtAudioDuration: AppCompatTextView = view.findViewById(R.id.text_audio_duration)

    val imgAudioType: AppCompatImageView = view.findViewById(R.id.image_audio_type)

    /**
     * The progress view for audio upload in sender side.
     */
    val progressSender: ProgressBar = view.findViewById(R.id.progress_audio_upload)

    /**
     * The progress view for audio upload buffer in sender side.
     */
    val progressUploadDownloadBuffer: ProgressBar = view.findViewById(R.id.progress_buffer)

    /**
     * The progress view for audio upload in receiver side.
     */
    val progressRev: ProgressBar? = null

    /**
     * Download image view
     */
    val viewDownload: ImageView? = null

    /**
     * The View retry.
     */
    val viewRetry: RelativeLayout = view.findViewById(R.id.audio_retry_layout)

    /**
     * The View carbon retry.
     */
    val viewCarbonRetry: RelativeLayout? = view.findViewById(R.id.audio_carbon_retry_layout)

    /**
     * Play button for the audio
     */
    val imgAudioPlay: ImageView = view.findViewById(R.id.image_audio_action)

    /**
     * Received audio starred
     */
    lateinit var audRevStarred: ImageView

    /**
     * Sent audio starred
     */
    lateinit var audSentStarred: ImageView

    /**
     * Audio seek bar
     */
    val audioMirrorFlySeekBar: MirrorFlySeekBar = view.findViewById(R.id.seek_audio_progress)

    /**
     * Image view for sent carbon download
     */
    val sentCarbonAudioDownload: ImageView? = null

    /**
     * Image view for forward
     */
    val sentAudioForwardImage: ImageView? = view.findViewById(R.id.send_img_forward)

    var viewDiver: View? = view.findViewById(R.id.view_divider)
}