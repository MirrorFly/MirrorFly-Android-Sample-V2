package com.contusfly.helpers

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.utils.LogMessage

abstract class RecentChatPaginationScrollListener(private val linearLayoutManager: LinearLayoutManager) :  RecyclerView.OnScrollListener() {

    var isScrollStateSettle:Boolean=false
    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        when (newState) {
            RecyclerView.SCROLL_STATE_IDLE -> println("Recent RecyclerView is not scrolling")
            RecyclerView.SCROLL_STATE_DRAGGING -> LogMessage.e("SCROLL_RECENT--","DRAGGING")
            RecyclerView.SCROLL_STATE_SETTLING -> isScrollStateSettle=true
        }
    }
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if(isScrollStateSettle) {
            val totalItemCount: Int = linearLayoutManager.itemCount
            var lastVisibleItemPosition: Int =
                linearLayoutManager.findLastCompletelyVisibleItemPosition()
            val validCountToPaginate = totalItemCount - 8
            if (linearLayoutManager != null && !isFetching() && (lastVisibleItemPosition >= validCountToPaginate) && validCountToPaginate > 0) {
                //bottom of list!
                isScrollStateSettle = false
                loadMoreItems()
            }
        }

        if(dy > 0){
            hidePrivateChat()
        }
    }

    protected abstract fun loadMoreItems()

    abstract fun isLastPage(): Boolean

    abstract fun isFetching(): Boolean

    protected abstract fun hidePrivateChat()
}