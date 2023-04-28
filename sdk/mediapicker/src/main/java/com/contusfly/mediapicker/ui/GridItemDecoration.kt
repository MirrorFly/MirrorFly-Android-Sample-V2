package com.contusfly.mediapicker.ui

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.contusfly.mediapicker.R

class GridItemDecoration(context: Context, val spanCount: Int) : ItemDecoration() {

    private val spacing: Int =
        context.resources.getDimensionPixelSize(R.dimen.decoration_height)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val itemPosition = parent.getChildAdapterPosition(view)

        val column: Int = itemPosition % spanCount // item column

        outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
        outRect.right =
            spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
        if (itemPosition >= spanCount) {
            outRect.top = spacing // item top
        }
    }

}