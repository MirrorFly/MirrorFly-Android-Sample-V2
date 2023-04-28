package com.contusfly.views

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.CheckBox
import android.widget.CompoundButton
import com.contus.call.CallConstants
import com.mirrorflysdk.flycall.webrtc.api.CallActionListener
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.R
import com.contusfly.call.groupcall.OnGoingCallPreviewActivity
import com.contusfly.chat.AndroidUtils
import com.contusfly.databinding.CommonAlertDialogBinding
import com.contusfly.runOnUiThread
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class CommonAlertDialog(context: Context?) {

    /**
     * CommonAlertDialog startupActivityContext
     */
    private var context: Context? = null

    /**
     * Instance of CommonDialogClosedListener
     */
    private var listener: CommonDialogClosedListener? = null

    /**
     * Instance of CommonTripleDialogClosedListener
     */
    private var commonTripleDialogClosedListener: CommonTripleDialogClosedListener? = null

    /**
     * Store the dialog action Delete or clear
     */
    var dialogAction: DialogAction? = null

   init {
       this.context = context
   }

    /**
     * Sets the on dialog close listener.
     *
     * @param listener the new on dialog close listener
     */
    fun setOnDialogCloseListener(listener: CommonDialogClosedListener?) {
        this.listener = listener
    }

    /**
     * Sets the on dialog close listener.
     *
     * @param listener the new on dialog close listener
     */
    fun setOnTripleDialogCloseListener(listener: CommonTripleDialogClosedListener?) {
        commonTripleDialogClosedListener = listener
    }

    /**
     * Returns {@see dialogAction}
     *
     * @return [.dialogAction]
     */
    @JvmName("getDialogAction1")
    fun getDialogAction(): DialogAction {
        return dialogAction!!
    }

    /**
     * Sets {@see dialogAction}
     *
     * @param dialogAction [.dialogAction]
     */
    @JvmName("setDialogAction1")
    fun setDialogAction(dialogAction: DialogAction) {
        this.dialogAction = dialogAction
    }

    /**
     * Show alert dialog.
     *
     * @param msg            the msg
     * @param positiveString the positive string
     * @param negativeString the negative string
     * @param dialogType     the dialog type
     */
    fun showAlertDialog(msg: String?, positiveString: String?, negativeString: String?,
                        dialogType: DIALOGTYPE, smartreply: Boolean, isCheckBoxShown: Boolean = false, dialogListener: CommonDialogClosedListener? = null) {
        val builder = AlertDialog.Builder(context, R.style.AdminBlockAlertDialogStyle)
        builder.setMessage(msg)
        if (isCheckBoxShown) builder.setView(createAndSetCheckBox())
        if (dialogType == DIALOGTYPE.DIALOG_DUAL) {
            builder.setNegativeButton(negativeString) { dialog: DialogInterface, which: Int ->
                dialog.dismiss()
                listener?.onDialogClosed(dialogType, false)
                dialogListener?.onDialogClosed(dialogType, false)
            }
        }
        builder.setPositiveButton(positiveString) { dialog: DialogInterface, which: Int ->
            listener?.onDialogClosed(dialogType, true)
            dialogListener?.onDialogClosed(dialogType, true)
            dialog.dismiss()
        }
        if (smartreply) builder.setCancelable(false)
        builder.create().show()
    }

    /**
     * Show alert dialog.
     *
     * @param msg            the msg
     * @param positiveString the positive string
     * @param negativeString the negative string
     * @param dialogType     the dialog type
     */
    fun showAlertDialogWithActionCallBack(
        msg: String?,
        positiveString: String?,
        negativeString: String?,
        dialogType: DIALOGTYPE,
        dialogAction: DialogAction,
        cancelable: Boolean = true,
        dismissListener: DialogCallbackListener?
    ) {
        val builder = AlertDialog.Builder(context, R.style.AlertDialogStyle)
        builder.setMessage(msg)
        if (dialogType == DIALOGTYPE.DIALOG_DUAL) {
            builder.setNegativeButton(negativeString) { dialog: DialogInterface, which: Int ->
                dialog.dismiss()
                dismissListener?.onDialogClosed(dialogAction, false)
            }
        }
        builder.setPositiveButton(positiveString) { dialog: DialogInterface, which: Int ->
            dialog.dismiss()
            dismissListener?.onDialogClosed(dialogAction, true)
        }
        builder.setCancelable(cancelable)
        builder.create().show()
    }

    /**
     * Shows list dialog.
     *
     * @param title     the title
     * @param listItems the list items
     */
    fun showListDialog(title: String, listItems: Array<String>): AlertDialog? {
        val builder = AlertDialog.Builder(context, R.style.AlertDialogStyle)
        if (!title.isEmpty()) builder.setTitle(title)
        builder.setItems(listItems) { dialog: DialogInterface, item: Int ->
            dialog.dismiss()
            if (listener != null) listener!!.listOptionSelected(item)
        }
        val dialog = builder.create()
        dialog.show()
        return dialog
    }

    /**
     * Displays a alert dialog to get the user confirmation
     * at the time of clearing the chat messages from the history.
     *
     * @param message         The alert message to be shown to the user.
     * @param positiveBtnText The text to display in the positive button.
     * @param negativeBtnText The text to display in the negative button.
     * @param neutralBtnText  The text to display in the neutral button.
     * @param dialogType      The type of the alert dialog whether to show the neutral button or not.
     */
    fun showClearChatDialog(message: String?, positiveBtnText: String?, negativeBtnText: String?,
                            neutralBtnText: String?, dialogType: DIALOGTYPE) {
        val builder = AlertDialog.Builder(context, R.style.AlertDialogStyle)
        builder.setMessage(message)
        builder.setPositiveButton(positiveBtnText) { dialog: DialogInterface, which: Int ->
            dialog.dismiss()
            if (commonTripleDialogClosedListener != null) commonTripleDialogClosedListener!!.onTripleOptionDialogClosed(dialogType, 0)
        }
        builder.setNegativeButton(negativeBtnText) { dialog: DialogInterface, which: Int -> dialog.dismiss() }
        if (dialogType == DIALOGTYPE.DIALOG_TRIPLE) {
            builder.setNeutralButton(neutralBtnText) { dialog: DialogInterface, which: Int ->
                dialog.dismiss()
                if (listener != null) commonTripleDialogClosedListener!!.onTripleOptionDialogClosed(dialogType, 2)
            }
        }
        val alertDialog = builder.create()
        alertDialog.setCancelable(true)
        alertDialog.setCanceledOnTouchOutside(true)
        alertDialog.show()
    }

    fun showAlertDialogWithTitle(activity: Activity, title: String, msg: String,
                                 positiveString: String, negativeString: String,
                                 dialogType: DIALOGTYPE, listener: CommonDialogClosedListener?) {
        val dialogBuilder = AlertDialog.Builder(context,  R.style.CustomAlertDialog)
        val inflater: LayoutInflater = activity.layoutInflater
        val dialogBinding = CommonAlertDialogBinding.inflate(inflater)
        dialogBinding.dialogTitle.text = title
        dialogBinding.dialogDescription.text = msg
        dialogBuilder.apply {
            setCancelable(true)
            setView(dialogBinding.root)
            setPositiveButton(positiveString) { dialog, _ ->
                dialog.dismiss()
                listener?.onDialogClosed(dialogType, true)
            }
            if (dialogType == DIALOGTYPE.DIALOG_DUAL) {
                setNegativeButton(negativeString) { dialog, _ ->
                    dialog.dismiss()
                    listener?.onDialogClosed(dialogType, false)
                }
            }
        }
        val alertDialog = dialogBuilder.create()
        alertDialog.show()
        adjustAlertDialogWidth(activity, alertDialog)
    }

    private fun adjustAlertDialogWidth(activity: Activity, alertDialog: AlertDialog) {
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(alertDialog.window!!.attributes)
        layoutParams.width = (AndroidUtils.getScreenWidth(activity) * 0.9).toInt()
        alertDialog.window!!.attributes = layoutParams
    }

    /**
     * Shows the alert dialog to confirm the delete action of the selected chat messages.
     *
     * @param msg            the msg
     * @param positiveString the positive string
     * @param negativeString the negative string
     * @param neutralString  the neutral string for recall
     * @param dialogType     the dialog type
     */
    fun showAlertDialogWithRecall(msg: String?, positiveString: String?, negativeString: String?,
                                  neutralString: String?, dialogType: DIALOGTYPE?, isCheckBoxShown:Boolean) {
        val builder = AlertDialog.Builder(context, R.style.AlertDialogStyle)
        builder.setMessage(msg)
        if (isCheckBoxShown) builder.setView(createAndSetCheckBox())
        builder.setNegativeButton(negativeString) { dialog: DialogInterface, which: Int ->
            dialog.dismiss()
            if (commonTripleDialogClosedListener != null) commonTripleDialogClosedListener!!.onTripleOptionDialogClosed(dialogType, 0)
        }
        builder.setPositiveButton(positiveString) { dialog: DialogInterface, which: Int ->
            dialog.dismiss()
            if (commonTripleDialogClosedListener != null) commonTripleDialogClosedListener!!.onTripleOptionDialogClosed(dialogType, 1)
        }
        builder.setNeutralButton(neutralString) { dialog: DialogInterface, which: Int ->
            dialog.dismiss()
            if (listener != null) commonTripleDialogClosedListener!!.onTripleOptionDialogClosed(dialogType, 2)
        }
        builder.create().show()
    }

    fun showCallSwitchAlertDialog(callLink: String, positiveString: String?, negativeString: String?,
                                  dialogType: DIALOGTYPE, isCheckBoxShown: Boolean = false) {
        val builder = AlertDialog.Builder(context, R.style.AlertDialogStyle)
        builder.setTitle(context!!.getString(R.string.already_in_call))
        builder.setMessage(context!!.getString(R.string.already_in_call_msg))
        if (isCheckBoxShown) builder.setView(createAndSetCheckBox())
        if (dialogType == DIALOGTYPE.DIALOG_DUAL) {
            builder.setNegativeButton(negativeString) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
                listener?.onDialogClosed(dialogType, false)
            }
        }
        builder.setPositiveButton(positiveString) { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
            listener?.onDialogClosed(dialogType, true)
        }
        builder.create().show()
    }

    fun showCallSwitchDialog(callLink: String, positiveString: String?, negativeString: String?,
                             dialogType: DIALOGTYPE, isCheckBoxShown: Boolean = false) {
        val builder = AlertDialog.Builder(context, R.style.AlertDialogStyle)
        builder.setTitle(context!!.getString(R.string.already_in_call))
        builder.setMessage(context!!.getString(R.string.already_in_call_msg))
        if (isCheckBoxShown) builder.setView(createAndSetCheckBox())
        if (dialogType == DIALOGTYPE.DIALOG_DUAL) {
            builder.setNegativeButton(negativeString) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
            }
        }
        builder.setPositiveButton(positiveString) { dialog: DialogInterface, _: Int ->
            //Current call disconnect
            CallManager.disconnectCall(object : CallActionListener {
                override fun onResponse(isSuccess: Boolean, message: String) {
                    runOnUiThread {
                        //New Call preview page
                        context!!.startActivity(
                            Intent(context, OnGoingCallPreviewActivity::class.java).putExtra(
                                CallConstants.CALL_LINK, callLink)
                        )
                        dialog.dismiss()
                    }
                }
            })
        }
        builder.create().show()
    }

    /**
     * Show alert dialog.
     *
     * @param title          the title
     * @param msg            the msg
     * @param positiveString the positive string
     * @param negativeString the negative string
     * @param dialogType     the dialog type
     */
    fun showAlertDialog(title: String?, msg: String?, positiveString: String?, negativeString: String?,
                        dialogType: DIALOGTYPE) {
        val builder = AlertDialog.Builder(context, R.style.ReportUserAlertDialogStyle)
        builder.setTitle(title)
        builder.setMessage(msg)
        if (dialogType == DIALOGTYPE.DIALOG_DUAL) {
            builder.setNegativeButton(negativeString) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
                listener?.onDialogClosed(dialogType, false)
            }
        }
        builder.setPositiveButton(positiveString) { dialog: DialogInterface, _: Int ->
            listener?.onDialogClosed(dialogType, true)
            dialog.dismiss()
        }
        builder.create().show()
    }


    private fun createAndSetCheckBox(): View? {
        val checkBoxView = View.inflate(context, R.layout.checkbox, null)
        val checkBox = checkBoxView.findViewById<CheckBox>(R.id.checkbox)
        checkBox.isChecked = SharedPreferenceManager.getBoolean(Constants.DELETE_MEDIA_FROM_PHONE)
        checkBox.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean -> SharedPreferenceManager.setBoolean(Constants.DELETE_MEDIA_FROM_PHONE, isChecked) }
        checkBox.setText(R.string.delete_media_from_gallery)
        return checkBoxView
    }

    fun showAlertDialogWithChatTagRemove(title: String?, msg: String?, positiveString: String?, negativeString: String?,
                                         dialogType: DIALOGTYPE) {
        val builder = AlertDialog.Builder(context, R.style.ChatTagRemoveAlertDialogStyle)
        builder.setTitle(title)
        builder.setMessage(msg)
        if (dialogType == DIALOGTYPE.DIALOG_DUAL) {
            builder.setNegativeButton(negativeString) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
                listener?.onDialogClosed(dialogType, false)
            }
        }
        builder.setPositiveButton(positiveString) { dialog: DialogInterface, _: Int ->
            listener?.onDialogClosed(dialogType, true)
            dialog.dismiss()
        }
        builder.create().show()
    }

    /**
     * The Enum DIALOGTYPE.
     */
    enum class DIALOGTYPE {
        /**
         * The dialog single.
         */
        DIALOG_SINGLE,

        /**
         * The dialog dual.
         */
        DIALOG_DUAL,

        /**
         * The dialog dual.
         */
        DIALOG_TRIPLE
    }

    /**
     * Actions of the dialog
     */
    enum class DialogAction {
        CLEAR_CONVERSATION, DELETE_CHAT, CAMERA, GALLERY, STATUS_BUSY, UNBLOCK, BLOCK, SMART_REPLY_UNBLOCK, SMART_REPLY_BUSY,
        SET_PIN_ALERT, INVITE, STATUS_BUSY_KEYBOARD, STATUS_BUSY_EMOJI,FORWARD_STATUS_BUSY, SAFE_CHAT_ENABLED,
        SAFE_CHAT_ENABLE_APP_LOCK, REPORT_MESSAGES
    }

    /**
     * Called in CommonDialog for listing the details
     */
    interface CommonDialogClosedListener {
        /**
         * On dialog closed.
         *
         * @param dialogType the dialog type
         * @param isSuccess  the is success
         */
        fun onDialogClosed(dialogType: DIALOGTYPE?, isSuccess: Boolean)

        /**
         * List option selected.
         *
         * @param position the position
         */
        fun listOptionSelected(position: Int)
    }

    /**
     * Called in CommonDialog for listing the details
     */
    interface CommonTripleDialogClosedListener {
        /**
         * On triple option dialog closed.
         *
         * @param dialogType the dialog type
         * @param position   Position of click
         */
        fun onTripleOptionDialogClosed(dialogType: DIALOGTYPE?, position: Int)
    }

    /**
     * Called in CommonDialog for listing is positive or negative response with action used
     */
    interface DialogCallbackListener {
        /**
         * On triple option dialog closed.
         *
         * @param dialogAction the dialog type
         * @param isSuccess true for positive button click and false for negative button click
         */
        fun onDialogClosed(dialogAction: DialogAction, isSuccess: Boolean)
    }
}