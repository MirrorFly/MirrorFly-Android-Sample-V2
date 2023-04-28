package com.contusfly.helpers

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class RecentChatPaginationScrollListener(private val linearLayoutManager: LinearLayoutManager) :  RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val visibleItemCount: Int = linearLayoutManager.childCount
        val totalItemCount: Int = linearLayoutManager.itemCount
        val firstVisibleItemPosition: Int = linearLayoutManager.findFirstVisibleItemPosition()

        if (!isFetching() && !isLastPage() && visibleItemCount + firstVisibleItemPosition >= (totalItemCount-20) && firstVisibleItemPosition >= 0) {
            loadMoreItems()
        }
    }

    protected abstract fun loadMoreItems()

    abstract fun isLastPage(): Boolean

    abstract fun isFetching(): Boolean
}