package com.contusfly.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.contusfly.getDisplayName
import com.contusfly.utils.*
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.flycommons.SingleLiveEvent
import javax.inject.Inject

class MentionsViewModel @Inject
constructor() : ViewModel() {


    private val selectedRecipient: SingleLiveEvent<ProfileDetails> = SingleLiveEvent()
    private lateinit var toUserJid: String
    var groupUsers=MutableLiveData<List< ProfileDetails>>()


    fun setUserJid(jid: String) {
        toUserJid = jid
    }


    fun getParticipantsHashMap(jid: String) {
        GroupManager.getGroupMembersList(false, jid) { isSuccess, _, data ->
            if (isSuccess) {
                var participantsNameList: List<ProfileDetails>
                var groupsMembersProfileList: MutableList<ProfileDetails> = data[Constants.SDK_DATA] as MutableList<ProfileDetails>
                participantsNameList =ProfileDetailsUtils.sortGroupProfileListWithoutOwn(groupsMembersProfileList)
                var newParticipantList=ArrayList<ProfileDetails>()
                for (i in participantsNameList) {
                    if (!i.isAdminBlocked) {
                        newParticipantList.add(i)
                    }
                }
                participantsNameList.clear()
                participantsNameList.addAll(newParticipantList)
                participantsNameList.let {
                    val list =   it.sortedBy { profileDetails -> profileDetails.getDisplayName().lowercase()}
                    groupUsers.value = list
                }
            }
        }
    }

    fun onSelectionChange(profileDetails: ProfileDetails) {
        selectedRecipient.value = profileDetails

    }
    fun getSelectedRecipient(): LiveData<ProfileDetails> {
        return selectedRecipient
    }

    companion object{
        private const val TAG = "MentionViewModel"
    }

}