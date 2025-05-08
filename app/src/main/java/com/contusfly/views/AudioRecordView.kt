package com.contusfly.views

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.activities.parent.ChatParent
import com.contusfly.utils.AudioRecorder
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.views.CustomToast
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

class AudioRecordView(val chatParent: ChatParent) : AudioRecorder.AudioRecordingListener {
    enum class UserBehaviour {
        CANCELING, LOCKING, NONE
    }

    enum class RecordingBehaviour {
        CANCELED, PAUSED, LOCK_DONE, RELEASED
    }

    interface RecordingListener {
        fun onRecordingStarted()
        fun onRecordingLocked()
        fun onRecordingCompleted()
        fun onRecordingCanceled()
    }

    private var isDeleting = false
    private var stopTrackingAction = false
    private var canRecordVoice = false
    private var isRecordingStarted = false
    private var isBlink = true
    var isLocked = false
    private lateinit var handler: Handler

    private var screenWidth = 0
    private val directionOffset = 0f
    private  var cancelOffset:Float = 0f
    private  var cancelIconOffset:Float = 0f
    private  var lockOffset:Float = 0f
    private var lastX = 0f
    private  var lastY:Float = 0f
    private var firstX = 0f
    private  var firstY:Float = 0f

    var mediaState = 0
        private set

    private var audioTotalTime = 0
    private var timerTask: TimerTask? = null
    private lateinit var audioTimer: Timer
    private lateinit var timeFormatter: SimpleDateFormat

    private var isLayoutDirectionRightToLeft = false

    private var userBehaviour = UserBehaviour.NONE

    private var recordingListener: RecordingListener? = null

    /**
     * The audio recorder to record the audio in the chat view
     */
    private var audioRecorder: AudioRecorder? = null

    private var isAudioRecordingStopped = true

    /**
     * Media path of the recording file
     */
    var mediaPath: String? = null
        private set

    private val mAudioManager = chatParent.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    private lateinit var focusChangeListener: AudioManager.OnAudioFocusChangeListener

    private var isPausedByHiddenAction = false

    fun setRecordingListener(recordingListener: RecordingListener?) {
        this.recordingListener = recordingListener
    }

    fun initViews() {
        timeFormatter = SimpleDateFormat("m:ss", Locale.getDefault())
        handler = Handler(Looper.getMainLooper())
        screenWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
        setRecordAudioListener()

        focusChangeListener = AudioManager.OnAudioFocusChangeListener { }
    }

