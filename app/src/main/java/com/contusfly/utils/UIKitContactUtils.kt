package com.contusfly.utils

import com.mirrorflysdk.flycommons.ContactType
import com.contusfly.database.UIKitDatabase
import com.contusfly.database.model.ContactModel
import com.contusfly.emptyStringFE
import com.mirrorflysdk.api.contacts.ProfileDetails
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

object UIKitContactUtils : CoroutineScope {

    fun getProfileDetails(jid: String): ProfileDetails? {
        val contactModel = UIKitDatabase.getInstance().contactDao().getContact(jid)
        return if (contactModel == null)
            null
        else
            getUserProfile(contactModel)
    }

    fun getUserProfile(contact: ContactModel): ProfileDetails {
        val profileDetails = ProfileDetails()
        profileDetails.jid = contact.jid
        profileDetails.image = contact.image ?: emptyStringFE()
        profileDetails.imagePrivacyFlag = emptyStringFE()
        profileDetails.nickName = contact.name ?: emptyStringFE()
        profileDetails.name = contact.name ?: emptyStringFE()
        profileDetails.email = contact.email ?: emptyStringFE()
        profileDetails.status = contact.status ?: emptyStringFE()
        profileDetails.lastSeenPrivacyFlag = emptyStringFE()
        profileDetails.mobileNumber = contact.mobileNumber ?: emptyStringFE()
        profileDetails.mobileNUmberPrivacyFlag = emptyStringFE()
        profileDetails.isMuted = contact.isMuted ?: false
        profileDetails.isBlocked = contact.isBlocked ?: false
        profileDetails.isBlockedMe = contact.isBlockedMe ?: false
        profileDetails.isAdminBlocked = contact.isAdminBlocked ?: false
        profileDetails.isGroupProfile = false
        profileDetails.contactType = ContactType.LIVE_CONTACT
        profileDetails.groupCreatedTime = emptyStringFE()
        profileDetails.isGroupInOfflineMode = false
        return profileDetails
    }

    fun addUIKitContact(profileDetails: ProfileDetails) {
        launch(exceptionHandler) {
            val existingProfileDetails = getProfileDetails(profileDetails.jid)
            val contactModel = ContactModel(
                profileDetails.jid,
                profileDetails.name,
                profileDetails.image,
                profileDetails.mobileNumber,
                profileDetails.status,
                profileDetails.email,
                profileDetails.isMuted,
                profileDetails.isBlocked,
                profileDetails.isBlockedMe,
                profileDetails.isAdminBlocked
            )
            if (existingProfileDetails != null) {
                contactModel.isMuted = existingProfileDetails.isMuted
                contactModel.isBlocked = existingProfileDetails.isBlocked
                contactModel.isBlockedMe = existingProfileDetails.isBlockedMe
                contactModel.isAdminBlocked = existingProfileDetails.isAdminBlocked
            }
            UIKitDatabase.getInstance().contactDao().insertContact(contactModel)
        }
    }

    fun clearAllData(){
        UIKitDatabase.getInstance().contactDao().deleteAllContacts()
    }

    /*
     * This method is used to check and update the Contacts Block/UnBlock Status
     */
    fun checkContactForBlockAndUnblockUser(jid: String, status: Boolean) {
        launch(exceptionHandler) {
            val contactModel = UIKitDatabase.getInstance().contactDao().getContact(jid)
            if (contactModel != null) {
                contactModel.isBlocked = status
                UIKitDatabase.getInstance().contactDao().insertContact(contactModel)
            }
        }
    }

    fun updateBlockedStatusOfUser(jidList: List<String>) {
        launch(exceptionHandler) {
            resetBlockedContacts()
            for (jid in jidList) {
                checkContactForBlockAndUnblockUser(jid, true)
            }
        }
    }

    private suspend fun resetBlockedContacts() {
        UIKitDatabase.getInstance().contactDao().getBlockedMeContacts()
            ?.forEach { contactModel ->
                contactModel.isBlocked = false
                UIKitDatabase.getInstance().contactDao().insertContact(contactModel)
            }
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine Exception :  ${exception.printStackTrace()}")
    }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()
}