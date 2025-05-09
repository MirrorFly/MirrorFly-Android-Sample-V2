package com.contusfly.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * We use this class to create our custom view models
 */

@Suppress("UNCHECKED_CAST")
@SuppressWarnings("kotlin:S6531")
@Singleton
class AppViewModelFactory @Inject
constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            //Check if there is a subclass of ViewModel of type T
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            error("unknown model class $modelClass")
        }
        try {
            // The cast is safe because creator is matched via isAssignableFrom
            //creator.get() returns a ViewModel, but the method signature requires T : ViewModel.
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}