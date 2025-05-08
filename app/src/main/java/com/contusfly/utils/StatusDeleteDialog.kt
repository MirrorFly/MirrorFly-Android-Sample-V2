package com.contusfly.utils

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class StatusDeleteDialog {

    /**
     * The startupActivityContext of the calling parent.
     */
    private var context: Context? = null

    /**
     * Listener used to dispatch user events.
     */
    private final var updateAdapterListener: UpdateAdapterListener? = null

    /**
     * The default instance of the class.
     *
     * @param context The startupActivityContext of the calling parent.
     */
    constructor(context: Context) {
        this.context = context
    }

    /**
     * Alert to show the user while choose status delete option
     */
    fun showDeleteStatusAlert() {
        try {
            val mBuilder = AlertDialog.Builder(context!!, R.style.AlertDialogStyle)
            mBuilder.setMessage(context!!.getString(R.string.msg_status_delete))
            mBuilder.setPositiveButton(context!!.getString(R.string.yes_label),
                    DialogInterface.OnClickListener { dialog: DialogInterface, _: Int ->
                        dialog.dismiss()
                        if (updateAdapterListener != null) {
                            updateAdapterListener!!.onNotifyAdapter()
                        }
                    })
            mBuilder.setNegativeButton(context!!.getString(R.string.no_label),
                    DialogInterface.OnClickListener { dialog: DialogInterface, _: Int -> dialog.dismiss() })
            val dialog = mBuilder.create()
            dialog.setCancelable(false)
            dialog.show()
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    fun setUpdateAdapterListener(updateAdapterListener: UpdateAdapterListener) {
        this.updateAdapterListener = updateAdapterListener
    }

    /**
     * Interface definition for a callback to be invoked when user wants to delete the status.
     */
    fun interface UpdateAdapterListener {
        /**
         * The callback method to notify the adapter.
         */
        fun onNotifyAdapter()
    }
}