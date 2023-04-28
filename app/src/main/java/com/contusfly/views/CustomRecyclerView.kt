/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
class CustomRecyclerView : RecyclerView {
    /**
     * Empty view in recycler view
     */
    private var emptyView: View? = null

    /**
     * Observer of the recycler view
     */
    private val observer: AdapterDataObserver = object : AdapterDataObserver() {
        override fun onChanged() {
            checkIfEmpty()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            checkIfEmpty()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            checkIfEmpty()
        }
    }

    /**
     * Instantiates a new custom recycler view.
     *
     * @param context the startupActivityContext
     */
    constructor(context: Context?) : super(context!!) {}

    /**
     * Instantiates a new custom recycler view.
     *
     * @param context the startupActivityContext
     * @param attrs   the attrs
     */
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {}

    /**
     * Instantiates a new custom recycler view.
     *
     * @param context  the startupActivityContext
     * @param attrs    the attrs
     * @param defStyle the def style
     */
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context!!, attrs, defStyle) {}

    override fun setAdapter(adapter: Adapter<*>?) {
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(observer)
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(observer)
        checkIfEmpty()
    }

    /**
     * Check if empty. And enable or disable based on that
     */
    private fun checkIfEmpty() {
        if (emptyView != null && adapter != null) {
            val emptyViewVisible = adapter!!.itemCount == 0
            emptyView!!.visibility = if (emptyViewVisible) VISIBLE else GONE
            visibility = if (emptyViewVisible) GONE else VISIBLE
        }
    }

    /**
     * Sets the empty view.
     *
     * @param emptyView the new empty view
     */
    fun setEmptyView(emptyView: View?) {
        this.emptyView = emptyView
        checkIfEmpty()
    }
}