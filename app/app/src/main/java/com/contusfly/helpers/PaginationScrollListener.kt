package com.contusfly.helpers

import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.LogMessage

abstract class PaginationScrollListener(
    private val linearLayoutManager: LinearLayoutManager,
    private val handler: Handler
) :  RecyclerView.OnScrollListener() {

    private var canLoadMore = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val visibleItemCount: Int = linearLayoutManager.childCount
        val totalItemCount: Int = linearLayoutManager.itemCount
        val firstVisibleItemPosition: Int = linearLayoutManager.findFirstVisibleItemPosition()
        val lastVisibleItemPosition: Int = linearLayoutManager.findLastCompletelyVisibleItemPosition()
         LogMessage.d("CALL_LOG_PAGINATION", "PAGINATION_HIT-----$canLoadMore---${isFetching()}----${isLastPage()}----$visibleItemCount---$firstVisibleItemPosition----$totalItemCount---$firstVisibleItemPosition---------$lastVisibleItemPosition")
          if (canLoadMore && !isFetching() && !isLastPage() && visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
            loadMoreItems()
            canLoadMore = false

            handler.postDelayed({
                canLoadMore = true
            }, 100)
        }
    }

    protected abstract fun loadMoreItems()

    abstract fun isLastPage(): Boolean

    abstract fun isFetching(): Boolean
}