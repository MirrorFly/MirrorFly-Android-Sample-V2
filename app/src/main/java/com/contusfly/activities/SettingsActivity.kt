package com.contusfly.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.mirrorflysdk.flycommons.Features
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.applySrcInColorFilter
import com.contusfly.databinding.ActivitySettingsBinding
import com.contusfly.fragments.SettingsFragment
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.SafeChatUtils
import com.contusfly.utils.UserInterfaceUtils
import com.contusfly.viewmodels.DashboardViewModel
import dagger.android.AndroidInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class SettingsActivity : BaseActivity(), CoroutineScope {

    private lateinit var settingsBinding: ActivitySettingsBinding

    // The FragmentManager object for interacting with fragments associated with this activity.
    private lateinit var fragmentManager: FragmentManager

    private val viewModel by lazy {
        ViewModelProvider(this).get(DashboardViewModel::class.java)
    }

    /**
     * menus
     */
    private var mMenu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        settingsBinding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(settingsBinding.root)

        fragmentManager = supportFragmentManager
        setSupportActionBar(settingsBinding.toolbar)
        UserInterfaceUtils.initializeCustomToolbar(this, settingsBinding.toolbar)
        settingsBinding.textTitle.setTextColor(ContextCompat.getColor(this, R.color.text_color_black))
        settingsBinding.toolbar.navigationIcon?.applySrcInColorFilter(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color))
        val navigateToSafeChat: Boolean = checkIsToEnableSafeChat(intent)
        performFragmentTransaction(SettingsFragment.newInstance(navigateToSafeChat))

    }

    private fun checkIsToEnableSafeChat(intent: Intent?): Boolean = intent!=null && intent.getBooleanExtra(
        Constants.IS_FOR_SAFE_CHAT,false)

    /**
     * Set the action bar's title.
     *
     * @param title Title to set.
     */
    @SuppressLint("ObsoleteSdkInt")
    fun setActionBarTitle(title: String?) {
        val isLayoutInitialized = ::settingsBinding.isInitialized
        if (isLayoutInitialized) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) settingsBinding.textTitle.setTextAppearance(R.style.ToolbarTitleStyle)
            settingsBinding.textTitle.text = title
        }
    }

    fun showSearchMenu(show: Boolean) {
        if (mMenu != null) {
            val searchItem: MenuItem = mMenu!!.findItem(R.id.action_search)
            LogMessage.e(TAG,"showSearchMenu is not null")
            val searchView = MenuItemCompat.getActionView(searchItem) as SearchView
            searchView.clearFocus()
            searchItem.setVisible(show)
        }
    }


    /**
     * Performs fragment transaction by replacing an existing fragment that was added to the
     * container which is actually present in the parent activity. This is essentially the same as
     * calling [FragmentTransaction.remove] for all currently added fragments that
     * were added with the container and then [FragmentTransaction.add]
     * with the arguments specified.
     *
     * @param fragment The new fragment to place in the container.
     */
    fun performFragmentTransaction(fragment: Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.view_container, fragment, fragment.javaClass.name)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onStart() {
        super.onStart()
        if(SafeChatUtils.updateAlert)
            finish()
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStackImmediate()
            hideSoftKeyboard(this)
            showSearchMenu(false)
            val fragments = fragmentManager.fragments
            if (fragments.isNotEmpty()) {
                when {
                    fragments[0] is SettingsFragment -> settingsBinding.textTitle.text = resources.getString(R.string.settings_label)
                }
            }
        } else finish()
    }

    override fun usersIBlockedListFetched(jidList: List<String>) {
        super.usersIBlockedListFetched(jidList)
        viewModel.getLiveDataForBlockedContacts(jidList)
    }

    override fun updateArchivedSettings(archivedSettingsStatus: Boolean) {
        super.updateArchivedSettings(archivedSettingsStatus)
        viewModel.getArchivedSettingsStatus(archivedSettingsStatus)
    }

    override fun onUpdateBusyStatus(status: Boolean, message: String?) {
        super.onUpdateBusyStatus(status, message)
        viewModel.getBusySettingsStatus(status)
        LogMessage.e(TAG,"#updateBusySettings=> status::$status ::busyMessage=>$message")

    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()

    /**
     * Implemented the search listener for country selection.
     *
     * @param menu Menu item
     * @return
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        val searchView = MenuItemCompat.getActionView(searchItem) as SearchView

        searchView.setOnCloseListener { true }
        val searchPlate = searchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
        searchPlate.hint = getString(R.string.toolbar_search_label)
        val searchPlateView: View = searchView.findViewById(androidx.appcompat.R.id.search_plate)
        searchPlateView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
        searchItem.isVisible = false
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.updateSearchLanguage(newText)
                return false
            }
        })
        mMenu = menu
        return super.onCreateOptionsMenu(menu)
    }

    override fun updateFeatureActions(features: Features) {
        viewModel.updateFeatureRestriction(features)
    }

    override fun updateMuteSettings(isSuccess: Boolean,message: String,isMute: Boolean) {
        super.updateMuteSettings(isSuccess,message,isMute)
        viewModel.getNotificationMuteStatus(isMute)
    }
}
