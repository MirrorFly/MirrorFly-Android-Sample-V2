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
import dagger.android.AndroidInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.HashMap

class ChatTagActivity : AppCompatActivity() {

    private val TAG: String = ChatTagActivity::class.java.simpleName

    private lateinit var mContext: Context
    private lateinit var binding: ActivityChatTagBinding
    var chatTagnamelist=ArrayList<ChatTagModel>()
    lateinit var chatTagadapter: ChatTagAdapter
    var isRecommendedTag:String="0"
    var tagName:String=""

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
                        isRecommendedTag= data.get(Constants.IS_RECOMMENDED_KEY) as String
                        chatTagnamelist= data.getData() as ArrayList<ChatTagModel>
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
            createChatTagPageLaunch()
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
        resultLauncher.launch(intent)
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                getChatTagData()
            }
        }
}