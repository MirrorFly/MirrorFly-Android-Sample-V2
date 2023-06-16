package com.contusfly.utils

import android.app.Activity
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.applySrcInColorFilter

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class UserInterfaceUtils {

    companion object {
        /**
         * Initializes a customized [Toolbar][android.widget.Toolbar] to act as the
         * [android.app.ActionBar] for the Activity window.
         *
         * @param activity The instance of the AppCompatActivity object.
         * @param toolbar  Toolbar to set as the Activity's action bar.
         */
        fun initializeCustomToolbar(activity: AppCompatActivity, toolbar: Toolbar?) {
            activity.setSupportActionBar(toolbar)
            if (activity.supportActionBar != null) {
                activity.supportActionBar!!.setDisplayShowTitleEnabled(true)
                activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                activity.supportActionBar!!.setDisplayShowHomeEnabled(true)
            }
        }

        /**
         * Sets the up tool bar for the Activity. This toolbar will be setup with
         * back-press option. The
         * [Activity] back press will called it's super class back-press.
         *
         * @param context   Instance of Context
         * @param toolbar   Instance of Toolbar
         * @param actionBar Instance of Actionbar
         * @param title     String title
         */
        fun setUpToolBar(context: Activity, toolbar: Toolbar?,
                         actionBar: ActionBar?, title: String?) {
            try {
                if (actionBar != null) {
                    actionBar.setDisplayHomeAsUpEnabled(true)
                    actionBar.setDisplayShowHomeEnabled(true)
                    actionBar.title = title
                }
                if (toolbar != null) {
                    toolbar.setTitleTextColor(ContextCompat.getColor(context, com.contusfly.R.color.color_black))
                    toolbar.navigationIcon!!.applySrcInColorFilter(ContextCompat.getColor(context, com.contusfly.R.color.color_black))
                    toolbar.setNavigationOnClickListener(View.OnClickListener { context.finish() })
                }
            } catch (e: Exception) {
                LogMessage.e(e)
            }
        }
    }
}