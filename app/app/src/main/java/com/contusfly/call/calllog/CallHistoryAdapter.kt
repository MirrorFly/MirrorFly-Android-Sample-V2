package com.contusfly.call.calllog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.emoji.widget.EmojiAppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.contus.call.CallConstants.CALL_UI
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.CallMode
import com.mirrorflysdk.flycall.webrtc.CallState
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.call.database.model.CallLog
import com.mirrorflysdk.flycall.call.utils.CallTimeFormatter
import com.contusfly.*
import com.contusfly.adapters.holders.ProgressViewHolder
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.databinding.RowProgressBarBinding
import com.contusfly.utils.AppConstants
import com.contusfly.utils.ChatMessageUtils
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.views.CircularImageView
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.api.contacts.ProfileDetails
import java.util.*
import kotlin.collections.ArrayList

class CallHistoryAdapter(val context: Context, private val callLogsList: ArrayList<CallLog>, private val selectedCallLogs: ArrayList<String>, private var listener: OnItemClickListener)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isLoadingAdded = false
    private var loaderPosition = -1

    interface OnItemClickListener {
        fun onItemClick(view: ImageView, position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == AppConstants.ITEM) {
            CallHistoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_call_logs, parent, false))
        } else {
                val progressViewHolder = RowProgressBarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ProgressViewHolder(progressViewHolder)
            }
        }

    override fun getItemCount(): Int {
        return callLogsList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (!callLogsList[position].isDisplay) AppConstants.LOADING else AppConstants.ITEM
    }

    fun clearCallLogs() {
        callLogsList.clear()
        notifyDataSetChanged()
    }

    fun addLoadingFooter() {
        if (!isLoadingAdded) {
            isLoadingAdded = true
            callLogsList.add(CallLog())
            loaderPosition = callLogsList.size - 1
            notifyItemInserted(loaderPosition)
        }
    }

    fun removeLoadingFooter() {
        if (isLoadingAdded) {
            isLoadingAdded = false
            if (loaderPosition.isValidIndex() && callLogsList.size > loaderPosition) {
                callLogsList.removeAt(loaderPosition)
                notifyItemRemoved(loaderPosition)
                loaderPosition = -1
            }
        }
    }

    fun addCallLogList(callList : List<CallLog>) {
        val startIndex = callLogsList.size
         var updateList=ArrayList<CallLog>()
         updateList.addAll(callList)
        for(item in callList) {
            var roomid=item.roomId
            for(olditem in callLogsList) {
                if(roomid == olditem.roomId) {
                    updateList.remove(item)
                    break
                }
            }
        }
        callLogsList.addAll(updateList)
        notifyItemRangeInserted(startIndex, updateList.size)
        loaderChecking()
    }

    fun deleteCallLogList(callidList:ArrayList<String>){
        for(id in callidList) {
            var callId=id
            for(olditem in callLogsList) {
                if(callId == olditem.roomId) {
                    callLogsList.remove(olditem)
                    break
                }
            }
        }
        notifyDataSetChanged()
    }

    fun loaderChecking() {
        try {
            var updateList=ArrayList<CallLog>()
            updateList.addAll(callLogsList)
            for(olditem in callLogsList) {
                if(olditem.roomId == null || olditem.roomId.equals("")) {
                    updateList.remove(olditem)
                    break
                }
            }
            callLogsList.clear()
            callLogsList.addAll(updateList)
            notifyDataSetChanged()
        } catch(e:Exception) {
            com.contusfly.utils.LogMessage.e("Error",e.toString())
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is CallHistoryViewHolder -> {
                bindCallData(holder, callLogsList[position], position)
            }
            is ProgressViewHolder -> {
                holder.progressViewBinding.loadMoreProgress.show()
            }
        }
    }

    private fun bindCallData(
        holder: CallHistoryViewHolder,
        callLog: CallLog,
        position: Int
    ) {
        holder.txtChatPersonName?.viewTreeObserver?.addOnGlobalLayoutListener { ChatMessageUtils.fixEmojiAfterEllipses(holder.txtChatPersonName) }

        if (callLog.callTime != null)
            holder.txtCallTime.text = CallTimeFormatter.getCallTime(context, callLog.callTime!! / 1000)
        holder.txtCallDurationTime.text = CallTimeFormatter.getCallDurationTime(callLog.startTime!! / 1000, callLog.endTime!! / 1000)
        setUserView(holder, position)
        setCallType(holder, callLog)
        setCallStatusIcon(holder, callLog)
        updateSelectedItem(holder.itemView, selectedCallLogs.contains(callLog.roomId))
        holder.imageViewCallIcon.setOnClickListener(1000) {
            if (CallUtils.getCallLogUserJidList(callLog.fromUser, callLog.userList, false).isNotEmpty())
                listener.onItemClick(holder.imageViewCallIcon, callLogsList.indexOf(callLog))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty())
            onBindViewHolder(holder, position)
        else if (holder is CallHistoryViewHolder){
            val bundle = payloads[0] as Bundle
            handlePayloads(bundle, holder, position)
        }
    }


    private fun handlePayloads(bundle: Bundle, holder: CallHistoryViewHolder, position: Int) {
        for (key in bundle.keySet()) {
            when (key) {
                AppConstants.NOTIFY_PROFILE_ICON -> {
                    setUserView(holder, position)
                }
                AppConstants.NOTIFY_SELECTION -> {
                    updateSelectedItem(holder.itemView, bundle.getBoolean(AppConstants.NOTIFY_IS_SELECTED))
                }
                AppConstants.NOTIFY_ADMIN_BLOCK -> {
                    setUserView(holder, position)
                    setCallType(holder, callLogsList[position])
                }
                else -> {
                    LogMessage.e("ContactAdapter", "$CALL_UI Do Nothing")
                }
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return callLogsList[position].hashCode().toLong()
    }

    /**
     * Selected view when long press it
     *
     * @param view     Instance of the view
     * @param isSelected item selected or not
     */
    private fun updateSelectedItem(view: View, isSelected: Boolean) {
        if (isSelected)
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.color_transparent_bg))
        else
            view.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
    }

    /**
     * Get the Call log position form the
     *
     * @param position holder position
     * @return list position
     */
    fun getCallLogAtPosition(position: Int): CallLog {
        return callLogsList[position]
    }

    /**
     * This method is getting the caller name and profile picture
     *
     * @param holder holder instance
     * @param position adapter position
     */
    private fun setUserView(holder: CallHistoryViewHolder, position: Int) {

        if (callLogsList[position].callMode == CallMode.ONE_TO_ONE && (callLogsList[position].userList == null || callLogsList[position].userList!!.size < 2)) {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(if (callLogsList[position].callState == CallState.OUTGOING_CALL) callLogsList[position].toUser!! else callLogsList[position].fromUser!!)
            if (profileDetails != null) {
                profileIcon(holder, profileDetails)
                holder.emailContactIcon.gone()
            } else {
                holder.imgRoster.addImage(arrayListOf(callLogsList[position].fromUser!!))
                holder.txtChatPersonName.text = ProfileDetailsUtils.getDisplayName(callLogsList[position].fromUser!!)
            }
        } else {
            profileIconForManyUsers(holder, position)
        }
        if (position == callLogsList.size - 1) {
            holder.viewDiver?.visibility = View.GONE
        }else{
            holder.viewDiver?.visibility = View.VISIBLE
        }
    }

    private fun profileIconForManyUsers(holder: CallHistoryViewHolder, position: Int) {
        val callLog = callLogsList[position]
        if (!callLog.groupId.isNullOrEmpty()) {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(callLog.groupId!!)
            if (profileDetails != null) {
                profileIcon(holder, profileDetails)
                holder.emailContactIcon.gone()
            } else {
                holder.imgRoster.addImage(arrayListOf(callLog.groupId!!))
                holder.txtChatPersonName.text = ProfileDetailsUtils.getDisplayName(callLog.groupId!!)
            }
        } else {
            try{
                holder.txtChatPersonName.text = CallUtils.getCallLogUserNames(callLog.fromUser, callLog.userList)
                holder.imgRoster.addImage(CallUtils.getCallLogUserJidList(callLog.fromUser, callLog.userList) as ArrayList<String>)
            } catch(e:Exception){
                com.contusfly.utils.LogMessage.e("Error",e.toString())
            }
        }
        holder.emailContactIcon.gone()
    }

    private fun profileIcon(holder: CallHistoryViewHolder, roster: ProfileDetails) {
        holder.txtChatPersonName.text = roster.getDisplayName()
        holder.imgRoster.addImage(arrayListOf(roster.jid!!))
    }

    // here shows the icon whether the call is missed call or attended call
    private fun setCallType(holder: CallHistoryViewHolder, callLogs: CallLog) {
        setIconAlpha(holder, callLogs)
        // Display the icon whether the call is audio or video
        if (callLogs.callType == CallType.AUDIO_CALL) {
            holder.imageViewCallIcon.setImageResource(R.drawable.ic_call_log_voice_call)
        } else if (callLogs.callType == CallType.VIDEO_CALL) {
            holder.imageViewCallIcon.setImageResource(R.drawable.ic_call_log_video_call)
        }
    }

    private fun setIconAlpha(holder: CallHistoryViewHolder, callLogs: CallLog) {
        try {
            val profile = if (callLogs.callMode == CallMode.ONE_TO_ONE && (callLogs.userList == null || callLogs.userList!!.size < 2)) {
                ProfileDetailsUtils.getProfileDetails(if (callLogs.callState == CallState.OUTGOING_CALL) callLogs.toUser!! else callLogs.fromUser!!)
            } else if (!callLogs.groupId.isNullOrBlank()) {
                ProfileDetailsUtils.getProfileDetails(callLogs.groupId!!)
            } else null

            val adminBlockedStatus = profile?.isAdminBlocked ?: false
            val isDeletedUser = profile?.isDeletedContact() ?: false
            holder.imageViewCallIcon.alpha = if (adminBlockedStatus || isDeletedUser) 0.3f else 1f
            holder.imageViewCallIcon.isEnabled = !isDeletedUser
        } catch (e: Exception) {
            holder.imageViewCallIcon.alpha = 1f
            holder.imageViewCallIcon.isEnabled = true
        }
    }

    private fun setCallStatusIcon(holder: CallHistoryViewHolder, callLogs: CallLog) {
        var drawable = R.drawable.ic_arrow_down_red
        when (callLogs.callState) {
            CallState.MISSED_CALL -> drawable = R.drawable.ic_arrow_down_red
            CallState.INCOMING_CALL -> drawable = R.drawable.ic_arrow_down_green
            CallState.OUTGOING_CALL -> drawable = R.drawable.ic_arrow_up_green
        }
        holder.imgCallStatus.setImageResource(drawable)
    }


    inner class CallHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /**
         * The image view of the Roster.
         */
        val imgRoster = itemView.findViewById<CircularImageView>(R.id.image_chat_picture)

        /**
         * TextView for call start time
         */
        val txtCallTime = itemView.findViewById<CustomTextView>(R.id.text_call_time)

        /**
         * TextView for call duration.
         */
        val txtCallDurationTime = itemView.findViewById<CustomTextView>(R.id.text_call_duration_time)

        /**
         * Incoming or outgoing call type
         */
        val imageViewCallIcon = itemView.findViewById<ImageView>(R.id.img_call_type)

        /**
         * The call status image.
         */
        val imgCallStatus = itemView.findViewById<ImageView>(R.id.img_call_status)

        /**
         * Email icon view for email contacts.
         */
        var emailContactIcon = itemView.findViewById<CircularImageView>(R.id.email_contact_icon)

        /**
         * The name of the Roster.
         */
        val txtChatPersonName = itemView.findViewById<EmojiAppCompatTextView>(R.id.text_chat_name)

        val viewDiver: View? = itemView.findViewById(R.id.view_divider)
    }

}