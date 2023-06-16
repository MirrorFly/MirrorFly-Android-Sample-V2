package com.contusfly.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.adapters.CountriesAdapter
import com.contusfly.applySrcInColorFilter
import com.contusfly.databinding.ActivityCountryListBinding
import com.contusfly.utils.*
import com.contusfly.views.CustomRecyclerView
import com.mirrorflysdk.flydatabase.model.Country
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class CountryListActivity : BaseActivity() {

    private lateinit var countryListBinding: ActivityCountryListBinding

    /**
     * Instance of the action bar
     */
    private var actionBar: ActionBar? = null

    /**
     * The list countries in the Recycler view
     */
    private var countriesRecyclerView: CustomRecyclerView? = null

    /**
     * The adapter for the countries Set the list in this adapter Render it into the Recycler
     * view.
     */
    private var adapter: CountriesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countryListBinding = ActivityCountryListBinding.inflate(layoutInflater)
        setContentView(countryListBinding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        setSupportActionBar(countryListBinding.toolBar.toolbar)
        actionBar = supportActionBar
        supportActionBar?.title = getString(R.string.select_country_label)
        UserInterfaceUtils.setUpToolBar(this, countryListBinding.toolBar.toolbar, actionBar, getString(R.string.select_country_label))
        countryListBinding.toolBar.toolbar.navigationIcon?.applySrcInColorFilter(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color))
        countriesRecyclerView = countryListBinding.viewCountryList
        countriesRecyclerView!!.layoutManager = LinearLayoutManager(this)
        countryListBinding.txt.textEmptyView.text = getString(R.string.no_countries_label)
        countriesRecyclerView!!.setEmptyView(countryListBinding.txt.textEmptyView)
        setCountriesView()
    }

    /*
    * Set Countries View */
    private fun setCountriesView() {
        try {
            adapter = CountriesAdapter(this)
            /*
              Get the list of countries to show in list
             */
            val countries = CountriesListObject.getCountriesList(this)
            /* sorting country list */
            countries.sortWith(Comparator { o1: Country, o2: Country -> o1.countryName.compareTo(o2.countryName) })
            LogMessage.d("setCountriesInListView", countries.size.toString())
            adapter!!.setCountries(countries)
            countriesRecyclerView!!.adapter = adapter
            /**
             * Select the country while clicking on that
             */
            ItemClickSupport(countriesRecyclerView!!).addTo()
                    .setOnItemClickListener { _: RecyclerView?, position: Int, _: View? ->
                        val intent = Intent()
                        intent.putExtra(Constants.COUNTRY_NAME, countries[position]
                                .countryName)
                        intent.putExtra(Constants.DIAL_CODE, countries[position]
                                .dialCode)
                        intent.putExtra(Constants.COUNTRY_CODE, countries[position]
                                .countryCode)
                        setResult(RESULT_OK, intent)
                        finish()
                    }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * Implemented the search listener for country selection.
     *
     * @param menu Menu item
     * @return
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val countrySearchItem: MenuItem = menu.findItem(R.id.action_search)
        val countrySearchView = MenuItemCompat.getActionView(countrySearchItem) as SearchView

        countrySearchView.setOnCloseListener { true }
        val countrySearchPlate = countrySearchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
        countrySearchPlate.hint = getString(R.string.toolbar_search_label)
        val countrySearchPlateView: View = countrySearchView.findViewById(androidx.appcompat.R.id.search_plate)
        countrySearchPlateView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))

        countrySearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                adapter!!.filter(newText)
                adapter!!.notifyDataSetChanged()
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}