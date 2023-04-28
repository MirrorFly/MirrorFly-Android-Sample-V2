package com.contusfly.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ViewPagerAdapter(activity: FragmentActivity, val fragmentsArray: ArrayList<Fragment>, val titles: Array<String>) : FragmentStateAdapter(activity)  {

    override fun getItemCount(): Int {
        return fragmentsArray.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentsArray[position]
    }

    fun getTabTitle(position: Int): CharSequence {
        return titles[position]
    }

}