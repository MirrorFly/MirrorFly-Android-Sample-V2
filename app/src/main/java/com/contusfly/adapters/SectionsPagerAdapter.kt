package com.contusfly.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.contusfly.R
import com.contusfly.fragments.ViewAllDocsFragment
import com.contusfly.fragments.ViewAllLinksFragment
import com.contusfly.fragments.ViewAllMediaFragment

private val TAB_TITLES = arrayOf(R.string.title_media, R.string.title_docs, R.string.title_links)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ViewAllMediaFragment.newInstance()
            1 -> ViewAllDocsFragment.newInstance()
            else -> ViewAllLinksFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}