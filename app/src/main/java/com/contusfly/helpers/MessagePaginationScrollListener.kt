package com.contusfly.helpers

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class MessagePaginationScrollListener(private val linearLayoutManager: LinearLayoutManager) :  RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val visibleItemCount: Int = linearLayoutManager.childCount
        val totalItemCount: Int = linearLayoutManager.itemCount
        val firstVisibleItemPosition: Int = linearLayoutManager.findFirstVisibleItemPosition()

        if (!isFetching() && visibleItemCount + firstVisibleItemPosition >= (totalItemCount - 40) && hasNextItems()) {
            loadNextItems()
        }

        if (!isFetching() && firstVisibleItemPosition < 40 && hasPreviousItems()) {
            loadPreviousItems()
        }
    }

    protected abstract fun loadNextItems()

    protected abstract fun loadPreviousItems()

    abstract fun hasNextItems(): Boolean

    abstract fun hasPreviousItems(): Boolean

    abstract fun isFetching(): Boolean
}