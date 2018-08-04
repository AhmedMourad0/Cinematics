package inc.ahmedmourad.cinematics.mvvm.view.controllers

import android.arch.lifecycle.Observer
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import inc.ahmedmourad.cinematics.R
import inc.ahmedmourad.cinematics.adapters.RecyclerAdapter
import inc.ahmedmourad.cinematics.callbacks.ClickListener
import inc.ahmedmourad.cinematics.callbacks.RecyclerTouchListener
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.PopularMoviesEntity
import inc.ahmedmourad.cinematics.mvvm.viewmodels.controllers.PopularMoviesViewModel
import inc.ahmedmourad.cinematics.paging.MoviesDiffCallback

class PopularMoviesController : BaseController() {

    private val viewModel by lazy { viewModelProvider().get(PopularMoviesViewModel::class.java) }

//    private val list = ArrayList<MoviesEntity>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        val view = inflater.inflate(R.layout.controller_popular_movies, container, false)

        val context = view.context

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        val recyclerAdapter = RecyclerAdapter(PopularMoviesEntity::class, R.layout.item_movie, MoviesDiffCallback())

        viewModel.moviesList?.observe(this, Observer {
            recyclerAdapter.setList(it)
        })

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isVerticalScrollBarEnabled = true
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = recyclerAdapter

//        val lifecycleOwner = this
//
//        var i = 0

//        launch(CommonPool) {
//
//            CinematicsDatabase.getInstance(context)
//                    .popularMoviesDao()
//                    .getMoviesByPage(1)
//                    .observe(lifecycleOwner, Observer {
//
//                        if (it != null) {
//
//                            list.addAll(it)
//                            recyclerAdapter.notifyDataSetChanged()
//
//                            Toast.makeText(context, "$i - by page: ${it.size}", Toast.LENGTH_LONG).show()
//
//                        } else {
//
//                            Toast.makeText(context, "$i - by page: 0", Toast.LENGTH_LONG).show()
//                        }
//
//                        launch(CommonPool) {
//
//                            val c = CinematicsDatabase.getInstance(context)
//                                    .popularMoviesDao()
//                                    .getCount()
//
//                            activity?.runOnUiThread { Toast.makeText(context, "$i - count: $c", Toast.LENGTH_LONG).show() }
//                        }
//
//                        ++i
//                    })
//
//            val count = CinematicsDatabase.getInstance(context)
//                    .popularMoviesDao()
//                    .getCount()
//
//            activity?.runOnUiThread { Toast.makeText(context, "count: $count", Toast.LENGTH_LONG).show() }
//
//        }

        recyclerView.addOnItemTouchListener(RecyclerTouchListener(context, recyclerView, object : ClickListener {

            override fun onClick(view: View, position: Int) {


            }

            override fun onLongClick(view: View, position: Int) {

            }
        }))

        return view
    }
}
