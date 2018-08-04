package inc.ahmedmourad.cinematics.mvvm.view.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction

import inc.ahmedmourad.cinematics.R
import inc.ahmedmourad.cinematics.mvvm.viewmodels.activity.MainActivityViewModel
import inc.ahmedmourad.cinematics.mvvm.view.controllers.MainController

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router

    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

//        mainActivityViewModel.initializeSync(this)

        router = Conductor.attachRouter(this, findViewById(R.id.controller_container), savedInstanceState)

        if (!router.hasRootController())
            router.setRoot(RouterTransaction.with(MainController()))
    }

    override fun onBackPressed() {

        if (!router.handleBack())
            super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
