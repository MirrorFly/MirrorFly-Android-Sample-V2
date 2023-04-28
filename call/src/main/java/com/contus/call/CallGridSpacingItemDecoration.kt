package com.contus.call

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CallGridSpacingItemDecoration(context: Context) :
    RecyclerView.ItemDecoration() {

    private val spacing = context.resources.getDimensionPixelSize(R.dimen.decoration_height_for_two)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = spacing
        outRect.right = spacing
        outRect.bottom = spacing
        outRect.top = spacing
    }
}