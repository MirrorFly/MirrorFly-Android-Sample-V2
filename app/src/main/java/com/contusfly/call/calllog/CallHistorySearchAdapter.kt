package com.contusfly.call.calllog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.emoji.widget.EmojiAppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.contus.call.CallConstants.CALL_UI
import com.contusfly.*
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.CallMode
import com.mirrorflysdk.flycall.webrtc.CallState
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.call.database.model.CallLog
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.utils.AppConstants
import com.contusfly.utils.Constants
import com.contusfly.utils.EmojiUtils
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.views.CircularImageView
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.utils.ChatTimeFormatter
import com.mirrorflysdk.utils.CommonUtils
import com.mirrorflysdk.utils.Utils
import java.util.*

class CallHistorySearchAdapter(val context: Context, private val mCallLogsList: List<CallLog>, private val selectedCallLogs: ArrayList<String>, private var listener: CallHistoryAdapter.OnItemClickListener)
    : RecyclerView.Adapter<CallHistorySearchAdapter.CallHistorySearchViewHolder>() {

    override fun onViewRecycled(holder: CallHistorySearchViewHolder) {
        super.onViewRecycled(holder)
        Log.d("CallHistoryAdapter", holder.txtChatPersonName.text.toString())
    }

    private var searchKey = Constants.EMPTY_STRING

    fun setSearchKey(key: String) {
        this.searchKey = key
    }

    override fun getItemCount(): Int = mCallLogsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallHistorySearchViewHolder {
        return CallHistorySearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_call_logs, parent, false))
    }

    override fun onBindViewHolder(holder: CallHistorySearchViewHolder, position: Int) {
        val callLog = mCallLogsList[position]
        if (callLog.callTime != null)
            holder.txtCallTime.text = ChatTimeFormatter.getCallTime(context, callLog.callTime!!)
        holder.txtCallDurationTime.text = ChatTimeFormatter.getCallDurationTime(callLog.startTime!!, callLog.endTime!!)

        setUserView(holder, position)
        setCallType(holder, callLog)
        setCallStatusIcon(holder, callLog)
        updateSelectedItem(holder.itemView, selectedCallLogs.contains(callLog.roomId))
        holder.imageViewCallIcon.setOnClickListener(1000) {
            if (CallUtils.getCallLogUserJidList(callLog.fromUser, callLog.userList, false).isNotEmpty())
                listener.onItemClick(holder.imageViewCallIcon, mCallLogsList.indexOf(callLog))
        }
    }

    override fun onBindViewHolder(holder: CallHistorySearchViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty())
            onBindViewHolder(holder, position)
        else {
            val bundle = payloads[0] as Bundle
            handlePayloads(bundle, holder, position)
        }
    }

    private fun handlePayloads(bundle: Bundle, holder: CallHistorySearchViewHolder, position: Int) {
        for (key in bundle.keySet()) {
            when (key) {
                AppConstants.NOTIFY_PROFILE_ICON -> {
                    setUserView(holder, position)
                }
                AppConstants.NOTIFY_SELECTION -> {
                    Log.e(TAG, "handlePayloads: " + bundle.getBoolean(AppConstants.NOTIFY_IS_SELECTED))
                    updateSelectedItem(holder.itemView, bundle.getBoolean(AppConstants.NOTIFY_IS_SELECTED))
                }
                else -> {
                    LogMessage.e("ContactAdapter", "$CALL_UI Do Nothing")
                }
            }
        }
    }

    /**
     * Selected view when long press it
     *
     * @param view       Instance of the view
     * @param isSelected true if item is selected
     */
    private fun updateSelectedItem(view: View, isSelected: Boolean) {
        if (isSelected)
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.color_transparent_bg))
        else
            view.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
    }


    /**
     * This method is getting the caller name and profile picture
     *
     * @param holder viewHolder instance
     * @param position Item Position
     */
    private fun setUserView(holder: CallHistorySearchViewHolder, position: Int) {
        val callLog = mCallLogsList[position]
        if (mCallLogsList[position].callMode == CallMode.ONE_TO_ONE) {
            var endUserJids = if (callLog.callState == CallState.INCOMING_CALL
                    || callLog.callState == CallState.MISSED_CALL) callLog.fromUser else callLog.toUser
            if (!endUserJids!!.contains("@"))
                endUserJids = CommonUtils.getJidFromUser(endUserJids)
            val profileDetails = ProfileDetailsUtils.getProfileDetails(endUserJids!!)
            if (profileDetails != null) {
                profileIcon(holder, profileDetails)
            } else {
                val number = Utils.getFormattedPhoneNumber(endUserJids)
                holder.txtChatPersonName.text = number
                holder.imgRoster.addImage(arrayListOf(endUserJids))
            }
        } else {
            profileIconForManyUsers(holder, position)
        }
    }

    private fun profileIconForManyUsers(holder: CallHistorySearchViewHolder, position: Int) {
        val callLog = mCallLogsList[position]
        if (!callLog.groupId.isNullOrEmpty()) {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(callLog.groupId!!)
            if (profileDetails != null) {
                profileIcon(holder, profileDetails)
            } else {
                holder.imgRoster.addImage(arrayListOf(callLog.groupId!!))
                holder.txtChatPersonName.text = ProfileDetailsUtils.getDisplayName(callLog.groupId!!)
            }
        } else {
            holder.txtChatPersonName.text = CallUtils.getCallLogUserNames(callLog.fromUser, callLog.userList)
            holder.imgRoster.addImage(CallUtils.getCallLogUserJidList(callLog.fromUser, callLog.userList) as ArrayList<String>)
        }
        holder.emailContactIcon.gone()
    }


    private fun profileIcon(holder: CallHistorySearchViewHolder, profileDetails: ProfileDetails) {
        val txtChatName: String = profileDetails.getDisplayName()
        holder.imgRoster.addImage(arrayListOf(profileDetails.jid))
        if (searchKey.isNotEmpty()) {
            Log.d(TAG, "highlightMessageContent:txtChatName $txtChatName ")
            val highlightMessageContent = txtChatName.toLowerCase(Locale.getDefault())
            Log.d(TAG, "highlightMessageContent:highlightMessageContent $highlightMessageContent ")
            val startIndex = highlightMessageContent.toLowerCase(Locale.getDefault())
                    .indexOf(searchKey.toLowerCase(Locale.getDefault()))
            EmojiUtils.setEmojiTextAndHighLightSearchText(holder.txtChatPersonName, txtChatName,
                    startIndex, startIndex + searchKey.length)
            Log.d(TAG, "highlightMessageContent: ${holder.txtChatPersonName.text}")
        } else {
            Log.d(TAG, "highlightMessageContent: search empty${txtChatName} ")
            holder.txtChatPersonName.text = txtChatName
        }
    }

    // Displays icon whether the call is audio or video
    private fun setCallType(holder: CallHistorySearchViewHolder, callLogs: CallLog) {
        if (callLogs.callType == CallType.AUDIO_CALL)
            holder.imageViewCallIcon.setImageResource(R.drawable.ic_call_log_voice_call)
        else if (callLogs.callType == CallType.VIDEO_CALL)
            holder.imageViewCallIcon.setImageResource(R.drawable.ic_call_log_video_call)
    }

    //Shows icon whether the call is missed call or attended call
    private fun setCallStatusIcon(holder: CallHistorySearchViewHolder, callLogs: CallLog) {
        when (callLogs.callState) {
            CallState.MISSED_CALL -> holder.imgCallStatus.setImageResource(R.drawable.ic_arrow_down_red)
            CallState.INCOMING_CALL -> holder.imgCallStatus.setImageResource(R.drawable.ic_arrow_down_green)
            CallState.OUTGOING_CALL -> holder.imgCallStatus.setImageResource(R.drawable.ic_arrow_up_green)
        }
    }

    /**
     * Get the Call log position form the
     *
     * @param position holder position
     * @return list position
     */
    fun getCallLogAtPosition(position: Int): CallLog {
        return mCallLogsList[position]
    }

    inner class CallHistorySearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * The image view of the Roster.
         */
        val imgRoster: CircularImageView = itemView.findViewById(R.id.image_chat_picture)

        /**
         * TextView for call start time
         */
        val txtCallTime: CustomTextView = itemView.findViewById(R.id.text_call_time)

        /**
         * TextView for call duration.
         */
        val txtCallDurationTime: CustomTextView = itemView.findViewById(R.id.text_call_duration_time)

        /**
         * Incoming or outgoing call type
         */
        val imageViewCallIcon: ImageView = itemView.findViewById(R.id.img_call_type)

        /**
         * The call status image.
         */
        val imgCallStatus: ImageView = itemView.findViewById(R.id.img_call_status)

        /**
         * Email icon view for email contacts.
         */
        var emailContactIcon: CircularImageView = itemView.findViewById(R.id.email_contact_icon)

        /**
         * The name of the Roster.
         */
        val txtChatPersonName: EmojiAppCompatTextView = itemView.findViewById(R.id.text_chat_name)

    }

}