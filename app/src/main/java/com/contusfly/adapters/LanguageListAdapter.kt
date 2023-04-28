package com.contusfly.adapters

import android.app.Activity
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.databinding.RowLanguageListBinding
import com.contusfly.showToast
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.ChatManager
import com.location.googletranslation.pojo.Languages


/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class LanguageListAdapter(activity: Activity, list: MutableList<Languages>) : RecyclerView.Adapter<LanguageListAdapter.LanguageViewHolder>() {

    private var mActivity: Activity? = null

    private var mLanguageList: MutableList<Languages>? = mutableListOf()

    /**
     * The countries list temporary for the search view.
     */
    private var languageTempData: MutableList<Languages>? = mutableListOf()

    /**
     * Instantiates
     *
     * @param context
     */
    init {
        this.mActivity = activity
        languageTempData?.clear()
        this.languageTempData = list
        this.mLanguageList?.addAll(languageTempData!!)
    }

    class LanguageViewHolder(var viewBinding: RowLanguageListBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val adapterBinding = RowLanguageListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LanguageViewHolder(adapterBinding)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val item = languageTempData!![position]
        holder.viewBinding.languageText.text = item.name
        holder.viewBinding.languageSelected.visibility = if (SharedPreferenceManager.getString(
                Constants.GOOGLE_TRANSLATION_LANGUAGE_CODE) == item.language) View.VISIBLE else View.INVISIBLE
        holder.viewBinding.languageText.setOnClickListener {
            if(!ChatManager.getAvailableFeatures().isTranslationEnabled){
                SharedPreferenceManager.setString(Constants.GOOGLE_LANGUAGE_NAME, "English")
                SharedPreferenceManager.setString(Constants.GOOGLE_TRANSLATION_LANGUAGE_CODE, "en")
                mActivity!!.showToast(mActivity!!.resources.getString(R.string.fly_error_forbidden_exception))
            }
            SharedPreferenceManager.setString(Constants.GOOGLE_LANGUAGE_NAME, item.name)
            SharedPreferenceManager.setString(Constants.GOOGLE_TRANSLATION_LANGUAGE_CODE, item.language)
            mActivity!!.onBackPressed()
        }
    }

    override fun getItemCount(): Int {
        return languageTempData!!.size
    }

    /**
     * Filter the language view after the search in the country list.
     *
     * @param filterKey Search key
     */
    fun filter(filterKey: String) {
        languageTempData?.clear()
        // Validate whether the search key is empty while searching
        if (TextUtils.isEmpty(filterKey)) {
            languageTempData?.addAll(mLanguageList!!)
        } else {
            for (mKey in mLanguageList!!) {
                if (mKey.language.toLowerCase().contains(filterKey.toLowerCase()) || mKey.name.toLowerCase().contains(filterKey.toLowerCase()))
                    languageTempData?.add(mKey)
            }
        }
    }
}