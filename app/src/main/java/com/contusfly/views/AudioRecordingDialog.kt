package com.contusfly.views

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.os.Build
import android.view.View
import android.view.Window
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.utils.AudioRecorder
import com.contusfly.utils.ChatMessageUtils.setFormattedTimeTextView
import com.mirrorflysdk.views.CustomToast

/**
 * This utility class shows audio recording dialog and records audio based on the media state
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class AudioRecordingDialog(private val context: Activity, private val onClickListener: View.OnClickListener) : AudioRecorder.AudioRecordingListener {
    /*
     * Audiomanager
     */
    private val mAudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    /**
     * The dialog recording to display the user for sending the  audio file to the user
     */
    private var dialogRecording: Dialog? = null

    /**
     * Recording timer of the audio view to record the audio in the custom alert dialog
     */
    private var recordingTimerTextView: TextView? = null

    /**
     * Record complete text in the alert dialog to close the dialog
     */
    private var recordingCompleteTextView: TextView? = null

    /**
     * Recording image view in the alert dialog
     */
    private var recordingImageView: ImageView? = null
    /**
     * Gets {@see mediaState}
     *
     * @return [.mediaState]
     */
    /**
     * The media state of the audio in the audio
     */
    var mediaState = 0
        private set

    /**
     * The audio recorder to record the audio in the chat view
     */
    private var audioRecorder: AudioRecorder? = null
    /**
     * Gets {@see mediaPath}
     *
     * @return [.mediaPath]
     */
    /**
     * Media path of the recording file
     */
    var mediaPath: String? = null
        private set
    private val focusChangeListener: AudioManager.OnAudioFocusChangeListener
    private var anim: Animation? = null

    /**
     * When user clicked Start recording in the view we have to call this method
     */
    fun startRecording() {
        try {
            if (requestAudioFocus(focusChangeListener, AudioManager.USE_DEFAULT_STREAM_TYPE,
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE)) {
                audioRecorder = AudioRecorder(context, this)
                mediaPath = audioRecorder!!.startRecording()
                mediaState = Constants.COUNT_ONE
                recordingImageView!!.setImageResource(R.drawable.onrecord)
                anim = AlphaAnimation(0.0f, 1.0f)
                anim?.duration = 500
                anim?.startOffset = 20
                anim?.repeatMode = Animation.REVERSE
                anim?.repeatCount = Animation.INFINITE
                recordingImageView!!.startAnimation(anim)
                recordingCompleteTextView!!.text = context.getString(R.string.action_send)
            }
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Request audio focus.
     * Send a request to obtain the audio focus
     *
     * @param focusChangeListener the listener to be notified of audio focus changes
     * @param streamType          the main audio stream type affected by the focus request
     * @param audioFocusGain      the focus gain
     * @return true if AUDIOFOCUS_REQUEST_GRANTED otherwise false
     */
    private fun requestAudioFocus(focusChangeListener: AudioManager.OnAudioFocusChangeListener,
                                  streamType: Int, audioFocusGain: Int): Boolean {
        val r: Int = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mAudioManager.requestAudioFocus(AudioFocusRequest.Builder(audioFocusGain)
                    .setAudioAttributes(AudioAttributes.Builder().setLegacyStreamType(streamType).build())
                    .setOnAudioFocusChangeListener(focusChangeListener).build())
        } else mAudioManager.requestAudioFocus(focusChangeListener, streamType, audioFocusGain)
        return r == AudioManager.AUDIOFOCUS_REQUEST_GRANTED
    }

    /**
     * Stop the recording when the user desire to stop in the user interface
     *
     * @param isSend the is send
     */
    fun stopRecording(isSend: Boolean) {
        try {
            if (audioRecorder != null) audioRecorder!!.stopRecording()
            mediaState = Constants.COUNT_ZERO
            if (isSend) recordingCompleteTextView!!.text = context.getString(R.string.action_send)
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        } finally {
            dialogRecording!!.dismiss()
            mAudioManager.abandonAudioFocus(focusChangeListener)
        }
    }

    /**
     * Show recording dialog to the user so that can able to record the audio.
     */
    fun showRecordingDialog() {
        try {
            dialogRecording = Dialog(context)
            dialogRecording!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialogRecording!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialogRecording!!.setContentView(R.layout.dialog_audio_recording)
            dialogRecording!!.setCancelable(false)
            recordingTimerTextView = dialogRecording!!.findViewById(R.id.text_timer)
            recordingCompleteTextView = dialogRecording!!.findViewById(R.id.text_ok)
            recordingCompleteTextView?.setOnClickListener(onClickListener)
            recordingImageView = dialogRecording!!.findViewById(R.id.image_recording)
            dialogRecording!!.findViewById<View>(R.id.text_cancel).setOnClickListener(onClickListener)
            dialogRecording!!.show()
            mediaState = Constants.COUNT_ZERO
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    fun dismissRecordingDialog() {
        if (dialogRecording != null && audioRecorder != null) stopRecording(false)
        if (dialogRecording != null) dialogRecording!!.dismiss()
    }

    override fun onDurationUpdateListener(totalDuration: Int) {
        setFormattedTimeTextView(totalDuration, recordingTimerTextView!!)
    }

    override fun onMaxDurationReached() {
        if (audioRecorder != null) audioRecorder!!.stopRecording()
        onDurationUpdateListener(com.contusfly.utils.Constants.AUDIO_DURATION_LIMIT) //getString(com.contusfly.utils.Constants.AUDIO_LIMIT).toInt())
        recordingCompleteTextView!!.text = context.getString(R.string.action_send)
        recordingImageView!!.clearAnimation()
        CustomToast.show(context, String.format(context.getString(R.string.msg_maximum_audio_record),
                com.contusfly.utils.Constants.AUDIO_DURATION_LIMIT.toString())) //getString(com.contusfly.utils.Constants.AUDIO_LIMIT)))
    }

    fun toPauseMediaPlayer() {
        try {
            if (audioRecorder != null) {
                audioRecorder!!.stopRecording()
                recordingCompleteTextView!!.text = context.getString(R.string.action_send)
                if (anim != null) {
                    anim!!.cancel()
                    recordingImageView!!.setImageResource(R.drawable.onrecord)
                }
            }
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    init {
        focusChangeListener = AudioManager.OnAudioFocusChangeListener { focusChange: Int -> }
    }
}