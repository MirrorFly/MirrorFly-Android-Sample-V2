package com.contusfly.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.R
import com.contusfly.activities.parent.BaseMessageInfoActivity
import com.contusfly.adapters.MessageinfoExpandadapter
import com.contusfly.interfaces.GetMessageStatusCallback
import com.contusfly.showToast
import com.contusfly.utils.ChatMessageUtils
import com.contusfly.utils.ChatUserTimeUtils
import com.contusfly.utils.GroupUtils.getMessageStatus
import com.contusfly.utils.UserInterfaceUtils
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.FlyMessenger.getMessageOfId
import com.mirrorflysdk.api.models.MessageStatusDetail
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * The class GroupMessageInfoActivity shows group/broadcast chat message in common.
 */
class GroupMessageInfoActivity : BaseMessageInfoActivity() {
    /**
     * Header for delivery Expandable list view
     */
    var listdeliverDataHeader: MutableList<String>? = null

    /**
     * Child data for delivery status Expandable list view
     */
    var listdeliverDataChild: HashMap<String, List<MessageStatusDetail>>? = null

    /**
     * Header for read Expandablelist view
     */
    var listreadDataHeader: MutableList<String>? = null

    /**
     * child view for Read status Expandable list view
     */
    var listreadDataChild: HashMap<String, List<MessageStatusDetail>>? = null

    /**
     * group memebers count
     */
    var count = 0

    /**
     * group message read status
     */
    private var readStatus: List<MessageStatusDetail>? = null

    /**
     * text view to show the messages sent date
     */
    private var txtDate: TextView? = null

    /**
     *
     */
    private var notxt: TextView? = null

    /**
     * image view seen when message deliver to no one
     */
    private var img: ImageView? = null

    /**
     * group message delivery status
     */
    private var deliveryStatus: List<MessageStatusDetail>? = null

    /**
     * expandable list for the deliver status
     */
    private var deliverStatus: ExpandableListView? = null

    /**
     * expandable list for the read status
     */
    private var read: ExpandableListView? = null

    /**
     * Adapter for the deliver status
     */
    private var infoadapterdeliver: MessageinfoExpandadapter? = null

