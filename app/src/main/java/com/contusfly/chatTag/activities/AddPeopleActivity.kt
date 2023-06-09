package com.contusfly.chatTag.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.contusfly.R
import com.contusfly.chatTag.adapter.PeopleSelectionListAdapter
import com.contusfly.chatTag.adapter.PeoplelistAdapter
import com.contusfly.chatTag.interfaces.ChatTagClickListener
import com.contusfly.chatTag.viewmodel.ChatTagViewModel
import com.contusfly.databinding.ActivityAddPeopleBinding
import com.contusfly.isDeletedContact
import com.contusfly.utils.LogMessage
import com.mirrorflysdk.api.models.RecentChat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class AddPeopleActivity : AppCompatActivity(), ChatTagClickListener {

    private val TAG: String = AddPeopleActivity::class.java.simpleName
    private lateinit var mContext: Context
    private lateinit var binding: ActivityAddPeopleBinding
    private lateinit var emptyView: TextView
    private var recentChatList = ArrayList<RecentChat>()
    private var chatSelectedList = ArrayList<RecentChat>()

    private val viewModel by lazy {
        ViewModelProvider(this).get(ChatTagViewModel::class.java)
    }

    private val mAdapter by lazy {
        PeoplelistAdapter(this, this,recentChatList)
    }

    private val mSelectionAdapter by lazy {
        PeopleSelectionListAdapter(this, this,false,chatSelectedList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = this@AddPeopleActivity
        binding.toolbarView.titleTv.text=resources.getString(R.string.add_people_title)
        observer()
        getChatlist()
    }

    private fun getIntentvalues() {
        try {

            var jsonText = intent!!.getStringExtra("data")
            val listType: Type = object : TypeToken<List<RecentChat?>?>() {}.getType()
            chatSelectedList = Gson().fromJson(jsonText, listType)
            selectionListChecking()
            initView()
            onclickListener()
            addButtonEnableDisable()
            textChangeListener()

        } catch (e: Exception) {

            LogMessage.e(TAG, e.toString())
        }
    }

    private fun initView() {
        emptyView = binding.emptyList.textEmptyView
        emptyView.text = getString(R.string.msg_no_results)
        emptyView.setTextColor(
            ResourcesCompat.getColor(
                resources,
                R.color.color_text_no_list,
                null
            )
        )
        setRecentChatAdapter()
    }

    private fun setRecentChatAdapter() {
        var layoutManager = LinearLayoutManager(mContext)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.apply {
            adapter = mAdapter
        }
        mAdapter.notifyDataSetChanged()
    }

    private fun setSelectionListChatAdapter() {
        var layoutManager = LinearLayoutManager(mContext)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.selectedRecyclerview.layoutManager = layoutManager
        binding.selectedRecyclerview.apply {
            itemAnimator = null
            adapter = mSelectionAdapter
        }
    }

    private fun getChatlist() {
        viewModel.getRecentChats()
    }

    private fun observer() {
        viewModel.recentChatList.observe(this, Observer {
            LogMessage.i(TAG, "recentChatDiffResult observed")
            val finalRecentChatList=ArrayList<RecentChat>()
            for (recentItem in it) {
                if (!recentItem.isAdminBlocked && !recentItem.isDeletedContact()) {
                    finalRecentChatList.add(recentItem)
                }
            }
            recentChatList = finalRecentChatList
            getIntentvalues()
        })
    }

    private fun onclickListener() {
        binding.toolbarView.backArrowIcon.setOnClickListener {
            onBackPressed()
        }

        binding.addPeopleButtonView.setOnClickListener {
            setResult()
            finish()
        }
    }

    private fun textChangeListener(){

        binding.searchEditText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(p0: Editable?) {

                try {

                    var value = p0.toString()

                    if (mAdapter != null) {

                        mAdapter.filter.filter(value)
                    }

                } catch (e: Exception) {

                    LogMessage.e(TAG,e.toString())
                }

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //Nothing Do
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //Nothing Do
            }
        })
    }

    override fun selectUnselectChat(position: Int, item: RecentChat, isSelectionlist: Boolean) {

        try {
            val updatePosition = mSelectionAdapter.getItemPosition(item)
            if (!isSelectionlist) {
                peopleSelectionChecking(position,item)
            } else {
                for (i in 0 until recentChatList.size) {
                    if (item.jid.equals(recentChatList.get(i).jid)) {
                        recentChatList.get(i).isSelected = false
                        break
                    }
                }
                chatSelectedList.removeAt(position)
                setResult()
            }
            if(chatSelectedList.size == 0) {
                mAdapter.notifyDataSetChanged()
                setSelectionListChatAdapter()
                mSelectionAdapter.clear()
            } else {
                mAdapter.notifyDataSetChanged()
                setSelectionListChatAdapter()
                mSelectionAdapter.updateList(
                    chatSelectedList,
                    updatePosition,
                    true,
                    item.isSelected
                )
            }
            addButtonEnableDisable()

        } catch (e: Exception) {
            LogMessage.e(TAG, e.toString())
        }
    }

    private fun peopleSelectionChecking(position: Int, item: RecentChat){
        try{
            if (chatSelectedList.size == 0) {
                chatSelectedList.add(item)
            } else {
                peopleAlreadySelectionChecking(position,item)
            }
            recentChatList.get(position).isSelected = !item.isSelected

        }catch(e:Exception){
            LogMessage.e(TAG,e.toString())
        }
    }

    private fun peopleAlreadySelectionChecking(position: Int, item: RecentChat){

        try{
            if (recentChatList.get(position).isSelected) {
                for (i in 0 until chatSelectedList.size) {
                    if (item.jid.equals(chatSelectedList.get(i).jid)) {
                        chatSelectedList.removeAt(i)
                        break
                    }
                }

            } else {
                chatSelectedList.add(item)
            }

        }catch(e:Exception){
            LogMessage.e(TAG,e.toString())
        }
    }

    override fun filterListUpdated(filterList: ArrayList<RecentChat>) {

        recentChatList=filterList
        emptyDataChecking()
    }

    private fun addButtonEnableDisable() {
        if (chatSelectedList.size > 0) {
            binding.addPeopleButtonView.isEnabled = true
        } else {
            binding.addPeopleButtonView.isEnabled = false
        }
    }

    private fun selectionListChecking(){
        for(i in 0 until chatSelectedList.size){
            var jid=chatSelectedList.get(i).jid
            for(j in 0 until recentChatList.size){
                if(jid.equals(recentChatList.get(j).jid)){
                    recentChatList.get(j).isSelected=true
                    break
                }
            }
        }
        setSelectionListChatAdapter()
    }

    private fun emptyDataChecking(){

        if (recentChatList.size == 0) {

            emptyView.visibility = View.VISIBLE

        } else {

            emptyView.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        finish()
    }

    private fun setResult() {
        val intent = Intent()
        intent.putExtra("data", Gson().toJson(chatSelectedList))
        setResult(Activity.RESULT_OK, intent)
    }
}