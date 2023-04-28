package com.contusfly.fragments

import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.activities.SettingsActivity
import com.contusfly.adapters.LanguageListAdapter
import com.contusfly.databinding.FragmentTranslatedLanguageListBinding
import com.contusfly.viewmodels.DashboardViewModel
import com.contusfly.views.DoProgressDialog
import com.mirrorflysdk.AppUtils
import com.location.googletranslation.GoogleTranslation
import com.location.googletranslation.pojo.Languages


/**
 * A simple [Fragment] subclass.
 * Use the [TranslatedLanguageListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TranslatedLanguageListFragment : Fragment() {

    private lateinit var translatedLanguageListBinding: FragmentTranslatedLanguageListBinding

    /**
     * Progress dialog for the background process
     */
    private lateinit var progressDialog: DoProgressDialog

    private var languageListAdapter: LanguageListAdapter? = null

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = DoProgressDialog(requireContext())
        val settingsActivity = activity as SettingsActivity?
        settingsActivity?.setActionBarTitle(getString(R.string.choose_language))
        settingsActivity?.showSearchMenu(true)
    }

    private fun setObservers() {
        viewModel.updateLanguageSearch.observe(viewLifecycleOwner, Observer { updateSearch(it!!) })
    }

    private fun updateSearch(searchKey: String) {
        if (languageListAdapter != null) {
            languageListAdapter!!.filter(searchKey)
            languageListAdapter!!.notifyDataSetChanged()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        translatedLanguageListBinding =
            FragmentTranslatedLanguageListBinding.inflate(inflater, container, false)
        return translatedLanguageListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        val errorMessageTextView = translatedLanguageListBinding.errorMsgText
        val recyclerView: RecyclerView = translatedLanguageListBinding.recyclerViewLanguageList
        progressDialog.showProgress()
        GoogleTranslation.getInstance()
            .getLanguageList(activity, "en", BuildConfig.GOOGLE_TRANSLATE_KEY,
                object : GoogleTranslation.GoogleLanguageListListener {
                    override fun onSuccess(list: List<Languages>) {
                        languageListAdapter = LanguageListAdapter(activity!!, list as MutableList<Languages>)
                        recyclerView.layoutManager = LinearLayoutManager(context)
                        recyclerView.adapter = languageListAdapter
                        progressDialog.dismiss()
                    }

                    override fun onFailed(s: String) {
                        errorMessageTextView.visibility = View.VISIBLE
                        if (!AppUtils.isNetConnected(context)) errorMessageTextView.setText(R.string.msg_no_internet)
                        else errorMessageTextView.text = s
                        progressDialog.dismiss()
                    }
                })
    }

    companion object {
        /**
         * Creating the instance of Activity
         *
         * @return Instance of TranslatedLanguageListFragment
         */
        fun newInstance(): TranslatedLanguageListFragment {
            return TranslatedLanguageListFragment()
        }
    }
}