package com.contusfly.call.calllog

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contus.call.CallConstants.CALL_UI
import com.contusfly.TAG
import com.contusfly.getData
import com.contusfly.getParams
import com.mirrorflysdk.flynetwork.ApiCalls
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager
import com.mirrorflysdk.flycall.call.database.model.CallLog
import com.mirrorflysdk.flycommons.*
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycommons.Features
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import kotlinx.coroutines.*
import javax.inject.Inject

class CallLogViewModel @Inject
constructor(private val repository: CallLogRepository, private val apiCalls: ApiCalls) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e(TAG, "Coroutine Exception:  $exception")
    }

    val updatedFeaturesLiveData = MutableLiveData<Features>()

    val filteredCallLogsList = MutableLiveData<List<CallLog>>()

    private var isFetching = false
    private var currentPage = 0
    private var totalPages = 1
    private var fromCallLogScreen = false

    val addLoader = MutableLiveData<Boolean>()
    val removeLoader = MutableLiveData<Boolean>()
    val callList = MutableLiveData<List<CallLog>>()
    val fetchingError = MutableLiveData<Boolean>()
    val clearAllCallLog = MutableLiveData<Boolean>()

    // = = = = = = = = CallLogs Data = = = = = = = =
    val callLogAdapterList: ArrayList<CallLog> by lazy { ArrayList() }
    val selectedCallLogs: ArrayList<String> by lazy { ArrayList() }

    fun setClearAllCallLog() {
        clearAllCallLog.postValue(true)
    }

    val callLog = MutableLiveData<CallLog>()
    fun getCallLog(roomId: String) {
        viewModelScope.launch {
            callLog.value = repository.getCallLog(roomId)
        }
    }

    public fun resetPagination(context: Context) {
        if (com.contusfly.isInternetAvailable(context))
            callLogAdapterList.clear()
        isFetching = false
        currentPage = 0
        totalPages = 1
    }

    fun getCallLogsList(isLoadDataOnMainThread: Boolean) {
        LogMessage.d(TAG, "$CALL_UI getCallLogsList loadOnMain: $isLoadDataOnMainThread")
        if (lastPageFetched())
            return
        addLoader()
        setUserListFetching(true)
        fetchingError.value = false
        viewModelScope.launch(if(isLoadDataOnMainThread) Dispatchers.Main else Dispatchers.IO) {
            currentPage += 1
            CallManager.getCallLogs(currentPage) { isSuccess, throwable, data ->
                if (isSuccess) {
                    val callLogDBList = data.getData() as MutableList<CallLog>
                    LogMessage.d("CALL_LOG", "callLogDBList-----${callLogDBList.size}")
                    totalPages = data.getParams("total_pages") as? Int ?: 0
                    removeLoader.postValue(true)
                    callList.postValue(callLogDBList)
                    LogMessage.d(TAG, "$CALL_UI getCallLogs pageNumber: $currentPage, $totalPages")
                    removeLoader()
                } else {
                    currentPage -= 1
                    viewModelScope.launch(Dispatchers.Main) {
                        removeLoader()
                        fetchingError.value = true
                    }
                    LogMessage.d(TAG, "$CALL_UI getCallLogs failed throwable: $throwable")
                }
                setUserListFetching(false)
            }
        }
    }


    fun getAllCallLogs() {
        viewModelScope.launch(Dispatchers.IO) {
            var callLogList=CallLogManager.getCallLogs()
            callLogAdapterList.clear()
            callList.postValue(callLogList)
        }
    }

    private fun addLoader(){
        if(!getUserListFetching())
         addLoader.postValue(true)
    }

    private fun removeLoader(){
        removeLoader.postValue(true)
    }

    fun addLoaderToTheList(fromCallLog : Boolean = false,context: Context?=null) {
        resetPagination(context!!)
        fromCallLogScreen = fromCallLog
    }

    fun lastPageFetched() = currentPage >= totalPages

    fun isCallLogScreenInitiated() = fromCallLogScreen

    private fun setUserListFetching(isFetching: Boolean) {
        this.isFetching = isFetching
    }

    fun getUserListFetching(): Boolean {
        return isFetching
    }

    fun uploadUnSyncedCallLogs() {
        if (AppUtils.isNetConnected(ChatManager.applicationContext)) {
            LogMessage.v(this@CallLogViewModel.TAG, "$CALL_UI uploadUnSyncedCallLogs working in thread: ${Thread.currentThread().name}")
            viewModelScope.launch {
                try {
                    withContext(Dispatchers.IO) {
                        CallLogManager.uploadUnSyncedCallLogs(apiCalls)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun filterCallLogsList(searchKey: String) {
        viewModelScope.launch(exceptionHandler) { filteredCallLogsList.value = repository.filteredCallLogs(searchKey) }
    }

    fun updateFeatureActions(updateFeatures: Features) {
        updatedFeaturesLiveData.postValue(updateFeatures)
    }
}