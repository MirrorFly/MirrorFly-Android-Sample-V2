package com.contusfly.chatTag.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.FlyCallback
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.chatTag.activities.ChatTagActivity.Companion.chatTagMemberIdList
import com.contusfly.chatTag.activities.ChatTagActivity.Companion.createdChatTagList
import com.contusfly.chatTag.adapter.PeopleSelectionListAdapter
import com.contusfly.chatTag.interfaces.ChatTagClickListener
import com.contusfly.chatTag.viewmodel.ChatTagViewModel
import com.contusfly.databinding.ActivityCreateTagBinding
import com.contusfly.isDeletedContact
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CommonAlertDialog
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.models.RecentChat
import com.mirrorflysdk.flydatabase.model.ChatTagModel
import com.mirrorflysdk.views.CustomToast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mirrorflysdk.flycommons.FlyUtils
import java.lang.reflect.Type
import java.util.HashMap

class CreateTagActivity : AppCompatActivity(), ChatTagClickListener,
    CommonAlertDialog.CommonDialogClosedListener {

    private val TAG: String = CreateTagActivity::class.java.simpleName

    private lateinit var mContext: Context
    private lateinit var binding: ActivityCreateTagBinding

    private var tagId: String = ""
    private var memberIdlist = ArrayList<String>()
    private var chatSelectedList = ArrayList<RecentChat>()
    private var preDefinedTag=""
    private var isFromEditTagItem = false
    private var chatTagId:String=""
    private var clickedTagPosition = 0
    private var finalTagName:String?=null
    var cursorPosition = 0


    private var mDialog: CommonAlertDialog? = null
    private var itemSelectedPosition: Int = 0

    private val mSelectionAdapter by lazy {
        PeopleSelectionListAdapter(this, this, true, chatSelectedList)
    }

    private val viewModel by lazy {
        ViewModelProvider(this).get(ChatTagViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTagBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = this@CreateTagActivity
        getIntentvalues()
        getChatTagItems()
        setObservers()
        initView()
        setSelectionListChatAdapter()
        onClickListener()
        textChangeListener()
        editTextDrawableClickListener()
    }

    private fun getIntentvalues(){
        var tagName=intent.getStringExtra("tagname")
        isFromEditTagItem=intent.getBooleanExtra(Constants.EDIT_CHAT_TAG_ITEMS,false)
        chatTagId = intent.getStringExtra(Constants.CHAT_TAG_ID).toString()
        clickedTagPosition = intent.getIntExtra(Constants.CHAT_TAG_POSITION, 0)
        preDefinedTag= tagName.toString()
        binding.tagNameEdittext.setText(tagName)
        finalTagName = tagName
        titlevalueChecking(tagName!!)
    }

    private fun getChatTagItems(){
        if(isFromEditTagItem)
            viewModel.getRecentChatBasedOnChatTag(chatTagMemberIdList)
    }

    private fun setObservers(){
        viewModel.chatTagRecentItems.observe(this) {
            val finalChatTagRecentChatList=ArrayList<RecentChat>()
            for (recentItem in it) {
                if (!recentItem.isAdminBlocked && !recentItem.isDeletedContact()) {
                    finalChatTagRecentChatList.add(recentItem)
                }
            }
            chatSelectedList=finalChatTagRecentChatList
            mSelectionAdapter.updateList(chatSelectedList,0,false,false)
            addSelectedmemberList()
        }
    }

    private fun initView() {
        mDialog = CommonAlertDialog(mContext)
        mDialog!!.setOnDialogCloseListener(this)
    }

    private fun setSelectionListChatAdapter() {
        var layoutManager = LinearLayoutManager(mContext)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.apply {
            adapter = mSelectionAdapter
        }
    }

    private fun onClickListener() {

        binding.toolbarView.backArrowIcon.setOnClickListener {

            finish()
        }

        binding.toolbarView.toolbarActionTitleTv.setOnClickListener {
            if (isFromEditTagItem)
                updateChatTagWithPeople()
            else
                createChatTagwithPeople()
        }

        binding.addPeopleButtonView.setOnClickListener {

            addpeoplePageLaunch()
        }
    }

    private fun textChangeListener() {

        binding.tagNameEdittext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                cursorPosition = binding.tagNameEdittext.selectionEnd
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    val length = binding.tagNameEdittext.text.toString().length
                    if (length > 20) {
                        binding.tagNameEdittext.setText(finalTagName)
                        binding.tagNameEdittext.setSelection(cursorPosition-1)
                        CustomToast.showShortToast(this@CreateTagActivity, getString(R.string.max_tag_name_chars))
                    }
                }catch (e:Exception){
                    com.contusfly.utils.LogMessage.e(TAG, "Tag Name issue ==> ${e.message}")
                }
            }

            override fun afterTextChanged(s: Editable?) {
                finalTagName=binding.tagNameEdittext.text.toString()
                titlevalueChecking(s.toString())

            }

        })
    }

    private fun titlevalueChecking(tagname: String) {
        if (tagname.isNotEmpty()) {
            editTextRightDrawableSet(true)
            toolbarTitleSet(true)
        } else {
            editTextRightDrawableSet(false)
            toolbarTitleSet(false)
        }
    }

    private fun editTextRightDrawableSet(isSet: Boolean) {
        if (isSet) {
            binding.tagNameEdittext.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                R.drawable.chat_tag_name_close_icon,
                0
            )
        } else {
            binding.tagNameEdittext.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                0,
                0
            )
        }
    }

    private fun editTextDrawableClickListener(){

        binding.tagNameEdittext.onRightDrawableClicked {
            binding.tagNameEdittext.setText("")
        }
    }

    fun EditText.onRightDrawableClicked(onClicked: (view: EditText) -> Unit) {
        this.setOnTouchListener { v, event ->
            var hasConsumed = false
            if (v is EditText) {
                hasConsumed=drawableClick(event,v,onClicked,this)
            }
            hasConsumed
        }
    }

    private fun drawableClick(
        event: MotionEvent,
        v: EditText,
        onClicked: (view: EditText) -> Unit,
        editText: EditText):Boolean{
        var consumed = false
        if (event.x >= v.width - v.totalPaddingRight && event.action == MotionEvent.ACTION_UP) {
            onClicked(editText)
            consumed = true
        }
        return consumed
    }

    private fun toolbarTitleSet(isSet: Boolean) {
        if (isSet) {
            binding.toolbarView.titleTv.text=if(isFromEditTagItem) resources.getString(R.string.edit_tag) else resources.getString(R.string.create_tag)
            binding.toolbarView.toolbarActionTitleTv.text =if(isFromEditTagItem) resources.getString(R.string.label_update) else resources.getString(R.string.label_create)
            binding.toolbarView.toolbarActionTitleTv.setTextColor(
                ContextCompat.getColor(mContext, R.color.blue)
            )
            binding.toolbarView.toolbarActionTitleTv.visibility= View.VISIBLE
        } else {
            binding.toolbarView.titleTv.text=if(isFromEditTagItem) resources.getString(R.string.edit_tag) else resources.getString(R.string.create_tag)
            binding.toolbarView.toolbarActionTitleTv.text = ""
            binding.toolbarView.toolbarActionTitleTv.visibility= View.INVISIBLE
        }
    }

    private fun updateChatTagWithPeople(){
        try {
            if (memberIdlist.size > 0 && chatSelectedList.size > 0) {
                if (createdChatTagList != null && createdChatTagList.size > 0 && chatTagNameAlreadyExistCheckForUpdate()) {
                    CustomToast.show(mContext, resources.getString(R.string.tag_name_already_exist))
                    return
                }
                var model = ChatTagModel()
                model.setTagId(chatTagId)
                model.tagname = binding.tagNameEdittext.text.toString()
                model.taginfo = Constants.EMPTY_STRING
                model.memberIdlist = Gson().toJson(memberIdlist)
                model.order= clickedTagPosition
                model.setisRecommentedTag(false)
                model.setCurentUserId(FlyUtils.getIdFromJid(SharedPreferenceManager.getCurrentUserJid()))
                FlyCore.updateChatTagDataItem(chatTagId, model, object : FlyCallback {
                    override fun flyResponse(
                        isSuccess: Boolean,
                        throwable: Throwable?,
                        data: HashMap<String, Any>,
                    ) {
                        if (isSuccess) {
                            setResult(Activity.RESULT_OK)
                            finish()

                        }
                    }

                })
            } else {
                CustomToast.show(mContext, resources.getString(R.string.empty_list))
            }
        }catch (e:Exception){
            LogMessage.e(TAG, e.toString())
        }
    }

    private fun createChatTagwithPeople() {
        try {
            if (memberIdlist.size > 0 && chatSelectedList.size > 0) {
                if (createdChatTagList != null && createdChatTagList.size > 0 && chatTagNameAlreadyExistCheck() && (preDefinedTag.isEmpty())) {
                    CustomToast.show(mContext, resources.getString(R.string.tag_name_already_exist))
                    return
                }
                tagId = System.currentTimeMillis().toString()
                var model = ChatTagModel()
                model.setTagId(tagId)
                model.tagname = binding.tagNameEdittext.text.toString()
                model.taginfo = Constants.EMPTY_STRING
                model.memberIdlist = Gson().toJson(memberIdlist)
                model.order=FlyCore.getChatTagDataSize()
                model.setisRecommentedTag(false)
                model.setCurentUserId(FlyUtils.getIdFromJid(SharedPreferenceManager.getCurrentUserJid()))
                FlyCore.createChatTagdata(
                    model,
                    object : FlyCallback {
                        override fun flyResponse(
                            isSuccess: Boolean,
                            throwable: Throwable?,
                            data: HashMap<String, Any>
                        ) {
                            if (isSuccess) {

                                setResult(Activity.RESULT_OK)
                                finish()

                            }
                        }
                    })
            } else {

                CustomToast.show(mContext, resources.getString(R.string.empty_list))
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e.toString())
        }
    }

    private fun chatTagNameAlreadyExistCheck(): Boolean {
        for (names in createdChatTagList) {
            if (binding.tagNameEdittext.text.toString().trim() == names.tagname.trim()) {
                return true
            }
        }
        return false
    }
    private fun chatTagNameAlreadyExistCheckForUpdate(): Boolean {
        for (names in createdChatTagList) {
            if (binding.tagNameEdittext.text.toString().trim() == names.tagname.trim() && preDefinedTag.trim()!=names.tagname.trim()) {
                return true
            }
        }
        return false
    }

    private fun addpeoplePageLaunch() {

        val intent = Intent(mContext, AddPeopleActivity::class.java)
        intent.putExtra("data", Gson().toJson(chatSelectedList))
        resultLauncher.launch(intent)
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                try {

                    val data: Intent? = result.data
                    var jsonText = data!!.getStringExtra("data")
                    val listType: Type = object : TypeToken<List<RecentChat?>?>() {}.getType()
                    chatSelectedList = Gson().fromJson(jsonText, listType)
                    mSelectionAdapter.updateList(chatSelectedList,0,false,false)
                    addSelectedmemberList()

                } catch (e: Exception) {

                    LogMessage.d(TAG, e.toString())
                }
            }
        }

    private fun addSelectedmemberList() {

        try {
            memberIdlist = ArrayList()
            for (i in 0 until chatSelectedList.size) {
                memberIdlist.add(chatSelectedList.get(i).jid)
            }

        } catch (e: Exception) {
            LogMessage.e(TAG, e.toString())
        }
    }

    private fun removeSelectedmemberList(selectedMemberid:String) {

        try {
            for (i in 0 until memberIdlist.size) {
                if(selectedMemberid.equals(memberIdlist.get(i))){
                    memberIdlist.removeAt(i)
                }
            }

        } catch (e: Exception) {
            LogMessage.e(TAG, e.toString())
        }
    }


    override fun selectUnselectChat(position: Int, item: RecentChat, isSelectionlist: Boolean) {
        itemSelectedPosition = position
        alertDialogShow()
    }

    override fun filterListUpdated(filterList: ArrayList<RecentChat>) {
        //Nothing Do
    }


    override fun listOptionSelected(position: Int) {
        //Nothing Do
    }

    private fun alertDialogShow() {
        try {
            mDialog!!.showAlertDialogWithChatTagRemove(
                getString(R.string.remove_tag_title),
                getString(R.string.remove_tag_message),
                getString(R.string.delete_lable),
                getString(R.string.action_cancel),
                CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL
            )
        } catch (e: Exception) {
            LogMessage.d(TAG, e.toString())
        }
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            try {
                removeSelectedmemberList(chatSelectedList.get(itemSelectedPosition).jid)
                chatSelectedList.removeAt(itemSelectedPosition)
                mSelectionAdapter.notifyDataSetChanged()
            } catch (e: Exception) {
                LogMessage.e(TAG, e.toString())
            }
        }
    }
}