package com.contusfly.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.TAG
import com.contusfly.mediapicker.model.Image
import com.contusfly.models.MediaPreviewModel
import com.contusfly.utils.Constants
import com.contusfly.utils.ProfileDetailsUtils
import com.mirrorflysdk.videocompression.composer.Mp4Composer
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.contacts.ProfileDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject

class MediaPreviewViewModel @Inject
constructor() : ViewModel() {

    val profileDetails: MutableLiveData<ProfileDetails> = MutableLiveData()
    val unsentMessage: MutableLiveData<String> = MutableLiveData()
    val selectedMediaList: MutableLiveData<List<MediaPreviewModel>> =
        MutableLiveData()
    private var selectedImageList: MutableList<MediaPreviewModel> = mutableListOf()

    fun getProfileDetails(jid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            profileDetails.postValue(ProfileDetailsUtils.getProfileDetails(jid))
        }
    }

    fun getUnsentMessage(jid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            unsentMessage.postValue(FlyMessenger.getUnsentMessageOfAJid(jid))
        }
    }

    fun setUnSentMessageForAnUser(jid: String, unsentMessage: String) = FlyMessenger
        .saveUnsentMessage(jid, unsentMessage)

    fun checkVideoSize(selectedImage: Image, destinationFile: File) {
        viewModelScope.launch(Dispatchers.IO) {
            val mp4Listener: Mp4Composer.Listener = object : Mp4Composer.Listener {
                override fun onProgress(progress: Double) {
                    /*Not needed*/
                }

                override fun onCurrentWrittenVideoTime(timeUs: Long) {
                    /*Not needed*/
                }

                override fun onCompressedFile() {
                    /*Not needed*/
                }

                override fun onCompleted() {
                    val source = destinationFile
                    val destination = File(selectedImage.path)
                    var fileInputStream: FileInputStream? = null
                    var fileOutputStream: FileOutputStream? = null
                    try {
                        fileInputStream = FileInputStream(source)
                        fileOutputStream = FileOutputStream(destination)
                        val inChannel = fileInputStream.channel
                        val outChannel = fileOutputStream.channel
                        inChannel.transferTo(0, inChannel.size(), outChannel)
                    } catch (e: IOException) {
                        LogMessage.e(TAG, e.toString())
                    } finally {
                        try {
                            fileInputStream?.close()
                        } catch (e: IOException) {
                            LogMessage.e(TAG, e.toString())
                        }
                        try {
                            fileOutputStream?.close()
                        } catch (e: IOException) {
                            LogMessage.e(TAG, e.toString())
                        }
                        selectedImageList.add(
                            MediaPreviewModel(
                                selectedImage.path,
                                Constants.EMPTY_STRING,
                                Constants.EMPTY_STRING,
                                false
                            )
                        )
                        selectedMediaList.postValue(selectedImageList)
                    }
                }

                override fun onCanceled() {
                    selectedImageList.add(
                        MediaPreviewModel(
                            selectedImage.path,
                            Constants.EMPTY_STRING,
                            Constants.EMPTY_STRING,
                            false
                        ))
                    selectedMediaList.postValue(selectedImageList)
                }

                override fun onFailed(exception: java.lang.Exception?) {
                    selectedImageList.add(
                        MediaPreviewModel(
                            selectedImage.path,
                            Constants.EMPTY_STRING,
                            Constants.EMPTY_STRING,
                            false
                        ))
                    selectedMediaList.postValue(selectedImageList)
                }

            }
            Mp4Composer(selectedImage.path, destinationFile.absolutePath).flipHorizontal(true).setCompress(false)
                .listener(mp4Listener).start()
        }
    }
}