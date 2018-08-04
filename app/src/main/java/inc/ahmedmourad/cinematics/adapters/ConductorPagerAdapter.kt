package inc.ahmedmourad.cinematics.adapters

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.support.RouterPagerAdapter
import inc.ahmedmourad.cinematics.R
import inc.ahmedmourad.cinematics.mvvm.view.controllers.PopularMoviesController

class ConductorPagerAdapter(host: Controller) : RouterPagerAdapter(host) {

    private val controllers = arrayOf<Controller>(
            PopularMoviesController()
    )

    private val controllersNames = arrayOf(
            host.activity?.getString(R.string.popular_movies) ?: "Popular Movies"
    )

    override fun configureRouter(router: Router, position: Int) {

        if (!router.hasRootController())
            router.setRoot(RouterTransaction.with(controllers[position]))
    }

    override fun getPageTitle(position: Int) = controllersNames[position]

    override fun getCount() = controllers.size


    companion object {

        const val CONTROLLER_POPULAR_MOVIES = 0
    }
}
