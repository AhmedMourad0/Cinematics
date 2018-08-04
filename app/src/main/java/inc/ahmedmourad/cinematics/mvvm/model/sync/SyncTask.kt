package inc.ahmedmourad.cinematics.mvvm.model.sync

import android.content.Context
import inc.ahmedmourad.cinematics.mvvm.model.api.ApiClient
import inc.ahmedmourad.cinematics.mvvm.model.api.ApiInterface
import inc.ahmedmourad.cinematics.mvvm.model.room.database.CinematicsDatabase
import inc.ahmedmourad.cinematics.utils.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

object SyncTask {

    @Synchronized
    fun sync(context: Context) {

        launch(CommonPool) {

            val db = CinematicsDatabase.getInstance(context)

            val client = ApiClient.getInstance().create(ApiInterface::class.java)

            db.reset(context)

            when (defaultPrefs(context)[KEY_SOURCE, SOURCE_MOVIES]) {

                SOURCE_MOVIES -> fetchMoviesData(context, client, db)

                else -> fetchMoviesData(context, client, db)
            }
        }
    }

    private fun fetchMoviesData(context: Context, client: ApiInterface, db: CinematicsDatabase) {

        fetchPopularMoviesData(context, client, db, 1)

        fetchTopRatedMoviesData(context, client, db, 1)

        fetchNowPlayingMoviesData(context, client, db, 1)

        fetchUpcomingMoviesData(context, client, db, 1)
    }
}
