package com.contusfly.activities.parent

import android.content.Intent
import android.os.SystemClock
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycommons.FlyCallback
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.R
import com.contusfly.activities.*
import com.contusfly.fragments.ProfileDialogFragment
import com.contusfly.showToast
import com.contusfly.utils.Constants
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.contacts.ContactManager
import com.contusfly.views.CustomAlertDialog
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.contacts.ProfileDetails

abstract class BaseContactActivity : BaseActivity() {

    protected var multiSelection = false

    /**
     * Store onclick time to avoid double click
     */
    protected var lastClickTime: Long = 0

    protected var selectedUsersJid = ArrayList<String>()

    protected var addParticipants = false
    protected var fromGroupInfo = false

    private var profiledetails:ProfileDetails?=null

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            R.id.action_done -> {
                if (addParticipants) {
                    if (selectedUsersJid.size < 2 && !fromGroupInfo) {
                        showToast("Add at least two contacts")
                    } else {
                        if (!ChatManager.getAvailableFeatures().isGroupChatEnabled){
                            CustomAlertDialog().showFeatureRestrictionAlert(this)
                        } else {
                            val output = Intent().apply {
                                putStringArrayListExtra(Constants.USERS_JID, selectedUsersJid)
                            }
                            setResult(RESULT_OK, output)
                            finish()
                        }
                    }
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    protected fun listItemClicked(profileClicked : Boolean, profile: ProfileDetails) {
        ContactManager.insertProfile(profile)
        ProfileDetailsUtils.addContact(profile)
        ContactManager.getUserProfile(profile.jid, true, false, FlyCallback { _, _, _ ->  })
        if (multiSelection) {
            handleMultiSelection(profile)
        } else {
            if(profileClicked) {
                if (SystemClock.elapsedRealtime() - lastClickTime < 1000)
                    return
                lastClickTime = SystemClock.elapsedRealtime()
                val dialogFragment = ProfileDialogFragment.newInstance(profile)
                val ft = supportFragmentManager.beginTransaction()
                val prev = supportFragmentManager.findFragmentByTag("dialog")
                if (prev != null) {
                    ft.remove(prev)
                }
                ft.addToBackStack(null)
                dialogFragment.show(ft, "dialog")
            } else {
                privateChatUserChecking(profile)
            }
        }
    }

    private fun privateChatUserChecking(profile: ProfileDetails){
        profiledetails=profile
        if(ChatManager.isPrivateChat(profile.jid)){
            launchPinActivity()
        } else {
            launchChatPage(profile)
        }
    }

    private fun launchChatPage(profile: ProfileDetails){
        if(profile!=null){
            startActivity(
                Intent(context, ChatActivity::class.java)
                    .putExtra(LibConstants.JID, profile.jid)
                    .putExtra(Constants.CHAT_TYPE, ChatType.TYPE_CHAT))
        }
    }

    private fun launchPinActivity() {
        if (SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.BIOMETRIC)) {
            val intent = Intent(activity, BiometricActivity::class.java)
            intent.putExtra(com.contusfly.utils.Constants.GO_TO, com.contusfly.utils.Constants.PRIVATE_CHAT_LIST)
            myActivityResultLauncher.launch(intent)
        } else  {
            val intent = Intent(activity, PinActivity::class.java)
            intent.putExtra(com.contusfly.utils.Constants.GO_TO, com.contusfly.utils.Constants.PRIVATE_CHAT_LIST)
            myActivityResultLauncher.launch(intent)
        }

    }

    private var myActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                profiledetails?.let { launchChatPage(it) }
            }
        }


    private fun handleMultiSelection(profile: ProfileDetails) {
        if (profile.isBlocked)
            return
        if (selectedUsersJid.contains(profile.jid)) {
            selectedUsersJid.remove(profile.jid)
        } else {
            selectedUsersJid.add(profile.jid)
        }
        updateSelectedUserCallView(profile.jid)
    }

    abstract fun updateSelectedUserCallView(jid: String? = Constants.EMPTY_STRING)
}