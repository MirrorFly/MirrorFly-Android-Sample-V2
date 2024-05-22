package com.contusfly.adapters

import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import androidx.emoji.widget.EmojiAppCompatTextView
import com.mirrorflysdk.flycommons.ChatTypeEnum
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.getDisplayName
import com.contusfly.utils.*
import com.contusfly.utils.ChatMessageUtils.fixEmojiAfterEllipses
import com.contusfly.utils.MediaUtils.loadImageWithGlideSecure
import com.contusfly.views.CustomTextView
import com.contusfly.views.SetDrawable
import com.mirrorflysdk.api.FlyMessenger.getGroupMessageStatusCount
import com.mirrorflysdk.api.models.MessageStatusDetail
import com.mirrorflysdk.utils.Utils
import java.text.SimpleDateFormat
import java.util.*

/**
 * This adapter load the group user seen and delivery list in expandable list view
 */
class MessageinfoExpandadapter(private val context: Context, chattype: ChatTypeEnum) : BaseExpandableListAdapter() {
    /**
     * msgId of the message
     */
    private var msgId: String? = null

    /**
     * Chat message time
     */
    private val mChatMsgTime: ChatMsgTime
    private var msgInfoHeader: List<String>? = null
    private var rosterImage: String? = null
    var groupPosition = 0
    var childPosition = 0
    var isExpanded = false
    var convertView: View? = null
    var parent: ViewGroup? = null

    /**
     * Group Header Title
     */
    private var headerTitle = ""
    private var msgInfoList: Map<String, List<MessageStatusDetail>>? = null
    private val chattype: ChatTypeEnum

    /**
     * set the data for the header and child item
     *
     * @param listDataHeader Header for the Expandable list view
     * @param listChildData  child view for the Expandable list view
     * @param msgId          msgId of the clicked message
     */
    fun setData(listDataHeader: List<String>?, listChildData: Map<String, List<MessageStatusDetail>>?, msgId: String?) {
        msgInfoHeader = listDataHeader
        msgInfoList = listChildData
        this.msgId = msgId
    }

    override fun getGroupCount(): Int {
        return msgInfoHeader!!.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        Log.d("childcount", Integer.toString(msgInfoList!![msgInfoHeader!![groupPosition]]!!.size))
        return msgInfoList!![msgInfoHeader!![groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return msgInfoHeader!![groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return msgInfoList!![msgInfoHeader!![groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        this.groupPosition = groupPosition
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        this.groupPosition = groupPosition
        this.childPosition = childPosition
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertViews: View?, parent: ViewGroup): View {
        this.isExpanded = isExpanded
        this.convertView = convertViews
        this.parent = parent
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.message_header_item, null)
        }
        val readby: CustomTextView = convertView?.findViewById(R.id.text_read_by)!!
        val indicator = convertView!!.findViewById<ImageView>(R.id.header_icon)

        /**
         * Group member count
         */
        val count = getGroupMessageStatusCount(msgId!!)
        headerTitle = getGroup(groupPosition) as String
        if (headerTitle == DELIVERED_TO) {
            val header = headerTitle + getChildrenCount(groupPosition) + " of " + count
            readby.text = header
        }
        if (headerTitle == READ_BY) {
            val header = headerTitle + getChildrenCount(groupPosition) + " of " +  count
            readby.text = header
        }
        if (isExpanded) {
            indicator.setImageResource(R.drawable.ic_collapse)
        } else {
            indicator.setImageResource(R.drawable.ic_expand)
        }
        return convertView as View
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertViews: View?, parent: ViewGroup): View {
        var convertView = convertViews
        val infalInflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        convertView = infalInflater.inflate(R.layout.message_child_item, null)
        try {
            val txtName: EmojiAppCompatTextView = convertView.findViewById(R.id.text_chat_name)
            val txtStatus: EmojiAppCompatTextView = convertView.findViewById(R.id.text_user_status)
            txtName.viewTreeObserver.addOnGlobalLayoutListener {
                fixEmojiAfterEllipses(
                    txtName
                )
            }
            txtStatus.viewTreeObserver.addOnGlobalLayoutListener {
                fixEmojiAfterEllipses(
                    txtStatus
                )
            }
            val imgRoster = convertView.findViewById<ImageView>(R.id.image_chat_picture)
            val (_, _, _, time, memberProfileDetails) = getChild(
                groupPosition,
                childPosition
            ) as MessageStatusDetail
            rosterImage = Utils.returnEmptyStringIfNull(memberProfileDetails.image)
            val setDrawable = SetDrawable(
                context, memberProfileDetails
            )
            val icon = setDrawable.setDrawable(memberProfileDetails.getDisplayName())
            loadImageWithGlideSecure(
                context, rosterImage,
                imgRoster,
                icon
            )
            val emojiUtils = EmojiUtils
            emojiUtils.setEllipsisText(txtName, memberProfileDetails.getDisplayName())
            var chatTime = ""
            var chatDate = ""
            val formatter = SimpleDateFormat("dd-MMM-yyy", Locale.getDefault())
            val dateFormat = SimpleDateFormat("MMM dd,yyyy", Locale.getDefault())
            if (headerTitle == DELIVERED_TO || headerTitle == READ_BY) {
                chatDate = formatter.format(dateFormat.parse(ChatUserTimeUtils.getDateFromTimestamp(time.toLong())))
                chatTime = Utils.returnEmptyStringIfNull(time)
            }
            if (!chatTime.isEmpty() && TextUtils.isDigitsOnly(chatTime)) {
                val chatdate = "$chatDate at " + mChatMsgTime.getDaySentMsg(context, chatTime.toLong())
                txtStatus.text = chatdate
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }

    override fun onGroupExpanded(groupPosition: Int) {
        super.onGroupExpanded(groupPosition)
        rosterImage = ""
    }

    companion object {
        private const val DELIVERED_TO = "Delivered to "
        private const val READ_BY = "Read by "
    }

    /**
     * Constructor for message info adapter
     *
     * @param context  Context of the activity
     * @param chattype ChatType of the Message to be clicked to get info
     */
    init {
        mChatMsgTime = ChatMsgTime(Calendar.getInstance())
        this.chattype = chattype
    }
}
