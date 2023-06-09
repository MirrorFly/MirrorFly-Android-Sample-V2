package com.contusfly.chatTag.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.FlyCallback
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.chatTag.adapter.ChatTagAdapter
import com.contusfly.chatTag.interfaces.ListItemClickListener
import com.contusfly.databinding.ActivityChatTagBinding
import com.contusfly.getData
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.flydatabase.model.ChatTagModel
import com.mirrorflysdk.views.CustomToast
import dagger.android.AndroidInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.HashMap

class ChatTagActivity : AppCompatActivity() {

    private val TAG: String = ChatTagActivity::class.java.simpleName

    private lateinit var mContext: Context
    private lateinit var binding: ActivityChatTagBinding
    companion object{
        var createdChatTagList=ArrayList<ChatTagModel>()
        var chatTagMemberIdList:String=""
    }
    var chatTagnamelist=ArrayList<ChatTagModel>()
    lateinit var chatTagadapter: ChatTagAdapter
    var isRecommendedTag:String="0"
    var tagName:String=""
    var chatTagId:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding=ActivityChatTagBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = this@ChatTagActivity

        getChatTagData()
        onClickListener()
    }

    fun getChatTagData(){

        FlyCore.getChatTagdata(object: FlyCallback {
            override fun flyResponse(
                isSuccess: Boolean,
                throwable: Throwable?,
                data: HashMap<String, Any>
            ) {
                try{
                    if(isSuccess){
                        createdChatTagList.clear()
                        isRecommendedTag= data.get(Constants.IS_RECOMMENDED_KEY) as String
                        chatTagnamelist= data.getData() as ArrayList<ChatTagModel>
                        createdChatTagList=chatTagnamelist
                        chatTagAdapterset()
                        recommendedChatTagCheking()
                    } else {
                        var s=throwable!!.message
                        LogMessage.e(TAG,s)

                    }
                }catch(e:Exception){
                    LogMessage.e(TAG,e.toString())
                }
            }
        },false)
    }

    private fun recommendedChatTagCheking(){
        CoroutineScope(Dispatchers.Main).launch {
            if(isRecommendedTag.equals("1")){
                binding.recommendedChatTagTitle.text=resources.getString(R.string.recommended_chat_tag)
                binding.editInfoLayout.visibility= View.GONE
                binding.toolbarView.toolbarActionTitleTv.visibility= View.GONE
            } else{
                binding.toolbarView.toolbarActionTitleTv.visibility= View.VISIBLE
                binding.recommendedChatTagTitle.text=resources.getString(R.string.chat_tag_title)
                binding.editInfoLayout.visibility= View.VISIBLE
                binding.toolbarView.toolbarActionTitleTv.text=resources.getString(R.string.edit_label)
            }
        }
    }

    fun chatTagAdapterset(){

        CoroutineScope(Dispatchers.Main).launch {
            var linearlayoutmanager = LinearLayoutManager(mContext)
            linearlayoutmanager.orientation = LinearLayoutManager.VERTICAL
            binding.chatTagRecyclerview.layoutManager = linearlayoutmanager

            chatTagadapter= ChatTagAdapter(mContext, object: ListItemClickListener {

                override fun itemclicklistener(position: Int) {
                    tagName=chatTagnamelist.get(position).tagname
                    createChatTagPageLaunch()
                }

                override fun itemEditClickListener(position: Int) {
                    tagName=chatTagnamelist.get(position).tagname
                    chatTagId= chatTagnamelist.get(position).geTagId()
                    chatTagMemberIdList= chatTagnamelist[position].memberIdlist
                    editChatTagItemsPageLaunch(position)
                }

            },chatTagnamelist)
            binding.chatTagRecyclerview.adapter=chatTagadapter
        }
    }

    private fun onClickListener(){

        binding.toolbarView.backArrowIcon.setOnClickListener {
            finish()
        }

        binding.createChatTag.setOnClickListener{
            tagName=""
            if (chatTagnamelist.size < 10) {
                createChatTagPageLaunch()
            } else {
                CustomToast.showShortToast(
                    this@ChatTagActivity,
                    getString(R.string.max_tags_created)
                )
            }
        }

        binding.toolbarView.toolbarActionTitleTv.setOnClickListener {
            editChatTagPageLaunch()
        }

    }

    private fun editChatTagPageLaunch(){
        val intent= Intent(mContext,EditTagActivity::class.java)
        resultLauncher.launch(intent)
    }

    private fun createChatTagPageLaunch(){
        val intent= Intent(mContext,CreateTagActivity::class.java)
        intent.putExtra("tagname",tagName)
        intent.putExtra(com.contusfly.utils.Constants.EDIT_CHAT_TAG_ITEMS,false)
        resultLauncher.launch(intent)
    }

    private fun editChatTagItemsPageLaunch(chatTagPosition:Int){
        val intent= Intent(mContext,CreateTagActivity::class.java)
        intent.putExtra("tagname",tagName)
        intent.putExtra(com.contusfly.utils.Constants.EDIT_CHAT_TAG_ITEMS,true)
        intent.putExtra(com.contusfly.utils.Constants.CHAT_TAG_ID,chatTagId)
        intent.putExtra(com.contusfly.utils.Constants.CHAT_TAG_POSITION,chatTagPosition)
        resultLauncher.launch(intent)
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                getChatTagData()
            }
        }
}