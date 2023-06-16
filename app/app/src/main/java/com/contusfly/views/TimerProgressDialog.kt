package com.contusfly.views

import android.app.Activity
import android.widget.Toast
import com.contusfly.R
import java.util.*

/**
 * This class used to display the progress dialog for the default 5000 milli seconds for doing any
 * operation at that time.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class TimerProgressDialog : DoProgressDialog {
    /**
     * Activity of the user View.
     */
    private val activity: Activity

    /**
     * Duration for the timer
     */
    private val time: Long

    /**
     * Timer for the progress dialog delay.
     */
    private var mTimer: Timer? = null
    private var showToast = true

    /**
     * Instantiates a new do progress dialog.
     *
     * @param context Instance of the startupActivityContext
     */
    constructor(context: Activity) : super(context) {
        activity = context
        time = 5000
    }

    /**
     * Instantiates a new do progress dialog.
     *
     * @param context Instance of the startupActivityContext
     * @param time    Duration of the progress dialog
     */
    constructor(context: Activity, time: Long) : super(context) {
        activity = context
        this.time = time
    }

    constructor(context: Activity, time: Long, showToast: Boolean) : super(context) {
        activity = context
        this.time = time
        this.showToast = showToast
    }

    override fun showProgress() {
        super.showProgress()
        val lTask: TimerTask = object : TimerTask() {
            override fun run() {
                activity.runOnUiThread {
                    if (showToast) Toast.makeText(
                        context,
                        R.string.error_occurred_label,
                        Toast.LENGTH_SHORT
                    ).show()
                    dismiss()
                }
            }
        }
        mTimer = Timer(activity.javaClass.name)
        mTimer!!.schedule(lTask, time)
    }

    override fun dismiss() {
        if (!activity.isDestroyed) {
            if (mTimer != null) mTimer!!.cancel()
            super.dismiss()
        }
    }
}
