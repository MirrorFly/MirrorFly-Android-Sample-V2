package com.contusfly.call.groupcall

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contus.call.CallConstants.CALL_UI
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.TAG
import com.contusfly.hasActiveInternet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GroupCallViewModel: ViewModel() {

    val internetConnectionNotAvailable = MutableLiveData<Boolean>()
    val remoteAudioMuteStatus = MutableLiveData<String>()


    fun checkInternetConnection(){
        viewModelScope.launch(Dispatchers.IO) {
            if (!hasActiveInternet()) {
                withContext(Dispatchers.Main) {
                   internetConnectionNotAvailable.postValue(true)
                }
            }
        }
    }
    /**
     * set mute status text based on remote user mute actions
     * @param userJid id of muted user
     */
    fun setAudioMuteStatus(userJid: String?) {
        if (userJid == null || !CallManager.isCallConnected()) {
            LogMessage.i(TAG, "$CALL_UI Skipping mute UI update, since call is not connected")
            return
        }
        LogMessage.d(TAG, "$CALL_UI setMuteStatus() userJid:${userJid}")

        remoteAudioMuteStatus.postValue(userJid!!)
    }

}