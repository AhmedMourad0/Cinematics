package inc.ahmedmourad.cinematics.mvvm.viewmodels.controllers

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.arch.lifecycle.LiveData
import inc.ahmedmourad.cinematics.mvvm.model.room.database.CinematicsDatabase
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity
import inc.ahmedmourad.cinematics.paging.PopularMoviesBoundaryCallback
import kotlinx.coroutines.experimental.runBlocking

class PopularMoviesViewModel(application: Application) : AndroidViewModel(application) {

    var moviesList: LiveData<PagedList<MoviesEntity>>? = null

    init {

        val config = PagedList.Config.Builder()
                .setPageSize(20)
                .setInitialLoadSizeHint(20)
                .setPrefetchDistance(10)
                .setEnablePlaceholders(true)
                .build()

        runBlocking {

            moviesList = LivePagedListBuilder(CinematicsDatabase.getInstance(application)
                    .popularMoviesDao()
                    .getMoviesDataSource(), config)
//                    .setBackgroundThreadExecutor(BackgroundThreadExecutor())
                    .setBoundaryCallback(PopularMoviesBoundaryCallback(application))
                    .build()
        }
    }
}
