package com.contusfly.utils

import com.contusfly.BuildConfig
import com.contusfly.TAG
import com.contusfly.getDisplayName
import com.contusfly.interfaces.GetGroupUsersNameCallback
import com.contusfly.isUnknownContact
import com.contusfly.isValidIndex
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import org.jxmpp.util.XmppStringUtils
import com.mirrorflysdk.flycommons.SharedPreferenceManager
import com.mirrorflysdk.utils.Utils
import java.util.*

object ProfileDetailsUtils {

    /**
     * Sort the profile list by nick name of the profile detail
     *
     * @param profilesList List of profile
     * @return List<ProfileDetails> Sorted profile list
    </ProfileDetails> */
    fun sortProfileList(profilesList: List<ProfileDetails>?): List<ProfileDetails> {
        LogMessage.i(TAG, "#NewContacts sortProfileList profileDetails: ${profilesList?.size}")
        profilesList?.let {
            return it.sortedBy { profileDetails -> profileDetails.getDisplayName()?.lowercase() }
        }
        return profilesList?:listOf()
    }

    /**
     * Returns group users names Separated by comma
     *
     * @param groupJid Group Jid
     * @return String User names Separated by comma
     */
    fun getGroupUsersNames(groupJid: String?, getGroupUsersNameCallback: GetGroupUsersNameCallback) {
        groupJid?.let {
            GroupManager.getGroupMembersList(false, groupJid) { isSuccess, _, data ->
                if (isSuccess) {
                    val groupUsers = data[Constants.SDK_DATA] as ArrayList<ProfileDetails>
                    val userNames = mutableListOf<String>()
                    for (user in groupUsers.take(10)) {
                        if (user.jid.equals(SharedPreferenceManager.instance.currentUserJid, ignoreCase = true))
                            userNames.add("You")
                        else
                            userNames.add(user.getDisplayName())
                    }
                    Collections.sort(userNames, String.CASE_INSENSITIVE_ORDER)
                    getGroupUsersNameCallback.onGroupUsersNamePrepared(userNames.joinToString(","))
                }
            }
        }
    }



