package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import androidx.fragment.app.Fragment
import com.contusfly.R
import com.contusfly.fragments.DataUsageSettingsFragment
import com.contusfly.views.CustomTextView
import java.util.*

/**
 * This class which extends ExpandableListAdapter is used to provide data and views in an
 * expandable list view.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
class DataUsageSettingsAdapter(fragment: DataUsageSettingsFragment) : BaseExpandableListAdapter() {
    /**
     * Only Clicked position
     */
    private var clickedPosition = 0

    // to toggle between up and down arrows
    private var compoundDrawable = 0

    // The DataUsageSettingsFragment to which this adapter is currently associated with.
    private val dataUsageSettingsFragment: DataUsageSettingsFragment = fragment

    // The group items of the expandable list.
    private val groupItemList: List<String>

    // The child items of the individual groups in the expandable list.
    private val childItemList: HashMap<String, List<String>>
    override fun getGroupCount(): Int {
        return groupItemList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return childItemList[groupItemList[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return groupItemList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return childItemList[groupItemList[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    fun setCompoundDrawable(compoundDrawable: Int) {
        this.compoundDrawable = compoundDrawable
    }

    fun setClickedPosition(clickedPosition: Int) {
        this.clickedPosition = clickedPosition
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        var view:View? = convertView
        if (view == null) {
            val layoutInflater = (dataUsageSettingsFragment.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            view = layoutInflater.inflate(R.layout.list_data_usage_settings_group_item, null)
        }
        val groupViewText: CustomTextView = view!!.findViewById(R.id.text_group_view)
        groupViewText.text = groupItemList[groupPosition]
        if (clickedPosition == groupPosition) {
            groupViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, compoundDrawable, 0)
        }
        return view
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var view: View? = convertView
        if (view == null) {
            val layoutInflater = (dataUsageSettingsFragment.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            view = layoutInflater.inflate(R.layout.list_data_usage_settings_child_item, null)
        }
        val childViewText: CustomTextView = view!!.findViewById(R.id.text_child_view)
        childViewText.text = childItemList[groupItemList[groupPosition]]?.get(childPosition)
        if (groupPosition == 0)
            setUpMobileDataSettingsChildView(childViewText, childPosition)
        else
            setUpWifiDataSettingsChildView(childViewText, childPosition)
        return view
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    /**
     * Sets a View that displays the mobile data usage settings for the given child.
     *
     * @param childViewText The child view to display the data.
     * @param childPosition The position of the child within the group view.
     */
    private fun setUpMobileDataSettingsChildView(childViewText: CustomTextView, childPosition: Int) {
        if (dataUsageSettingsFragment.mediaAutoDownloadOption != null) {
            when (childPosition) {
                0 -> photoAutoDownloadCheckViaData(childViewText)
                1 -> videoAutoDownloadCheckViaData(childViewText)
                2 -> audioAutoDownloadCheckViaData(childViewText)
                else -> {
                    if (dataUsageSettingsFragment.mediaAutoDownloadOption!!.downloadDocumentsOnMobileData) {
                        childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_selected_tick, 0)
                    } else {
                        childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselected_tick, 0)
                    }
                }
            }
        }
    }

    private fun photoAutoDownloadCheckViaData(childViewText: CustomTextView) {
        if (dataUsageSettingsFragment.mediaAutoDownloadOption!!.downloadPhotosOnMobileData) {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_selected_tick, 0)
        } else {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselected_tick, 0)
        }
    }

    private fun videoAutoDownloadCheckViaData(childViewText: CustomTextView) {
        if (dataUsageSettingsFragment.mediaAutoDownloadOption!!.downloadVideosOnMobileData) {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_selected_tick, 0)
        } else {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselected_tick, 0)
        }
    }

    private fun audioAutoDownloadCheckViaData(childViewText: CustomTextView) {
        if (dataUsageSettingsFragment.mediaAutoDownloadOption!!.downloadAudiosOnMobileData) {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_selected_tick, 0)
        } else {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselected_tick, 0)
        }
    }

    /**
     * Sets a View that displays the wifi data usage settings for the given child.
     *
     * @param childViewText The child view to display the data.
     * @param childPosition The position of the child within the group view.
     */
    private fun setUpWifiDataSettingsChildView(childViewText: CustomTextView, childPosition: Int) {
        if (dataUsageSettingsFragment.mediaAutoDownloadOption != null) {
            when (childPosition) {
                0 -> photoAutoDownloadCheckViaWifi(childViewText)
                1 -> videoAutoDownloadCheckViaWifi(childViewText)
                2 -> audioAutoDownloadCheckViaWifi(childViewText)
                else -> {
                    if (dataUsageSettingsFragment.mediaAutoDownloadOption!!.downloadDocumentsOnWifiData) {
                        childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_selected_tick, 0)
                    } else {
                        childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselected_tick, 0)
                    }
                }
            }
        }
    }

    private fun photoAutoDownloadCheckViaWifi(childViewText: CustomTextView) {
        if (dataUsageSettingsFragment.mediaAutoDownloadOption!!.downloadPhotosOnWifiData) {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_selected_tick, 0)
        } else {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselected_tick, 0)
        }
    }

    private fun videoAutoDownloadCheckViaWifi(childViewText: CustomTextView) {
        if (dataUsageSettingsFragment.mediaAutoDownloadOption!!.downloadVideosOnWifiData) {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_selected_tick, 0)
        } else {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselected_tick, 0)
        }
    }

    private fun audioAutoDownloadCheckViaWifi(childViewText: CustomTextView) {
        if (dataUsageSettingsFragment.mediaAutoDownloadOption!!.downloadAudiosOnWifiData) {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_selected_tick, 0)
        } else {
            childViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselected_tick, 0)
        }
    }

    /**
     * The constructor to be invoked when creating the instance of this adapter object.
     *
     * @paramfragment The Fragment to which this adapter is currently associated with.
     */
    init {
        groupItemList = ArrayList(listOf(*fragment.resources.getStringArray(R.array.array_data_usage_settings)))
        childItemList = HashMap()
        for (groupItem in groupItemList) {
            childItemList[groupItem] = ArrayList(listOf(*fragment.resources.getStringArray(R.array.array_media_types)))
        }
    }
}
