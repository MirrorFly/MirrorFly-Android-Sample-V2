package com.contusfly.utils

import android.app.Activity
import android.media.MediaRecorder
import android.os.Handler
import android.os.Looper
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * This class is used to record the audio.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
class AudioRecorder(private val activity: Activity, private val audioRecordingListener: AudioRecordingListener?) : MediaRecorder.OnInfoListener {
    /**
     * The media recorder to record the audio in the chat view
     */
    private var mediaRecorder: MediaRecorder? = null

    /**
     * The audio handler to record the audio in the background
     */
    private var mediaHandler: Handler? = null

    /**
     * The calculate the elapsed duration after audio recorder is started
     */
    private var recordingStartTimeInMillis: Long = 0

    /**
     * The recorder to record the audio into the chat view to the receiver
     */
    private val recorder: ThreadLocal<Runnable> = object : ThreadLocal<Runnable>() {
        override fun initialValue(): Runnable {
            return Runnable {
                activity.runOnUiThread {
                    mediaHandler!!.postDelayed(this.get()!!, 1000)
                    if (audioRecordingListener != null) {
                        val totalDuration = (System.currentTimeMillis() - recordingStartTimeInMillis).toInt() / 1000
                        audioRecordingListener.onDurationUpdateListener(totalDuration)
                    }
                }
            }
        }
    }

    /**
     * When user clicked Start recording in the view we have to call this method.
     *
     * @return string Recorded audio file path.
     * @throws IOException throws I/O exception if occurred.
     */
    @Throws(IOException::class)
    fun startRecording(): String {
        mediaRecorder = MediaRecorder()
        mediaRecorder!!.setAudioSource(MediaRecorder.AudioSource.MIC)
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val path = "Audio_$timeStamp"
        mediaRecorder!!.setAudioSamplingRate(44100)
        mediaRecorder!!.setAudioEncodingBitRate(96000)
        val audioDuration = Constants.AUDIO_DURATION_LIMIT //getString(Constants.AUDIO_LIMIT).toInt()
        // MediaRecorder - used to record audio
        // MediaMetaDataRetriever - used to retrieve media file information.
        // both are default Android API. if we set max duration limit as 60s, MediaRecorder records a max value of 59432 ms
        // Hence, add + 1 to record upto 1 min.
        mediaRecorder!!.setMaxDuration(audioDuration * 1000)
        mediaRecorder!!.setOnInfoListener(this)
        mediaRecorder!!.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS)
        mediaRecorder!!.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        val audioFile = File.createTempFile(path, ".aac", activity.externalCacheDir)
        audioFile.parentFile?.mkdirs()
        mediaRecorder!!.setOutputFile(audioFile.absolutePath)
        mediaHandler = Handler(Looper.getMainLooper())
        recordingStartTimeInMillis = System.currentTimeMillis()
        mediaRecorder!!.prepare()
        mediaRecorder!!.start()
        mediaHandler!!.post(recorder.get()!!)
        return audioFile.absolutePath
    }

    /**
     * Stop the recording when the user desire to stop in the user interface
     */
    fun stopRecording() {
        try {
            if (mediaHandler != null && recorder.get() != null) mediaHandler!!.removeCallbacks(recorder.get()!!)
            if (mediaRecorder != null) mediaRecorder!!.stop()
        } catch (e: RuntimeException){
            e.printStackTrace()
        }
    }

    override fun onInfo(mr: MediaRecorder, what: Int, extra: Int) {
        if (what == MediaRecorder.MEDIA_RECORDER_INFO_MAX_DURATION_REACHED && audioRecordingListener != null) audioRecordingListener.onMaxDurationReached()
    }

    /**
     * Listener to catch the audio recording events like duration update and stop recording
     */
    interface AudioRecordingListener {
        /**
         * This method will called when the total duration of the recording has changed
         *
         * @param totalDuration total duration of the recording
         */
        fun onDurationUpdateListener(totalDuration: Int)

        /**
         * This method will called when the audio recording duration reaches max
         * duration limit
         */
        fun onMaxDurationReached()
    }
}