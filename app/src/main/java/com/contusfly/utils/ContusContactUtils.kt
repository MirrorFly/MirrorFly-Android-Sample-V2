package com.contusfly.utils

import android.text.format.DateFormat
import com.mirrorflysdk.flycommons.ContactType
import com.mirrorflysdk.flycommons.FlyUtils
import com.contusfly.emptyStringFE
import com.contusfly.getData
import com.contusfly.TAG
import com.contusfly.database.MirrorFlyDatabase
import com.contusfly.database.model.ContusContact
import com.contusfly.interfaces.ProcessContusContactCallback
import com.contusfly.models.ContusContactList
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import java.util.*
import kotlin.collections.ArrayList

object ContusContactUtils {

    suspend fun processContusContactResponse(
        contusContactList: ContusContactList?,
        processContusContactCallback: ProcessContusContactCallback
    ) {
        if (contusContactList == null) {
            processContusContactCallback.onProcessContusContactCompleted()
            return
        }
        val currentTime = System.currentTimeMillis()
        val calender = Calendar.getInstance(Locale.ENGLISH)
        calender.timeInMillis = currentTime
        val timestamp = DateFormat.format("yyyy-MM-dd HH:mm:ss", calender).toString()
        SharedPreferenceManager.setString(Constants.TIMESTAMP, timestamp)
        val contusBlockedContacts = getBlockedContusContacts()
        val contusBlockedMeContacts = getBlockedMeContusContacts()
        val adminBlockedContacts = getAdminBlockedContusContacts()
        contusContactList.created?.let { created ->
            created.forEach {
                LogMessage.d(TAG, "processContusContactResponse created still processing")
                if (it.isChatUser == 1) {
                    val userJid = FlyUtils.getJid(it.username ?: Constants.EMPTY_STRING)
                    val isBlockedUser = contusBlockedContacts.any { profile -> profile.jid == userJid }
                    val isUserBlockedMe = contusBlockedMeContacts.any { profile -> profile.jid == userJid }
                    val isAdminBlocked = adminBlockedContacts.any { profile -> profile.jid == userJid }
                    LogMessage.e(TAG, "$userJid == blocked => $isBlockedUser == blocked me => $isUserBlockedMe")
                    MirrorFlyDatabase.getInstance().contusContactDao().insertContusContact(
                        ContusContact(
                            userJid,
                            it.name,
                            it.image,
                            it.username,
                            it.statusMsg,
                            it.email,
                            false,
                            isBlockedUser,
                            isUserBlockedMe,
                            isAdminBlocked
                        )
                    )
                }
            }
        }

        contusContactList.updated?.let { updated ->
            updated.forEach {
                LogMessage.d(TAG, "processContusContactResponse updated still processing")
                if (it.isChatUser == 1) {
                    MirrorFlyDatabase.getInstance().contusContactDao().insertContusContact(
                        ContusContact(
                            FlyUtils.getJid(it.username ?: Constants.EMPTY_STRING),
                            it.name,
                            it.image,
                            it.username,
                            it.statusMsg,
                            it.email,
                            false,
                            isBlocked = false,
                            isBlockedMe = false,
                            isAdminBlocked = false
                        )
                    )
                } else {
                    MirrorFlyDatabase.getInstance().contusContactDao()
                        .deleteContusContact(FlyUtils.getJid(it.username ?: Constants.EMPTY_STRING))
                }
            }
        }

        contusContactList.deleted?.let { deleted ->
            deleted.forEach {
                LogMessage.d(TAG, "processContusContactResponse deleted still processing")
                MirrorFlyDatabase.getInstance().contusContactDao()
                    .deleteContusContact(FlyUtils.getJid(it.username ?: Constants.EMPTY_STRING))
            }
        }
        processContusContactCallback.onProcessContusContactCompleted()
    }

    suspend fun getContusContacts(): ArrayList<ProfileDetails> {
        val profilesList = ArrayList<ProfileDetails>()
        MirrorFlyDatabase.getInstance().contusContactDao().getAllContusContact()
            ?.forEach { contusContact ->
                getUserProfile(contusContact).let {
                    profilesList.add(it)
                }
            }

        return profilesList
    }

    fun getBlockedContusContacts(): ArrayList<ProfileDetails> {
        val profilesList = ArrayList<ProfileDetails>()
        MirrorFlyDatabase.getInstance().contusContactDao().getBlockedContusContactS()
            ?.forEach { contusContact ->
                getUserProfile(contusContact).let {
                    profilesList.add(it)
                }
            }
        return profilesList
    }

