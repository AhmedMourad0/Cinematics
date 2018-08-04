package inc.ahmedmourad.cinematics.mvvm.view.controllers

import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ogaclejapan.smarttablayout.SmartTabLayout

import inc.ahmedmourad.cinematics.R
import inc.ahmedmourad.cinematics.adapters.ConductorPagerAdapter
import inc.ahmedmourad.cinematics.mvvm.view.activity.MainActivity

class MainController : BaseController() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        val view = inflater.inflate(R.layout.controller_main, container, false)

        setupTabs(view)

        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)

        val activity = (activity as MainActivity)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        activity.setSupportActionBar(toolbar)

        toolbar.title = activity.getString(R.string.app_name)
    }

    private fun setupTabs(view: View) {

        val viewPager = view.findViewById<ViewPager>(R.id.view_pager)

        viewPager.offscreenPageLimit = 3

        viewPager.adapter = ConductorPagerAdapter(this)

        view.findViewById<SmartTabLayout>(R.id.tabs_layout).setViewPager(viewPager)
    }
}