    private fun setRecordAudioListener() {

        chatParent.voiceAttachment.setOnClickListener {
            chatParent.chatMessageEditText.text?.clear()
            chatParent.hideKeyboard()
            Handler(Looper.getMainLooper()).postDelayed(
                {startRecordClickListener()},100
            )
        }

        chatParent.imageViewAudio.setOnClickListener {
            if (!isLocked) {
                locked()
                chatParent.imageViewAudio.translationY = 0f
            }
        }

        chatParent.textAudioSlideToCancel.setOnClickListener {
            //No Implementation Needed
        }

        chatParent.textAudioSlideToCancel.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    LogMessage.e("RECORDING","START_RECORD")
                    onStartRecording(motionEvent)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    LogMessage.e("RECORDING","STOP_MOVING")
                    onStopMoving()
                    visibleGoneRecordTimerDeleteIcon(false)
                }
                MotionEvent.ACTION_MOVE -> {
                    LogMessage.e("RECORDING","START_MOVING---$stopTrackingAction")
                    if (stopTrackingAction) {
                        true
                    }
                    onStartMoving(motionEvent)
                }
            }
            false
        }

        chatParent.textAudioRecordCancel.setOnClickListener {
            cancelRecording()
        }
    }

    fun getAudioRecordingStatus() : Boolean {
        return isRecordingStarted
    }

    fun startRecordClickListener() {
        if (!isRecordingStarted)
            onClickStartRecording()
    }

    private fun onStopMoving() {
        if (!canRecordVoice)
            return
        chatParent.textAudioSlideToCancel.translationX = 0f
    }

    private fun onClickStartRecording() {
        canRecordVoice = chatParent.attachRecordVoice()
        if (!canRecordVoice)
            return
        startRecord()
    }

    private fun onStartRecording(motionEvent: MotionEvent) {
        cancelOffset = (screenWidth / 3).toFloat()
        cancelIconOffset = (screenWidth / 4.5).toFloat()
        lockOffset = (screenWidth / 5).toFloat()
        if (firstX == 0f) {
            firstX = motionEvent.rawX
        }
        if (firstY == 0f) {
            firstY = motionEvent.rawY
        }
    }

    private fun onStartMoving(motionEvent: MotionEvent) {
        if (!canRecordVoice)
            return
        val direction: UserBehaviour = getDirection(motionEvent)
        LogMessage.e("RECORDING","$direction")
        if (direction == UserBehaviour.CANCELING) {
            if (userBehaviour == UserBehaviour.NONE || motionEvent.rawY + chatParent.voiceAttachment.width / 2 > firstY) {
                userBehaviour = UserBehaviour.CANCELING
            }
            if (userBehaviour == UserBehaviour.CANCELING) {
                translateX(-(firstX - motionEvent.rawX))
            }
        }
        lastX = motionEvent.rawX
        lastY = motionEvent.rawY
    }

    private fun getDirection(motionEvent: MotionEvent): UserBehaviour {
        var direction: UserBehaviour = UserBehaviour.NONE
        val motionX: Float = abs(firstX - motionEvent.rawX)
        val motionY: Float = abs(firstY - motionEvent.rawY)
        when {
            if (isLayoutDirectionRightToLeft) motionX > directionOffset && lastX > firstX && lastY > firstY else motionX > directionOffset && lastX < firstX && lastY < firstY -> {
                if (canCancelRecording(motionX, motionY)) {
                    direction = UserBehaviour.CANCELING
                } else if (motionY > motionX && lastY < firstY) {
                    direction = UserBehaviour.LOCKING
                }
            }
            canCancelRecording(motionX, motionY) && motionX > directionOffset && motionX > directionOffset -> {
                direction = UserBehaviour.CANCELING
            }
            motionY > motionX && motionY > directionOffset && lastY < firstY -> {
                direction = UserBehaviour.LOCKING
            }
        }

        return direction
    }

    private fun canCancelRecording(motionX: Float, motionY: Float) = if (isLayoutDirectionRightToLeft) motionX > motionY && lastX > firstX else motionX > motionY && lastX < firstX

    private fun translateX(x: Float) {
        if (if (isLayoutDirectionRightToLeft) x > cancelOffset else x < -cancelOffset) {
            LogMessage.e("RECORDING","CANCELLED")
            canceled()
            chatParent.imageViewAudio.translationX = 0f
            chatParent.textAudioSlideToCancel.translationX = 0f
            return
        }
        if (if (isLayoutDirectionRightToLeft) x > cancelIconOffset else x < -cancelIconOffset) {
            LogMessage.e("RECORDING","SWIPE_VISIBLE_DELETE")
            visibleGoneRecordTimerDeleteIcon(true)
        } else {
            LogMessage.e("RECORDING","SWIPE_GONE_DELETE")
            visibleGoneRecordTimerDeleteIcon(false)
        }
        chatParent.textAudioSlideToCancel.translationX = x
        chatParent.imageViewAudio.translationY = 0f
    }

    private fun visibleGoneRecordTimerDeleteIcon(isDeleteIconVisible:Boolean){
        if(isDeleteIconVisible){
            chatParent.imageAudioRecordDelete.visibility = View.VISIBLE
            chatParent.textAudioRecordTimer.visibility = View.GONE
        } else {
            chatParent.imageAudioRecordDelete.visibility = View.GONE

            if(chatParent.layoutViewAudio.visibility == View.VISIBLE)
            chatParent.textAudioRecordTimer.visibility = View.VISIBLE
        }
    }

    private fun hideViewForRecording(){
        LogMessage.d(TAG,"#record hideViewForRecording  ")
        chatParent.smiley.visibility = View.GONE
        chatParent.imgSend.visibility = View.GONE
        chatParent.chatMessageEditText.visibility = View.GONE
        chatParent.attachment.visibility = View.GONE
        chatParent.voiceAttachment.visibility = View.GONE
        chatParent.layoutViewAudio.visibility = View.VISIBLE
        chatParent.viewAudioRecordSpace.visibility = View.VISIBLE
    }

    private fun startRecord() {
        isRecordingStarted = true
        recordingListener?.onRecordingStarted()
        stopTrackingAction = false
        hideViewForRecording()
        chatParent.textAudioRecordTimer.visibility = View.VISIBLE
        chatParent.textAudioSlideToCancel.visibility = View.VISIBLE
        if (!::audioTimer.isInitialized) {
            audioTimer = Timer()
            timeFormatter.timeZone = TimeZone.getTimeZone("UTC")
        }
        timerTask = object : TimerTask() {
            override fun run() {
                handler.post {
                    chatParent.textAudioRecordTimer.text = timeFormatter.format(Date(audioTotalTime * 1000L))
                    audioTotalTime++
                    isBlink = !isBlink
                    if (isBlink)
                        chatParent.imageViewAudio.setImageResource(R.drawable.ic_audio_recording_icon)
                    else
                        chatParent.imageViewAudio.setImageResource(R.drawable.ic_audio_record_icon)
                }
            }
        }
        audioTotalTime = 0
        audioTimer.schedule(timerTask, 0, 1000)

        try {
            if (requestAudioFocus(focusChangeListener, AudioManager.USE_DEFAULT_STREAM_TYPE,
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE)) {
                audioRecorder = AudioRecorder(chatParent, this)
                mediaPath = audioRecorder!!.startRecording()
                isAudioRecordingStopped = false
                mediaState = com.mirrorflysdk.flycommons.Constants.COUNT_ONE
            }
        } catch (e: Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(com.mirrorflysdk.flycommons.Constants.TAG, e)
        }
    }

    private fun stopRecording(recordingBehaviour: RecordingBehaviour) {
        stopTrackingAction = true
        firstX = 0f
        firstY = 0f
        lastX = 0f
        lastY = 0f
        userBehaviour = UserBehaviour.NONE
        chatParent.textAudioSlideToCancel.translationX = 0f
        chatParent.textAudioSlideToCancel.visibility = View.GONE
        if (isLocked) {
            return
        }
        when (recordingBehaviour) {
            RecordingBehaviour.PAUSED -> {
                isRecordingStarted = false
                recordingListener?.onRecordingLocked()
                timerTask?.cancel()
                pauseRecording()
            }
            RecordingBehaviour.CANCELED -> {
                isRecordingStarted = false
                chatParent.viewAudioRecordSpace.visibility = View.GONE
                chatParent.textAudioRecordTimer.visibility = View.GONE
                chatParent.textAudioSlideToCancel.visibility = View.GONE
                chatParent.textAudioRecordCancel.visibility = View.GONE
                chatParent.imageAudioRecord.visibility = View.GONE
                chatParent.smiley.visibility = View.VISIBLE
                chatParent.chatMessageEditText.visibility = View.VISIBLE
                chatParent.attachment.visibility = View.VISIBLE
                chatParent.voiceAttachment.visibility = View.VISIBLE
                chatParent.layoutViewAudio.visibility = View.GONE
                timerTask?.cancel()
                delete()
                stopRecording()
                recordingListener?.onRecordingCanceled()
            }
            RecordingBehaviour.RELEASED, RecordingBehaviour.LOCK_DONE -> {
                isRecordingStarted = false
                chatParent.viewAudioRecordSpace.visibility = View.GONE
                chatParent.textAudioRecordTimer.visibility = View.GONE
                chatParent.textAudioSlideToCancel.visibility = View.GONE
                chatParent.textAudioRecordCancel.visibility = View.GONE
                chatParent.imageAudioRecord.visibility = View.GONE
                chatParent.smiley.visibility = View.VISIBLE
                chatParent.chatMessageEditText.visibility = View.VISIBLE
                chatParent.attachment.visibility = View.VISIBLE
                chatParent.voiceAttachment.visibility = View.VISIBLE
                chatParent.layoutViewAudio.visibility = View.GONE
                delete()
                timerTask?.cancel()
                recordingListener?.onRecordingCompleted()
                stopRecording()
            }
        }
    }

    /**
     * Stop the recording when the user desire to stop in the user interface
     */
    fun stopRecording() {
        try {
            if (audioRecorder != null && !isAudioRecordingStopped) {
                isAudioRecordingStopped = true
                audioRecorder!!.stopRecording()
            }
            mediaState = com.mirrorflysdk.flycommons.Constants.COUNT_ZERO
        } catch (e: Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(com.mirrorflysdk.flycommons.Constants.TAG, e)
        } finally {
            mAudioManager.abandonAudioFocus(focusChangeListener)
        }
    }

    /**
     * Pause the recording when the user desire to stop in the user interface
     */
    private fun pauseRecording() {
        try {
            if (audioRecorder != null && !isAudioRecordingStopped) {
                isAudioRecordingStopped = true
                audioRecorder!!.stopRecording()
            }
        } catch (e: Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(com.mirrorflysdk.flycommons.Constants.TAG, e)
        } finally {
            mAudioManager.abandonAudioFocus(focusChangeListener)
        }
    }

    private fun showViewsToSend(){
        chatParent.textAudioRecordCancel.visibility = View.VISIBLE
        chatParent.textAudioSlideToCancel.visibility = View.GONE
        chatParent.imageAudioRecord.visibility = View.VISIBLE
        chatParent.layoutViewAudio.visibility = View.GONE
        chatParent.imgSend.visibility = View.VISIBLE
        chatParent.imgSend.setImageResource(R.drawable.ic_send_active)
        chatParent.imgSend.isEnabled = true
    }

    private fun locked() {
        LogMessage.d(TAG,"#record locked: ")
        stopTrackingAction = true
        showViewsToSend()
        stopRecording(RecordingBehaviour.PAUSED)
        isLocked = true
    }

    private fun canceled() {
        stopTrackingAction = true
        stopRecording(RecordingBehaviour.CANCELED)
    }

    private fun delete() {
        chatParent.imageAudioRecordDelete.visibility = View.GONE
        isDeleting = false
        chatParent.imageViewAudio.isEnabled = true
    }

    fun sendRecording(){
        isLocked = false
        stopRecording(RecordingBehaviour.LOCK_DONE)
        isPausedByHiddenAction = false
    }

    fun pauseOngoingRecording(activityHidden:Boolean = false):Boolean{
        if (!isLocked && !isAudioRecordingStopped) {
            locked()
            chatParent.imageViewAudio.translationY = 0f
            if(activityHidden)
                isPausedByHiddenAction = true
            return  true
        }
        if(isLocked && isAudioRecordingStopped){
            //case when user does not send the file first time and goes to background and comes online again
            return  true
        }
        return false
    }

    fun showPausedOngoingRecording(){
        LogMessage.d(TAG,"#record showPausedOngoingRecording isPausedByHiddenAction:$isPausedByHiddenAction isAudioRecordingStopped:$isAudioRecordingStopped")
        LogMessage.d(TAG,"#record showPausedOngoingRecording isLocked:$isLocked ")
        if(isPausedByHiddenAction && isAudioRecordingStopped) {
            LogMessage.d(TAG, "#record show below views ")
            locked()
        }
    }

    fun cancelRecording(){
        isLocked = false
        stopRecording(RecordingBehaviour.CANCELED)
        isPausedByHiddenAction = false
    }

    fun toPauseMediaPlayer() {
        try {
            if (audioRecorder != null && !isAudioRecordingStopped) {
                isAudioRecordingStopped = true
                audioRecorder!!.stopRecording()
            }
        } catch (e: Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(com.mirrorflysdk.flycommons.Constants.TAG, e)
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
            mAudioManager.requestAudioFocus(
                AudioFocusRequest.Builder(audioFocusGain)
                    .setAudioAttributes(AudioAttributes.Builder().setLegacyStreamType(streamType).build())
                    .setOnAudioFocusChangeListener(focusChangeListener).build())
        } else mAudioManager.requestAudioFocus(focusChangeListener, streamType, audioFocusGain)
        return r == AudioManager.AUDIOFOCUS_REQUEST_GRANTED
    }

    override fun onDurationUpdateListener(totalDuration: Int) {
        //No Implementation needed
    }

    override fun onMaxDurationReached() {
        if (audioRecorder != null && !isAudioRecordingStopped) {
            audioRecorder!!.stopRecording()
        }
        chatParent.textAudioRecordTimer.text = timeFormatter.format(Date(Constants.AUDIO_DURATION_LIMIT * 1000L))
        onDurationUpdateListener(Constants.AUDIO_DURATION_LIMIT)
        CustomToast.show(chatParent, String.format(chatParent.getString(R.string.msg_maximum_audio_record),
            Constants.AUDIO_DURATION_LIMIT.toString()))
        pauseOngoingRecording()
    }
}