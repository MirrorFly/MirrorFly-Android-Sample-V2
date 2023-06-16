package com.contusfly.mediapicker.viewmodel

import android.content.Context
import android.content.Intent
import android.content.pm.ResolveInfo
import android.database.Cursor
import android.os.Environment
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.webkit.MimeTypeMap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import androidx.paging.PagingConfig.Companion.MAX_SIZE_UNBOUNDED
import com.contusfly.mediapicker.`interface`.MediaFolderType
import com.contusfly.mediapicker.helper.ImagePickerUtils
import com.contusfly.mediapicker.model.CategorizedMedia
import com.contusfly.mediapicker.model.FolderDetail
import com.contusfly.mediapicker.model.Image
import com.contusfly.mediapicker.utils.PickerConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.io.File
import java.text.DateFormatSymbols
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class MediaViewModel : ViewModel() {

    val imageFolderListAdapter: ArrayList<FolderDetail> by lazy { ArrayList() }
    val isImageListLoaded = MutableLiveData<Boolean>()

    val pickerApplications: MutableLiveData<MutableList<String>> = MutableLiveData()

    val selectedPhotoMediaList = hashMapOf<Image, Int>()

    val selectedMediaList = arrayListOf<Image>()

    val deletedPhotoMediaList: MutableLiveData<HashMap<Image, Int>> = MutableLiveData()

    val isMultiSelectEnable: MutableLiveData<Boolean> = MutableLiveData()

    val isMaximumSelected: MutableLiveData<Boolean> = MutableLiveData()

    val isItemSelected: MutableLiveData<Image> = MutableLiveData()

    val itemSelectedPosition: MutableLiveData<Int> = MutableLiveData()

    val folderMediaList :MutableList<Image> = mutableListOf()

    var singleItemSelectedPosition = -1

    val isItemMultiSelected: MutableLiveData<Boolean> = MutableLiveData()

    val isItemSizeNotPermitted: MutableLiveData<Boolean> = MutableLiveData()

    val isItemExtensionNotPermitted: MutableLiveData<Boolean> = MutableLiveData()

    var supportedFormats = listOf(*PickerConstants.supportedFormats)

    var canImageShow = true
    var canVideoShow = true

    fun getImageBuckets(mContext: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val uri = MediaStore.Files.getContentUri("external")
            val projection = getProjection()
            // Return only video and image metadata.
            val selection = getSelection()
            val order = getOrder()
            val cursor: Cursor? =
                mContext.contentResolver.query(uri, projection, selection, null, order)
            var path = ""
            var bucketPath: String? = null
            var bucketCompletePath: String
            var bucketCameraPath = ""
            var mimeType: String?
            var imageDate: Long
            var imageDetail: Image
            val cameraPathName =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
                    .toString() + "/Camera"

            val folderMap: MutableMap<String, FolderDetail> = mutableMapOf()
            val allMedias: MutableList<Image> = mutableListOf()
            val allVideos: MutableList<Image> = mutableListOf()

            if (cursor != null) {
                val allMedia = FolderDetail("All media", path, 0, MediaFolderType.ALL_MEDIA)
                val allVideo = FolderDetail("All videos", path, 0, MediaFolderType.ALL_VIDEO)

                if (cursor.moveToLast()) {
                    do {
                        bucketPath = cursor.getString(0)
                        path = cursor.getString(1)
                        mimeType = cursor.getString(2)
                        imageDate = cursor.getLong(3)
                        if (bucketPath == null) {
                            val parent = File(path).parentFile
                            bucketPath = if (parent != null) {
                                parent.name
                            } else {
                                PickerConstants.EMPTY_STRING
                            }
                        }

                        imageDetail = Image(0, path, imageDate, false)
                        allMedias.add(imageDetail)

                        if (bucketPath != null) {
                            bucketCompletePath = path.substringBeforeLast("/")
                            var folder = folderMap[bucketCompletePath]
                            if (folder == null) {
                                if (path.contains(cameraPathName, true)) {
                                    bucketCameraPath = bucketCompletePath
                                    folder =
                                        FolderDetail(bucketPath, path, 0, MediaFolderType.CAMERA)
                                    folderMap[bucketCompletePath] = folder
                                } else {
                                    folder =
                                        FolderDetail(bucketPath, path, 0, MediaFolderType.FOLDER)
                                    folderMap[bucketCompletePath] = folder
                                }
                            }
                            folder.images.add(imageDetail)

                            if (mimeType != null && mimeType.contains("video", true)) {
                                imageDetail.isVideo = true
                                allVideos.add(imageDetail)
                            }
                        }
                    } while (cursor.moveToPrevious())
                    cursor.close()
                    if (allMedias.isNotEmpty()) { // Check and Add top 3 folders has data then add at top
                        allMedia.images.addAll(allMedias)
                        allMedia.firstImagePath = allMedias[0].path
                        imageFolderListAdapter.add(allMedia)
                        if (allVideos.isNotEmpty()) {
                            allVideo.images.addAll(allVideos)
                            allVideo.firstImagePath = allVideos[0].path
                            imageFolderListAdapter.add(allVideo)
                        }
                        if (bucketCameraPath.isNotBlank()) {
                            val cameraMedia = folderMap[bucketCameraPath]
                            folderMap.remove(bucketCameraPath)
                            imageFolderListAdapter.add(0, cameraMedia!!)
                        }
                    }
                    imageFolderListAdapter.addAll(folderMap.values)
                }
            }
            viewModelScope.launch {
                isImageListLoaded.postValue(true)
            }
            categorizeImages(allMedias)
        }
    }

    fun getImagesInFolder(mContext: Context, folderName: String, image: Image) {
        viewModelScope.launch(Dispatchers.IO) {
            val uri = MediaStore.Files.getContentUri("external")
            val projection = getProjection()
            // Return only video and image metadata.
            val selection = getSelection()
            val order = getOrder()
            val cursor: Cursor? =
                mContext.contentResolver.query(uri, projection, selection, null, order)
            var path = ""
            var mimeType: String?
            var imageDate: Long
            var imageDetail: Image


            if (cursor != null) {
                val currentFolder = image.path.substring(0, image.path.lastIndexOf("/"))
                if (cursor.moveToLast()) {
                    do {
                        path = cursor.getString(1)
                        mimeType = cursor.getString(2)
                        imageDate = cursor.getLong(3)
                        imageDetail = Image(0, path, imageDate, false)
                        imageDetail.isVideo = mimeType != null && mimeType.contains("video", true)
                        if (folderName == "All videos") {
                            folderMediaList.add(imageDetail)
                        } else if (folderName == "All media" || path.substring(0, path.lastIndexOf("/")) == currentFolder) {
                            folderMediaList.add(imageDetail)
                        }
                    } while (cursor.moveToPrevious())
                }
                cursor.close()
            }
            categorizeImages(folderMediaList)
            viewModelScope.launch {
                isImageListLoaded.postValue(true)
            }

        }
    }

    fun getMediaPickerApps(mContext: Context) {
        val applications = mutableListOf<String>()
        val pickerListIntent = Intent(Intent.ACTION_PICK)
        pickerListIntent.type = "video/*, image/*"
        val pickerApps: List<ResolveInfo> =
            mContext.packageManager.queryIntentActivities(pickerListIntent, 0)
        if (pickerApps.isNotEmpty()) {
            for (app in pickerApps) {
                applications.add(app.activityInfo.packageName.toLowerCase(Locale.getDefault()))
            }
        }
        pickerApplications.postValue(applications)
    }

    fun enableMultiSelect(isEnable: Boolean) {
        isMultiSelectEnable.postValue(isEnable)
    }

    val mediaList: MutableLiveData<MutableList<String>> = MutableLiveData()

    fun clearSelectedItems() {
        selectedPhotoMediaList.clear()
        selectedMediaList.clear()
    }

    fun itemClicked(imageDetail: Image, position: Int) {
        if (isMultiSelectEnable.value != null && isMultiSelectEnable.value!!) {
            when {
                selectedPhotoMediaList.contains(imageDetail) -> {
                    selectedPhotoMediaList.remove(imageDetail)
                    selectedMediaList.remove(imageDetail)
                    isItemMultiSelected.postValue(true)
                }
                selectedPhotoMediaList.size < ImagePickerUtils.maxFileRestriction -> {
                    val file = File(imageDetail.path)
                    val fileSize = getFileSizeInMb(file)
                    if (fileSize == 0f || !supportedFormats.contains(getExtension(imageDetail.path))) {
                        isItemExtensionNotPermitted.postValue(true)
                        return
                    }
                    if (fileSize < if (imageDetail.isVideo) ImagePickerUtils.maxVideoFileSizeRestriction else ImagePickerUtils.maxImageFileSizeRestriction) {
                        selectedPhotoMediaList[imageDetail] = position
                        selectedMediaList.add(imageDetail)
                        Log.d("selectedImages", "selectedImages selection path:${imageDetail.path}")
                        isItemMultiSelected.postValue(true)
                    } else {
                        isItemSizeNotPermitted.postValue(imageDetail.isVideo)
                    }
                }
                else -> isMaximumSelected.postValue(true)
            }
        } else {
            val file = File(imageDetail.path)
            val fileSize = getFileSizeInMb(file)
            if (fileSize == 0f || !supportedFormats.contains(getExtension(imageDetail.path))) {
                isItemExtensionNotPermitted.postValue(true)
                return
            }
            if (fileSize < if (imageDetail.isVideo) ImagePickerUtils.maxVideoFileSizeRestriction else ImagePickerUtils.maxImageFileSizeRestriction) {
                singleItemSelectedPosition = position
                isItemSelected.postValue(imageDetail)
            } else {
                isItemSizeNotPermitted.postValue(imageDetail.isVideo)
            }
        }
    }

    private fun getExtension(path: String): String {
        val extension = MimeTypeMap.getFileExtensionFromUrl(path)
        if (!TextUtils.isEmpty(extension)) {
            return extension.toLowerCase(Locale.getDefault())
        }
        return if (path.contains(".")) {
            path.substring(path.lastIndexOf(".") + 1, path.length).toLowerCase(Locale.getDefault())
        } else {
            ""
        }
    }

    fun getFileSizeInMb(file: File): Float {
        val fileSizeInBytes = file.length()
        val fileSizeInKB = fileSizeInBytes / 1024f
        return fileSizeInKB / 1024f
    }

    fun itemLongClicked(imageDetail: Image, position: Int) {
        val file = File(imageDetail.path)
        val fileSize = getFileSizeInMb(file)
        if (fileSize == 0f || !supportedFormats.contains(getExtension(imageDetail.path))) {
            isItemExtensionNotPermitted.postValue(true)
            return
        }
        if (fileSize < if (imageDetail.isVideo) ImagePickerUtils.maxVideoFileSizeRestriction else ImagePickerUtils.maxImageFileSizeRestriction) {
            if (selectedPhotoMediaList.contains(imageDetail)) {
                selectedPhotoMediaList.remove(imageDetail)
                selectedMediaList.remove(imageDetail)
            } else {
                selectedPhotoMediaList[imageDetail] = position
                selectedMediaList.add(imageDetail)
                Log.d("selectedImages", "selectedImages selection path:${imageDetail.path}")
            }
            isMultiSelectEnable.postValue(true)
        } else {
            isItemSizeNotPermitted.postValue(imageDetail.isVideo)
        }
    }

    fun categorizeImages(imageItems: MutableList<Image>) {
        viewModelScope.launch(Dispatchers.IO) {
            val calendarInstance = Calendar.getInstance()
            val currentYear = calendarInstance[Calendar.YEAR]
            val currentMonth = calendarInstance[Calendar.MONTH]
            val currentDay = calendarInstance[Calendar.DAY_OF_MONTH]
            val calendar: Calendar = GregorianCalendar()
            val dateSymbols = DateFormatSymbols().months
            var year: Int
            var month: Int
            var day: Int
            imageItems.forEach {
                val date = Date(it.imageDate * 1000)
                calendar.time = date
                year = calendar[Calendar.YEAR]
                month = calendar[Calendar.MONTH]
                day = calendar[Calendar.DAY_OF_MONTH]

                val category =
                    getCategoryName(
                        dateSymbols,
                        currentDay,
                        currentMonth,
                        currentYear,
                        day,
                        month,
                        year
                    )
                it.id = category.first
                it.categoryName = category.second
                Log.d(
                    "groupImages",
                    "groupImages: categoryId:${category.first} categoryName:${category.second}"
                )
            }
        }
    }

    private fun getCategoryName(
        dateSymbols: Array<String>,
        currentDay: Int,
        currentMonth: Int,
        currentYear: Int,
        day: Int,
        month: Int,
        year: Int
    ): Pair<Int, String> {
        return when {
            (currentYear - year) == 1 -> {
                if (currentMonth < month) {
                    Pair(4, dateSymbols[month])
                } else {
                    Pair(5, year.toString())
                }
            }
            currentYear > year -> {
                Pair(5, year.toString())
            }
            (currentMonth - month) == 1 -> {
                if (day > currentDay)
                    Pair(3, "Last Month")
                else
                    Pair(4, dateSymbols[month])
            }
            currentMonth > month -> Pair(4, dateSymbols[month])
            (currentDay - day) > 7 -> {
                Pair(2, "Last Month")
            }
            (currentDay - day) > 2 -> {
                Pair(1, "Last Week")
            }
            else -> Pair(0, "Recent")
        }
    }

    fun getMediaGroupedListData(imageItems: MutableList<Image>): Flow<PagingData<CategorizedMedia>> {
        return Pager(
            PagingConfig(
                pageSize = 20,
                enablePlaceholders = false,
                maxSize = if (imageItems.size > 80) imageItems.size else MAX_SIZE_UNBOUNDED
            )
        ) {
            ImagePagingDataSource(imageItems)
        }.flow.cachedIn(viewModelScope)
    }

    fun addRemainingList(remainingList: java.util.ArrayList<Image>) {
        val deletedList = hashMapOf<Image, Int>()
        val addedList = hashMapOf<Image, Int>()

        selectedPhotoMediaList.keys.forEach { image ->
            if (remainingList.any { it.path == image.path })
                addedList[image] = selectedPhotoMediaList[image]!!
            else
                deletedList[image] = selectedPhotoMediaList[image]!!
        }

        selectedPhotoMediaList.clear()
        selectedMediaList.clear()

        if (isMultiSelectEnable.value == null || !isMultiSelectEnable.value!!) {
            addedList[isItemSelected.value!!] = singleItemSelectedPosition
        }
        selectedPhotoMediaList.putAll(addedList)
        selectedMediaList.addAll(addedList.keys)
        itemSelectedPosition.postValue(singleItemSelectedPosition)
        singleItemSelectedPosition = -1
        isMultiSelectEnable.postValue(true)
        isItemMultiSelected.postValue(true)
        deletedPhotoMediaList.postValue(deletedList)
    }

    private fun getOrder(): String {
        return if (canImageShow)
            MediaStore.Images.ImageColumns.DATE_MODIFIED
        else
            MediaStore.Video.VideoColumns.DATE_MODIFIED
    }

    private fun getProjection(): Array<String> {
        return if (canImageShow) {
            arrayOf(
                MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                MediaStore.Images.ImageColumns.DATA,
                MediaStore.Images.ImageColumns.MIME_TYPE,
                MediaStore.Images.ImageColumns.DATE_MODIFIED
            )
        } else {
            arrayOf(
                MediaStore.Video.VideoColumns.BUCKET_DISPLAY_NAME,
                MediaStore.Video.VideoColumns.DATA,
                MediaStore.Video.VideoColumns.MIME_TYPE,
                MediaStore.Video.VideoColumns.DATE_MODIFIED
            )
        }
    }

    private fun getSelection(): String {
        return if (canImageShow && canVideoShow) {
            (MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                    + MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE
                    + " OR "
                    + MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                    + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO)
        } else if (canImageShow) {
            (MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                    + MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE)
        } else {
            (MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                    + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO)
        }
    }

    fun setPreCondition(canImageShow: Boolean, canVideoShow: Boolean) {
        this.canImageShow = canImageShow
        this.canVideoShow = canVideoShow
    }
}