package com.contusfly.mediapicker.viewmodel

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.contusfly.mediapicker.model.CategorizedMedia
import com.contusfly.mediapicker.model.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class ImagePagingDataSource(private val imageItems: MutableList<Image>) :
    PagingSource<Int, CategorizedMedia>() {
    override fun getRefreshKey(state: PagingState<Int, CategorizedMedia>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CategorizedMedia> {
        return try {
            withContext(Dispatchers.IO) {
                val startIndex = 0
                val loadIndex = 20
                val pageNumber = params.key ?: startIndex
                val nextIndex = imageItems.size - pageNumber - loadIndex
                val imageList =
                    imageItems.subList(pageNumber, minOf(pageNumber+loadIndex, imageItems.size))
                val categorizedMediaList = mutableListOf<CategorizedMedia>()
                try {
                    val categoryName = imageList[0].categoryName
                    if (pageNumber == startIndex)
                        categorizedMediaList.add(CategorizedMedia.Header(categoryName))
                    else if (imageItems[pageNumber -1].categoryName != categoryName)
                        categorizedMediaList.add(CategorizedMedia.Header(categoryName))
                } catch (e: Exception) {
                    Log.e("Media Loading: ", "Exception => ${e.message}")
                    categorizedMediaList.add(CategorizedMedia.Header("Recent"))
                }
                imageList.forEachIndexed { index, image ->
                    when {
                        imageList.size == index + 1 -> {
                            categorizedMediaList.add(CategorizedMedia.ImageItem(image))
                        }
                        imageList[index + 1].categoryName == image.categoryName -> {
                            categorizedMediaList.add(CategorizedMedia.ImageItem(image))
                        }
                        else -> {
                            categorizedMediaList.add(CategorizedMedia.ImageItem(image))
                            categorizedMediaList.add(CategorizedMedia.Header(imageList[index + 1].categoryName))
                        }
                    }
                }


                LoadResult.Page(
                    categorizedMediaList,
                    when {
                        pageNumber > 0 -> pageNumber - loadIndex
                        else -> null
                    },
                    when {
                       // nextIndex > loadIndex -> pageNumber + loadIndex
                        nextIndex > 0 -> pageNumber + loadIndex// + nextIndex
                        else -> null
                    }
                )
            }
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        }
    }
}