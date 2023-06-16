package com.contusfly.fragments

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.contusfly.R
import com.contusfly.activities.SettingsActivity
import com.contusfly.databinding.FragmentNotificationInstructionBinding

/**
 * This class provides an option to the user for setting up the notification alert preferences when
 * receiving new messages.
 *
 */
class NotificationInstructionFragment : Fragment() {

    /**
     * The Activity to which this fragment is currently associated with.
     */
    private var settingsActivity: SettingsActivity? = null

    private lateinit var binding: FragmentNotificationInstructionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsActivity = activity as SettingsActivity?
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.notification_not_working))

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationInstructionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initView(){
        val webSettings: WebSettings = binding.wvNotificationInstruction.getSettings()
        binding.wvNotificationInstruction.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        webSettings.javaScriptEnabled = true
        webSettings.loadsImagesAutomatically = true

        val progressBar = ProgressDialog(activity, R.style.AppCompatAlertDialogStyle)
        progressBar.setMessage(resources.getString(R.string.msg_loading))
        progressBar.show()

        binding.wvNotificationInstruction.webViewClient = object : WebViewClient() {
            /*
                 * Handle the inner link available in webview
                 */
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                if (progressBar.isShowing) {
                    progressBar.dismiss()
                }
            }

            override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                Toast.makeText(context, context!!.getString(R.string.error_occurred_label), Toast.LENGTH_SHORT).show()
            }
        }

        binding.wvNotificationInstruction.loadUrl(resources.getString(R.string.notification_not_working_URL))
    }

    companion object {
        /**
         * The constructor used to create and initialize a new instance of this class object,
         * with the specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @JvmStatic
        fun newInstance(): NotificationInstructionFragment {
            return NotificationInstructionFragment()
        }
    }
}