    /**
     * Sort the group user profile list by nick name of the profile detail
     * and move current user to last in the list
     *
     * @param profilesList List of profile
     * @return List<ProfileDetails> Sorted profile list
    </Roster> */
    @JvmStatic
    fun sortGroupProfileList(profilesList: MutableList<ProfileDetails>?): MutableList<ProfileDetails> {
        profilesList?.let {
            val index = it.indexOfFirst { it.jid == SharedPreferenceManager.instance.currentUserJid }
            val user = if (index.isValidIndex())
                it[index]
            else
                getProfileDetails(SharedPreferenceManager.instance.currentUserJid)
            it.remove(user)
            if(it.contains(getProfileDetails(SharedPreferenceManager.instance.currentUserJid)))
                it.remove(getProfileDetails(SharedPreferenceManager.instance.currentUserJid))
            val sortedList = it.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER, { it.getDisplayName() })).toMutableList()
            if(index>=0) {
                user?.nickName = AppConstants.YOU
                user?.name  = AppConstants.YOU
                user?.let { sortedList.add(user) }
            }
            return sortedList
        }
        return mutableListOf()
    }


    fun removeAdminBlockedProfiles(profileDetails: List<ProfileDetails>, sortProfiles: Boolean): List<ProfileDetails> {
        return if (sortProfiles)
            sortProfileList(profileDetails.filter { !it.isAdminBlocked })
        else
            profileDetails.filter { !it.isAdminBlocked }
    }

    fun getProfileDetails(jid: String, isUnknownContact: Boolean = false) : ProfileDetails? {
        if (XmppStringUtils.parseDomain(jid).isNullOrBlank())
            return null
        if (BuildConfig.CONTACT_SYNC_ENABLED) {
            return getContactSyncProfileDetails(jid, isUnknownContact)
        } else {
            val profileDetails = ContactManager.getProfileDetails(jid)
            return when {
                profileDetails == null -> UIKitContactUtils.getProfileDetails(jid) // if it is null then return UIKit contact
                profileDetails.isUnknownContact() -> UIKitContactUtils.getProfileDetails(jid) ?: profileDetails // if it is isUnknownContact then return UIKit contact
                else -> profileDetails
            }
        }
    }

    private fun getContactSyncProfileDetails(
        jid: String,
        isUnknownContact: Boolean
    ): ProfileDetails? {
        return if (isUnknownContact) // if it is isUnknownContact then first check contus contact
            ContusContactUtils.getProfileDetails(jid) ?: FlyCore.getUserProfile(jid)
        else {
            var profileDetails: ProfileDetails? = null
            try{
                if(!jid.isNullOrEmpty())
                    profileDetails = ContactManager.getProfileDetails(jid)
                when {
                    profileDetails == null -> ContusContactUtils.getProfileDetails(jid) // if it is isUnknownContact then first check contus contact
                    profileDetails.isUnknownContact() -> ContusContactUtils.getProfileDetails(jid) ?: profileDetails // if it is isUnknownContact then first check contus contact
                    else -> profileDetails
                }
            }catch(e:NullPointerException){

                LogMessage.e(TAG,e.toString())

            }catch(e:Exception){

                LogMessage.e(TAG,e.toString())
            }

            profileDetails
        }
    }

    fun getDisplayName(jid: String?): String {
        if (jid == null)
            return Constants.EMPTY_STRING
        return getProfileDetails(jid)?.getDisplayName() ?: jid
    }

    fun addContact(profileDetail: ProfileDetails) {
        val profileDetails = ContactManager.getProfileDetails(profileDetail.jid)
        if (profileDetails == null || profileDetails.isUnknownContact())
            UIKitContactUtils.addUIKitContact(profileDetail)
    }

    @JvmStatic
    fun sortGroupProfileListWithoutOwn(profilesList: MutableList<ProfileDetails>?): MutableList<ProfileDetails> {
        profilesList?.let {
            val index =
                it.indexOfFirst { it.jid == com.mirrorflysdk.flycommons.SharedPreferenceManager.instance.currentUserJid }
            val user = if (index.isValidIndex())
                it[index]
            else
                getProfileDetails(com.mirrorflysdk.flycommons.SharedPreferenceManager.instance.currentUserJid)
            it.remove(user)
            if (it.contains(getProfileDetails(SharedPreferenceManager.instance.currentUserJid)))
                it.remove(getProfileDetails(SharedPreferenceManager.instance.currentUserJid))
            return getSortedGroupProfileList(it)
        }
        return mutableListOf()
    }
    private fun getSortedGroupProfileList(profilesList: MutableList<ProfileDetails>): MutableList<ProfileDetails> {
        val sortedList =
            profilesList.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER, { it.nickName }))
                .toMutableList()
        //Sorting the Phone book and Email contacts based on the name
        val nameWithJidHashMap = HashMap<String, String>()
        for (profileDetail in sortedList) {
            val profile =
                if (!profileDetail.jid.equals(SharedPreferenceManager.instance.currentUserJid) && profileDetail.isUnknownContact())
                    getProfileDetails(profileDetail.jid) ?: profileDetail
                else profileDetail
            if (!profile.jid.equals(SharedPreferenceManager.instance.currentUserJid) && profile.isUnknownContact())
                Utils.getFormattedPhoneNumber(ChatUtils.getUserFromJid(profile.jid))
            else
                Utils.returnEmptyStringIfNull(profile.nickName)
            nameWithJidHashMap[profileDetail.mobileNumber] = profileDetail.jid
        }
        // TreeMap to store values of HashMap
        val sortedMap: MutableMap<String, String> = TreeMap(nameWithJidHashMap)
        val groupsMembersProfileList: MutableList<ProfileDetails> = mutableListOf()
        for (jid in sortedMap.values) {
            for (profile in sortedList) {
                if (jid == profile.jid) {
                    groupsMembersProfileList.add(profile)
                }
            }
        }
        return groupsMembersProfileList
    }
}