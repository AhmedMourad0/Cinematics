package inc.ahmedmourad.cinematics.mvvm.viewmodels.activity

import android.arch.lifecycle.ViewModel
import android.content.Context

import inc.ahmedmourad.cinematics.mvvm.model.sync.SyncUtils

class MainActivityViewModel : ViewModel() {

    fun initializeSync(context: Context) {

        SyncUtils.initialize(context)
    }
}
