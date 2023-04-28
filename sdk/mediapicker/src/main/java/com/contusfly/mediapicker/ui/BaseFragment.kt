package com.contusfly.mediapicker.ui

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment(){

    var hasInitializedRootView = false
    private var rootView: View? = null

    fun getPersistentView(view: View): View? {
        if (rootView == null) {
            // Inflate the layout for this fragment
            rootView = view
        } else {
            // Do not inflate the layout again.
            // The returned View of onCreateView will be added into the fragment.
            // However it is not allowed to be added twice even if the parent is same.
            // So we must remove rootView from the existing parent view group
            // (it will be added back).
            (rootView?.parent as? ViewGroup)?.removeView(rootView)
        }

        return rootView
    }
}