package com.contusfly.utils

import android.content.Context
import com.mirrorflysdk.flydatabase.model.Country
import org.json.JSONArray

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
object CountriesListObject {

    /**
     * Get the country data from text file and insert buffer
     */
    fun getCountriesList(context: Context): MutableList<Country> {
        val countryList: MutableList<Country> = mutableListOf()
        val input = context.assets.open("countries.txt")
        val buffer = ByteArray(input.available())
        val value = input.read(buffer)
        /*
        Check the read value from text file empty or not
        */
        if (value > 0) LogMessage.v("mApp::", value.toString())
        input.close()

        val countryObject = JSONArray(String(buffer))
        var i = 0
        val length = countryObject.length()
        while (i < length) {
            val jsonObject = countryObject.getJSONObject(i)
            val country = Country()
            country.id = i.toLong()
            country.countryCode = jsonObject.getString("code")
            country.countryName = jsonObject.getString("name")
            country.dialCode = jsonObject.getString("dial_code")
            /*
            Insert country item into list
            */
            countryList.add(country)
            i++
        }
        return countryList
    }

    fun getCountriesListByCountryCode(context: Context, countryCode: String): String {
        val countryList = getCountriesList(context).toList()

        for (country in countryList) {
            if (country.countryCode.equals(countryCode)) return country.countryName
        }
        return Constants.EMPTY_STRING
    }
}