    /**
     * Adapter for the read status
     */
    private var infoadapterread: MessageinfoExpandadapter? = null
    private var notxtread: TextView? = null
    private var noimgread: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_message_info)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        UserInterfaceUtils.setUpToolBar(
            this,
            toolbar,
            getSupportActionBar(),
            getString(R.string.msg_info)
        )
        txtDate = findViewById(R.id.text_date)
        notxt = findViewById(R.id.nomsg_txt)
        notxtread = findViewById(R.id.nomsg_txt_read)
        noimgread = findViewById(R.id.empty_img_read)
        img = findViewById(R.id.empty_img)
        notxt!!.setText(R.string.no_message)
        notxtread!!.setText(R.string.no_message_read)
        img!!.setImageResource(R.drawable.no_messages)
        noimgread!!.setImageResource(R.drawable.no_messages)
        deliverStatus = findViewById(R.id.expand_Deliverlist)
        read = findViewById(R.id.expand_readlist)
        infoadapterdeliver = message?.let { MessageinfoExpandadapter(this, it.getMessageChatType()) }
        infoadapterread = message?.let { MessageinfoExpandadapter(this, it.getMessageChatType()) }
        listdeliverDataHeader = ArrayList()
        listdeliverDataChild = HashMap()
        listreadDataHeader = ArrayList()
        listreadDataChild = HashMap()
        loadChatInfo()
    }

    override fun onMessageStatusUpdated(messageId: String) {
        super.onMessageStatusUpdated(messageId)
        if (msgId.equals(messageId)) {
            onGroupMsgStatusUpdated()
        }
    }

    override fun onUpdateUnStarAllMessages() {
        super.onUpdateUnStarAllMessages()
        if (!message!!.getMessageId().isNullOrEmpty()) {
            message = getMessageOfId(message!!.getMessageId())
            if ((message!!.messageType == MessageType.IMAGE || message!!.messageType == MessageType.VIDEO)
                && message!!.getMediaChatMessage().getMediaCaptionText() != null
                && message!!.getMediaChatMessage().getMediaCaptionText().isNotEmpty())
                ChatMessageUtils.setFavouriteStatus(captionStar, message!!.isMessageStarred())
            else ChatMessageUtils.setFavouriteStatus(imgFav, message!!.isMessageStarred())
        }
    }

    override fun onProfileUpdatedCallback(jid: String) {
        super.onProfileUpdatedCallback(jid)
        infoadapterread?.notifyDataSetChanged()
        infoadapterdeliver?.notifyDataSetChanged()
    }

    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        if (listdeliverDataChild?.any { it.value.any { it.userJid == jid } } == true || listreadDataChild?.any { it.value.any { it.userJid == jid } } == true)
            loadGroupChatInfo()
    }

    private fun onGroupMsgStatusUpdated() {
        img!!.visibility = View.GONE
        notxt!!.visibility = View.GONE
        notxtread!!.visibility = View.GONE
        noimgread!!.visibility = View.GONE
        val messageStatus = FlyMessenger.getMessageStatusOfMid(message!!.messageId)
        ChatMessageUtils.setChatStatus(imgChatStatus!!, messageStatus)
        getMessageStatus(
            msgId!!,
            object : GetMessageStatusCallback {
                override fun onGetMessageStatusLoaded(
                    deliveredStatus: List<MessageStatusDetail>,
                    readByStatus: List<MessageStatusDetail>
                ) {
                    deliveryStatus = deliveredStatus
                    readStatus = readByStatus
                    listdeliverDataChild!![listdeliverDataHeader!![0]] = deliveryStatus!!
                    listreadDataChild!![listreadDataHeader!![0]] = readStatus!!
                    infoadapterdeliver!!.notifyDataSetChanged()
                    infoadapterread!!.notifyDataSetChanged()
                }
            })
    }

    /**
     * method to load the chat info broadcast or group message info
     */
    private fun loadChatInfo() {
         loadGroupChatInfo()
    }

    /**
     * method to show the seen and delivery info status of members in the group messages
     */
    private fun loadGroupChatInfo() {
        val formatter = SimpleDateFormat("dd-MMM-yyy", Locale.getDefault())
        val formatter1 = SimpleDateFormat("MMM dd,yyyy", Locale.getDefault())
        getMessageStatus(
            msgId!!,
            object : GetMessageStatusCallback {
                override fun onGetMessageStatusLoaded(
                    deliveredStatus: List<MessageStatusDetail>,
                    readByStatus: List<MessageStatusDetail>
                ) {
                    deliveryStatus = deliveredStatus
                    readStatus = readByStatus
                    var messageDate: String? = null
                    try {
                        messageDate = formatter.format(
                            formatter1.parse(
                                getMessageOfId(msgId!!)
                                    ?.getMessageSentTime()?.let {
                                        ChatUserTimeUtils
                                            .getDateFromTimestamp(
                                                it
                                            )
                                    }
                            )
                        )
                    } catch (e: ParseException) {
                        LogMessage.e(e)
                    }
                    if (messageDate != null && !messageDate.contains("1970")) {
                        txtDate!!.text = messageDate
                    }
                    loadChatInformation()
                }
            })
    }

    private fun loadChatInformation() {
        listdeliverDataHeader!!.clear()
        listdeliverDataHeader!!.add("Delivered to ")
        listdeliverDataChild!![listdeliverDataHeader!![0]] = deliveryStatus!!
        infoadapterdeliver?.setData(listdeliverDataHeader, listdeliverDataChild, msgId)
        ongroupclicklistener(deliverStatus, infoadapterdeliver, img, notxt)
        deliverStatus?.setAdapter(infoadapterdeliver)
        infoadapterdeliver?.notifyDataSetChanged()
        listreadDataHeader!!.clear()
        listreadDataHeader!!.add("Read by ")
        listreadDataChild!![listreadDataHeader!![0]] = readStatus!!
        infoadapterread?.setData(listreadDataHeader, listreadDataChild, msgId)
        ongroupclicklistener(read, infoadapterread, noimgread, notxtread)
        read?.setAdapter(infoadapterread)
        infoadapterread?.notifyDataSetChanged()
    }

    /**
     * @param listView expandable list view to set for on groupexapand and collapse listener
     * @param adapter  adapter for expandable list view
     */
    private fun ongroupclicklistener(
        listView: ExpandableListView?,
        adapter: BaseExpandableListAdapter?,
        img: ImageView?,
        txt: TextView?
    ) {
        listView!!.setOnGroupClickListener { _: ExpandableListView?, _: View?, groupPosition: Int, _: Long ->
            val childcount = adapter!!.getChildrenCount(groupPosition)
            if (childcount == 0) {
                img!!.visibility = View.VISIBLE
                txt!!.visibility = View.VISIBLE
            } else {
                img!!.visibility = View.GONE
                txt!!.visibility = View.GONE
            }
            false
        }
        listView.setOnGroupCollapseListener { groupPosition: Int ->
            val childcount = adapter!!.getChildrenCount(groupPosition)
            if (childcount == 0) {
                img!!.visibility = View.GONE
                txt!!.visibility = View.GONE
            }
        }
    }

    override fun onDeleteGroup(groupJid: String) {
        super.onDeleteGroup(groupJid)
        if (this.groupJid.equals(groupJid)){
            setResult(Activity.RESULT_FIRST_USER)
            startDashboardActivity()
            finish()
        }
    }

    private fun startDashboardActivity() {
        val dashboardIntent = Intent(this, DashboardActivity::class.java)
        dashboardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(dashboardIntent)
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        if (this.groupJid == jid && status) {
            showToast(getString(R.string.group_block_message_label))
            startDashboardActivity()
            finish()
        }
    }
}
