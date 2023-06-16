package com.contusfly.mediapicker.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class CustomStaggeredGridLayoutManager : StaggeredGridLayoutManager {
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {}
    constructor(spanCount: Int, orientation: Int) : super(spanCount, orientation) {}

    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
        try {
            super.onLayoutChildren(recycler, state)
        } catch (e: IndexOutOfBoundsException) {
            Log.e("TAG", "meet a IOOBE in RecyclerView")
        }
    }
}