    private fun getBlockedMeContusContacts(): ArrayList<ProfileDetails> {
        val profilesList = ArrayList<ProfileDetails>()
        MirrorFlyDatabase.getInstance().contusContactDao().getBlockedMeContusContactS()
            ?.forEach { contusContact ->
                getUserProfile(contusContact).let {
                    profilesList.add(it)
                }
            }
        return profilesList
    }

    fun getAdminBlockedContusContacts(): ArrayList<ProfileDetails> {
        val profilesList = ArrayList<ProfileDetails>()
        MirrorFlyDatabase.getInstance().contusContactDao().getAdminBlockedContusContactS()
            ?.forEach { contusContact ->
                getUserProfile(contusContact).let {
                    profilesList.add(it)
                }
            }
        return profilesList
    }

    fun resetBlockedContacts() {
        val contusContacts = getBlockedContusContacts()
        if (contusContacts.isNotEmpty()) {
            for (contact in contusContacts) {
                contact.isBlocked = false
                insertContusContact(contact)
            }
        }
    }

    fun refreshContusContact(jid: String){
        ContactManager.getUserProfile(jid, true) { isSuccess, _, data ->
            if (isSuccess && data.getData() is ProfileDetails) {
                val userProfileDetails = data.getData() as ProfileDetails
                insertContusContact(userProfileDetails)
            }
        }
    }

    fun insertContusContact(userProfileDetails: ProfileDetails) {
        val contusContact = MirrorFlyDatabase.getInstance().contusContactDao().getContusContact(userProfileDetails.jid)
        contusContact?.let {
            MirrorFlyDatabase.getInstance().contusContactDao().insertContusContactAsSingle(
                ContusContact(
                    userProfileDetails.jid,
                    contusContact.name,
                    if (userProfileDetails.image.isNullOrEmpty()) contusContact.image else userProfileDetails.image,
                    contusContact.mobileNumber,
                    if (userProfileDetails.status.isNullOrEmpty()) contusContact.status else userProfileDetails.status,
                    contusContact.email,
                    userProfileDetails.isMuted,
                    userProfileDetails.isBlocked,
                    userProfileDetails.isBlockedMe,
                    userProfileDetails.isAdminBlocked
                )
            )
        }
    }

    fun getProfileDetails(jid: String): ProfileDetails? {
        val profileDetails:ProfileDetails?=null
        try{
            val contusContact = MirrorFlyDatabase.getInstance().contusContactDao().getContusContact(jid)
            return if (contusContact == null)
                null
            else
                getUserProfile(contusContact)
        }catch(e:NullPointerException){
            LogMessage.e(TAG,e.toString())
        }catch(e:Exception){
            LogMessage.e(TAG,e.toString())
        }
        return profileDetails
    }

    fun getUserProfile(contact: ContusContact): ProfileDetails {
        val profileDetails = ProfileDetails()
        profileDetails.jid = contact.jid
        profileDetails.image = contact.image
        profileDetails.imagePrivacyFlag = emptyStringFE()
        profileDetails.nickName = contact.name
        profileDetails.name = contact.name
        profileDetails.email = contact.email
        profileDetails.status = contact.status
        profileDetails.lastSeenPrivacyFlag = emptyStringFE()
        profileDetails.mobileNumber = contact.mobileNumber
        profileDetails.mobileNUmberPrivacyFlag = emptyStringFE()
        profileDetails.isMuted = contact.isMuted ?: false
        profileDetails.isBlocked = contact.isBlocked ?: false
        profileDetails.isBlockedMe = contact.isBlockedMe ?: false
        profileDetails.isAdminBlocked = contact.isAdminBlocked ?: false
        profileDetails.isGroupProfile = false
        profileDetails.contactType = ContactType.LIVE_CONTACT
        profileDetails.groupCreatedTime = emptyStringFE()
        profileDetails.isGroupInOfflineMode =
            true //Set true, Mirror fly to identify it is email contact
        return profileDetails
    }

    fun isContusContact(jid: String?): Boolean {
        if (jid == null)
            return false
        return MirrorFlyDatabase.getInstance().contusContactDao().isContusContact(jid) > 0
    }

    fun clearAllData() {
        MirrorFlyDatabase.getInstance().contusContactDao().deleteAllContusContacts()
    }
}