package com.contusfly.utils

import com.contusfly.getDisplayName
import com.contusfly.interfaces.GetGroupUsersNameCallback
import com.contusfly.isUnknownContact
import com.contusfly.isValidIndex
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import org.jxmpp.util.XmppStringUtils
import java.util.*

object ProfileDetailsUtils {

    /**
     * Sort the profile list by nick name of the profile detail
     *
     * @param profilesList List of profile
     * @return List<ProfileDetails> Sorted profile list
    </ProfileDetails> */
    fun sortProfileList(profilesList: List<ProfileDetails>?): List<ProfileDetails> {
        profilesList?.let {
            return it.sortedBy { profileDetails -> profileDetails.getDisplayName()?.toLowerCase() }
        }
        return listOf()
    }

    /**
     * Returns group users names Separated by comma
     *
     * @param groupJid Group Jid
     * @return String User names Separated by comma
     */
    fun getGroupUsersNames(groupJid: String?, getGroupUsersNameCallback: GetGroupUsersNameCallback) {
        groupJid?.let {
            GroupManager.getGroupMembersList(false, groupJid) { isSuccess, throwable, data ->
                if (isSuccess) {
                    val groupUsers = data[Constants.SDK_DATA] as ArrayList<ProfileDetails>
                    val userNames = mutableListOf<String>()
                    for (user in groupUsers.take(10)) {
                        if (user.jid.equals(SharedPreferenceManager.getCurrentUserJid(), ignoreCase = true))
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
            val index = it.indexOfFirst { it.jid == SharedPreferenceManager.getCurrentUserJid() }
            val user = if (index.isValidIndex())
                it[index]
            else
                getProfileDetails(SharedPreferenceManager.getCurrentUserJid())
            it.remove(user)
            if(it.contains(getProfileDetails(SharedPreferenceManager.getCurrentUserJid())))
                it.remove(getProfileDetails(SharedPreferenceManager.getCurrentUserJid()))
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

    fun getProfileDetails(jid: String) : ProfileDetails? {
        if (XmppStringUtils.parseDomain(jid).isNullOrBlank())
            return null
        val profileDetails = ContactManager.getProfileDetails(jid)
        return when {
            profileDetails == null -> UIKitContactUtils.getProfileDetails(jid) // if it is null then return UIKit contact
            profileDetails.isUnknownContact() -> UIKitContactUtils.getProfileDetails(jid) ?: profileDetails // if it is isUnknownContact then return UIKit contact
            else -> profileDetails
        }
    }

    fun getDisplayName(jid: String?): String {
        if (jid == null)
            return Constants.EMPTY_STRING
        val profileDetails = getProfileDetails(jid)
        return profileDetails?.getDisplayName() ?: jid
    }

    fun addContact(profileDetail: ProfileDetails) {
        val profileDetails = ContactManager.getProfileDetails(profileDetail.jid)
        if (profileDetails == null || profileDetails.isUnknownContact())
            UIKitContactUtils.addUIKitContact(profileDetail)
    }
}