package com.contusfly.adapters

import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
abstract class GenericSearchAdapter<T, ViewBindingVH : BaseViewHolder>(itemList: List<T>) : RecyclerView.Adapter<ViewBindingVH>(), Filterable {

    private var itemList: List<T>
    private var origList: List<T>

    protected abstract fun onBindData(holder: ViewBindingVH, item: T, position: Int, payloads: MutableList<Any>)
    protected abstract fun onBindData(holder: ViewBindingVH, item: T, position: Int)
    protected abstract fun hasSearchKey(item: T, filterKey: String): Boolean
    protected abstract fun setViewHolder(parent: ViewGroup): ViewBindingVH

    init {
        this.itemList = itemList
        this.origList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingVH {
        return setViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewBindingVH, position: Int) {
        onBindData(holder, itemList[position], position)
    }

    override fun onBindViewHolder(holder: ViewBindingVH, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
        } else {
            onBindData(holder, itemList[position], position, payloads)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun getItem(position: Int): T {
        return itemList[position]
    }

    fun setItems(itemList: List<T>) {
        this.itemList = itemList
        this.origList = itemList
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val oReturn = FilterResults()
                val results = ArrayList<T>()

                if (constraint.isNotEmpty() && origList.isNotEmpty()) {
                    for (item in origList) {
                        if (hasSearchKey(item, constraint.toString().trim()))
                            results.add(item)
                    }

                    oReturn.values = results
                    oReturn.count = results.size
                } else {
                    oReturn.values = origList
                    oReturn.count = origList.size
                }
                return oReturn
            }

            override fun publishResults(constraint: CharSequence,
                                        results: FilterResults) {
                itemList = ArrayList(results.values as ArrayList<T>)
                notifyDataSetChanged()
            }
        }
    }
}