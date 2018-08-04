package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.NowPlayingMoviesEntity

data class NowPlayingMovies(
        @SerializedName(value = "results") var movies: List<MoviesEntity>) {

    @Transient
    var nowPlayingMovies: List<NowPlayingMoviesEntity>? = null
        get() = movies.map { NowPlayingMoviesEntity(it.id) }
}
