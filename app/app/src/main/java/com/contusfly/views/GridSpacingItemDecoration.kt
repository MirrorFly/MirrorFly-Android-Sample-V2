package com.contusfly.views

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.contusfly.R

class GridSpacingItemDecoration(context: Context, private val spanCount: Int) :
    RecyclerView.ItemDecoration() {
    private val spacing = context.resources.getDimensionPixelSize(R.dimen.decoration_height_for_four)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val itemPosition = parent.getChildAdapterPosition(view)

        val lp = view.layoutParams as StaggeredGridLayoutManager.LayoutParams
        if (!lp.isFullSpan) {
            val column: Int = lp.spanIndex -1 //itemPosition % spanCount // item column

            outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (itemPosition-1 >= spanCount) {
                outRect.top = spacing // item top
            }
        }
    }

}