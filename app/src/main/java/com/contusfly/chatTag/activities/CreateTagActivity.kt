package com.contusfly.chatTag.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.FlyCallback
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.chatTag.adapter.PeopleSelectionListAdapter
import com.contusfly.chatTag.interfaces.ChatTagClickListener
import com.contusfly.chatTag.viewmodel.ChatTagViewModel
import com.contusfly.databinding.ActivityCreateTagBinding
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
        initView()
        setSelectionListChatAdapter()
        onClickListener()
        textChangeListener()
        editTextDrawableClickListener()
    }

    private fun getIntentvalues(){
        var tagName=intent.getStringExtra("tagname")
        binding.tagNameEdittext.setText(tagName)
        titlevalueChecking(tagName!!)
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

            createChatTagwithPeople()
        }

        binding.addPeopleButtonView.setOnClickListener {

            addpeoplePageLaunch()
        }
    }

    private fun textChangeListener() {

        binding.tagNameEdittext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Nothing Do
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Nothing Do
            }

            override fun afterTextChanged(s: Editable?) {

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
            binding.toolbarView.toolbarActionTitleTv.text =
                resources.getString(R.string.label_create)
            binding.toolbarView.toolbarActionTitleTv.setTextColor(
                ContextCompat.getColor(mContext, R.color.blue)
            )
        } else {
            binding.toolbarView.toolbarActionTitleTv.text = ""
        }
    }

    private fun createChatTagwithPeople() {
        try {
            if (memberIdlist.size > 0 && chatSelectedList.size > 0) {
                tagId = System.currentTimeMillis().toString()
                var model = ChatTagModel()
                model.setTagId(tagId)
                model.tagname = binding.tagNameEdittext.text.toString()
                model.taginfo = Constants.EMPTY_STRING
                model.memberIdlist = Gson().toJson(memberIdlist)
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
                    mSelectionAdapter.updateList(chatSelectedList)
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