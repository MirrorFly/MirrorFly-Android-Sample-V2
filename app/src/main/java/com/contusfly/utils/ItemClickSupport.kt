/*
 * @category ContusFly
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.utils

import android.view.View
import android.view.View.OnLongClickListener
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R

/**
 * This Class has been handled when the user click on the recycler view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
class ItemClickSupport constructor(private val recyclerView: RecyclerView) {
    /**
     * Item click listener.
     */
    private var mOnItemClickListener: OnItemClickListener? = null

    /**
     * Item long click listener.
     */
    private var mOnItemLongClickListener: OnItemLongClickListener? = null

    /**
     * The recyclerView on click listener.
     */
    private val mOnClickListener = View.OnClickListener { v ->
        if (mOnItemClickListener != null) {
            val holder = recyclerView.getChildViewHolder(v)
            mOnItemClickListener!!.onItemClicked(recyclerView, holder.layoutPosition, v)
        }
    }

    /**
     * The recyclerView on long click listener.
     */
    private val mOnLongClickListener = OnLongClickListener { v ->
        if (mOnItemLongClickListener != null) {
            val holder = recyclerView.getChildViewHolder(v)
            return@OnLongClickListener mOnItemLongClickListener!!.onItemLongClicked(
                recyclerView, holder.layoutPosition, v
            )
        }
        false
    }

    /**
     * Listener for the click in child views
     */
    private val mAttachListener: RecyclerView.OnChildAttachStateChangeListener =
        object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewAttachedToWindow(view: View) {
                if (mOnItemClickListener != null) {
                    view.setOnClickListener(mOnClickListener)
                }
                if (mOnItemLongClickListener != null) {
                    view.setOnLongClickListener(mOnLongClickListener)
                }
            }

            override fun onChildViewDetachedFromWindow(view: View) {
                //Code will not be added
            }
        }

    /**
     * Sets the on item click listener.
     *
     * @param listener Instance of OnItemClickListener
     * @return ItemClickSupport Instance of ItemClickSupport
     */
    fun setOnItemClickListener(listener: OnItemClickListener?): ItemClickSupport {
        mOnItemClickListener = listener
        return this
    }

    /**
     * Sets the on item long click listener.
     *
     * @param listener Instance of OnItemClickListener
     * @return ItemClickSupport Instance of ItemClickSupport
     */
    fun setOnItemLongClickListener(listener: OnItemLongClickListener?): ItemClickSupport {
        mOnItemLongClickListener = listener
        return this
    }

    /**
     * Listener for the recycler view click events
     */
    fun interface OnItemClickListener {
        /**
         * On recycler view item clicked.
         *
         * @param recyclerView Instance of RecyclerView
         * @param position     Position of the RecyclerView
         * @param v            Instance of the View
         */
        fun onItemClicked(recyclerView: RecyclerView?, position: Int, v: View?)
    }

    /**
     * Listener for the recycler view long click events
     */
    fun interface OnItemLongClickListener {
        /**
         * On recycler view item long clicked.
         *
         * @param recyclerView Instance of RecyclerView
         * @param position     Position of the RecyclerView
         * @param v            Instance of the View
         * @return boolean True if successful
         */
        fun onItemLongClicked(recyclerView: RecyclerView?, position: Int, v: View?): Boolean
    }

    /**
     * Adds the recycler view to the Item click support to handle the click events.
     *
     * @return ItemClickSupport Instance of ItemClickSupport
     */
    fun addTo(): ItemClickSupport {
        return recyclerView.getTag(R.id.rv_item_click_support) as ItemClickSupport
    }

    /**
     * Instantiates a new item click support.
     *
     */
    init {
        recyclerView.setTag(R.id.rv_item_click_support, this)
        recyclerView.addOnChildAttachStateChangeListener(mAttachListener)
    }
}