package com.contusfly.chatTag.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.FlyCallback
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.chatTag.adapter.EditChatTagAdapter
import com.contusfly.chatTag.adapter.ReorderList
import com.contusfly.chatTag.interfaces.DialogPositiveButtonClick
import com.contusfly.chatTag.interfaces.ListItemClickListener
import com.contusfly.databinding.ActivityEditTagBinding
import com.contusfly.getData
import com.contusfly.utils.CommonUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.flydatabase.model.ChatTagModel
import dagger.android.AndroidInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Collections
import java.util.HashMap

class EditTagActivity : AppCompatActivity(),ReorderList {

    private val TAG: String = EditTagActivity::class.java.simpleName

    private lateinit var mContext: Context
    private lateinit var binding: ActivityEditTagBinding
    var chatTagnamelist= mutableListOf<ChatTagModel>()
    lateinit var chatTagadapter: EditChatTagAdapter
    var isRecommendedTag:String="0"
    var itemSelectedPosition:Int=0
    var chatTagId:String=""
    var tagName:String=""
    var deleteTagIdList=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding= ActivityEditTagBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = this@EditTagActivity

        getChatTagData()
        onClickListener()
    }

    fun getChatTagData(){

        ChatManager.getChatTagdata(object: FlyCallback {
            override fun flyResponse(
                isSuccess: Boolean,
                throwable: Throwable?,
                data: HashMap<String, Any>
            ) {
                try{
                    if(isSuccess){
                        chatTagnamelist= ArrayList()
                        deleteTagIdList= ArrayList()
                        isRecommendedTag= data.get(Constants.IS_RECOMMENDED_KEY) as String
                        chatTagnamelist= data.getData() as MutableList<ChatTagModel>
                        chatTagAdapterset()
                        recommendedChatTagCheking()
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
            } else{
                binding.recommendedChatTagTitle.text=resources.getString(R.string.chat_tag_title)
                binding.editInfoLayout.visibility= View.VISIBLE
                binding.toolbarView.toolbarActionTitleTv.text=resources.getString(R.string.save)
            }
        }
    }

    fun chatTagAdapterset(){
        CoroutineScope(Dispatchers.Main).launch {
            var linearlayoutmanager = LinearLayoutManager(mContext)
            linearlayoutmanager.orientation = LinearLayoutManager.VERTICAL
            binding.chatTagRecyclerview.layoutManager = linearlayoutmanager

            chatTagadapter= EditChatTagAdapter(mContext, object: ListItemClickListener {
                override fun itemclicklistener(position: Int) {
                    try {
                        chatTagId = chatTagnamelist.get(position).geTagId()!!
                        itemSelectedPosition=position
                        chatTagRemoveDialogShow()
                    } catch(e:IndexOutOfBoundsException) {
                        LogMessage.e("Error",e.toString())
                    } catch(e:Exception) {
                        LogMessage.e("Error",e.toString())
                    }
                }

                override fun itemEditClickListener(position: Int) {
                    TODO("Not yet implemented")
                }
            }, chatTagnamelist,this@EditTagActivity)
            val itemTouchHelperCallback = ItemTouchHelperCallback(chatTagadapter)
            val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
            itemTouchHelper.attachToRecyclerView(binding.chatTagRecyclerview)
            binding.chatTagRecyclerview.adapter=chatTagadapter
        }
    }


    private fun onClickListener(){

        binding.toolbarView.backArrowIcon.setOnClickListener {
            finish()
        }

        binding.createChatTag.setOnClickListener{
            createChatTagPageLaunch()
        }

        binding.toolbarView.toolbarActionTitleTv.setOnClickListener {

            deleteChatTag()

        }

    }

    private fun deleteChatTag(){

        try{

            ChatManager.deleteChatTag(deleteTagIdList,object: FlyCallback {
                override fun flyResponse(
                    isSuccess: Boolean,
                    throwable: Throwable?,
                    data: HashMap<String, Any>
                ) {

                    if(isSuccess){
                        setResult(Activity.RESULT_OK)
                        finish()
                    }
                }

            })

        }catch(e:Exception){
            LogMessage.e(TAG,e.toString())
        }
    }

    private fun createChatTagPageLaunch(){
        val intent= Intent(mContext,CreateTagActivity::class.java)
        intent.putExtra("tagname",tagName)
        intent.putExtra(com.contusfly.utils.Constants.EDIT_CHAT_TAG_ITEMS,false)
        resultLauncher.launch(intent)
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                getChatTagData()
                setResult(Activity.RESULT_OK)
            }
        }

    private fun chatTagRemoveDialogShow(){

        CommonUtils.chatTagRemoveBottomDialogShow(mContext,object: DialogPositiveButtonClick {

            override fun onItemClickListener(listener: View.OnClickListener) {
                try {
                    deleteTagIdList.add(chatTagId)
                    chatTagadapter.updateList(itemSelectedPosition)
                    GlobalScope.launch(Dispatchers.Main.immediate) {
                        setResult(Activity.RESULT_OK)
                    }
                } catch(e:Exception){
                    LogMessage.e(TAG,e.toString())
                }
            }

        })
    }

    override fun onItemMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(chatTagnamelist, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(chatTagnamelist, i, i - 1)
            }
        }
        for(tagIndex in 0 until chatTagnamelist.size){
            chatTagnamelist[tagIndex].order=tagIndex
        }
        chatTagadapter.notifyItemMoved(fromPosition, toPosition)
        ChatManager.reorderChatTags(chatTagnamelist,object : FlyCallback {
            override fun flyResponse(
                isSuccess: Boolean,
                throwable: Throwable?,
                data: HashMap<String, Any>,
            ) {
                if (isSuccess) {
                    setResult(Activity.RESULT_OK)
                }
            }

        })
    }
}