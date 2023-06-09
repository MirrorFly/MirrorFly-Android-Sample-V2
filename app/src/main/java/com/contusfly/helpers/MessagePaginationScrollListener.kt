package com.contusfly.helpers

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.utils.LogMessage
import com.mirrorflysdk.api.ChatManager

abstract class MessagePaginationScrollListener(private val linearLayoutManager: LinearLayoutManager) :  RecyclerView.OnScrollListener() {

    var isScrollStateSettle:Boolean=false
    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        when (newState) {
            RecyclerView.SCROLL_STATE_IDLE -> println("The RecyclerView is not scrolling")
            RecyclerView.SCROLL_STATE_DRAGGING -> LogMessage.e("SCROLL_MESSAGE--","DRAGGING")
            RecyclerView.SCROLL_STATE_SETTLING -> isScrollStateSettle=true
        }
    }
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if(isScrollStateSettle) {
            val totalItemCount: Int = linearLayoutManager.itemCount
            val firstVisibleItemPosition: Int = linearLayoutManager.findFirstVisibleItemPosition()
            val lastVisibleItemPosition: Int = linearLayoutManager.findLastCompletelyVisibleItemPosition()
        if (!isFetching() && lastVisibleItemPosition == totalItemCount - 1) {
            isScrollStateSettle=false
            loadNextItems()
        }

        if (!isFetching() && firstVisibleItemPosition == 0) {
            isScrollStateSettle=false
            loadPreviousItems()
        }

        }

    }

    protected abstract fun loadNextItems()

    protected abstract fun loadPreviousItems()

    abstract fun hasNextItems(): Boolean

    abstract fun hasPreviousItems(): Boolean

    abstract fun isFetching(): Boolean

    abstract fun isLastpageFetched(): Boolean
}