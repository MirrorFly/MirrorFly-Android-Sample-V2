package com.contusfly.helpers

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class RecentChatPaginationScrollListener(private val linearLayoutManager: LinearLayoutManager) :  RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val totalItemCount: Int = linearLayoutManager.itemCount
        var lastVisibleItemPosition:Int=linearLayoutManager.findLastCompletelyVisibleItemPosition()

        if (linearLayoutManager != null && !isFetching() && lastVisibleItemPosition == totalItemCount - 1) {
            //bottom of list!
            loadMoreItems()
        }
    }

    protected abstract fun loadMoreItems()

    abstract fun isLastPage(): Boolean

    abstract fun isFetching(): Boolean
}