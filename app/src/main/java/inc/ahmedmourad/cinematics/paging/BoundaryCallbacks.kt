package inc.ahmedmourad.cinematics.paging

import android.arch.paging.PagedList
import android.content.Context
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity
import inc.ahmedmourad.cinematics.mvvm.model.sync.SyncUtils
import inc.ahmedmourad.cinematics.utils.*

class PopularMoviesBoundaryCallback(val context: Context) : PagedList.BoundaryCallback<MoviesEntity>() {

    override fun onZeroItemsLoaded() = SyncUtils.initialize(context)

    override fun onItemAtEndLoaded(itemAtEnd: MoviesEntity) {

        val prefs = defaultPrefs(context)

        fetchPopularMoviesData(context = context, page = prefs[KEY_PAGE_POPULAR, 1] + 1)

        prefs[KEY_PAGE_POPULAR] = prefs[KEY_PAGE_POPULAR, 1] + 1
    }
}
