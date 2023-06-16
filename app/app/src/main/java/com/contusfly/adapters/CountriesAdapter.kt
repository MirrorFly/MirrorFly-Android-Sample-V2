package com.contusfly.adapters

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.databinding.RowCountryItemBinding
import com.mirrorflysdk.flydatabase.model.Country
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class CountriesAdapter(context: Context) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    /**
     * List of countries for the list view
     */
    private var countryList: MutableList<Country>? = mutableListOf()

    /**
     * The countries list temporary for the search view.
     */
    private var countryTempData: MutableList<Country>? = mutableListOf()

    /**
     * The startupActivityContext of the user activity.
     */
    private var context: Context? = null

    /**
     * Instantiates
     *
     * @param context
     */
    init {
        this.context = context
    }

    /**
     * Sets the list data for the recycler view
     *
     * @param countryList List of countries for populating Recycler view
     */
    fun setCountries(countryList: MutableList<Country>?) {
        countryTempData?.clear()
        this.countryTempData = countryList
        this.countryList?.addAll(countryTempData!!)
    }

    class CountryViewHolder(var viewBinding: RowCountryItemBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        var adapterBinding = RowCountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(adapterBinding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = countryTempData!![position]
        holder.viewBinding.textCountryCode.text = item.dialCode
        holder.viewBinding.textCountryName.text = item.countryName
    }

    override fun getItemCount(): Int {
        return countryTempData!!.size
    }

    /**
     * Filter the country view after the search in the country list.
     *
     * @param filterKey Search key
     */
    fun filter(filterKey: String) {
        countryTempData?.clear()
        // Validate whether the search key is empty while searching
        if (TextUtils.isEmpty(filterKey)) {
            countryTempData?.addAll(countryList!!)
        } else {
            for (mKey in countryList!!) {
                if (mKey.countryName.toLowerCase().contains(filterKey.toLowerCase()) || mKey.dialCode.toLowerCase().contains(filterKey.toLowerCase()))
                    countryTempData?.add(mKey)
            }
        }
    }
}