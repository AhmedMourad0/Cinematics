package inc.ahmedmourad.cinematics.mvvm.view.controllers

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelStore
import com.bluelinelabs.conductor.archlifecycle.LifecycleController

abstract class BaseController : LifecycleController() {

    private val viewModelStore = ViewModelStore()

    fun viewModelProvider(factory: ViewModelProvider.NewInstanceFactory = defaultFactory()) =
            ViewModelProvider(viewModelStore, factory)

    private fun defaultFactory() = ViewModelProvider.AndroidViewModelFactory(activity!!.application)
}
