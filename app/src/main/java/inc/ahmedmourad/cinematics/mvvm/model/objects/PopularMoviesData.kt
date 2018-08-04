package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.PopularMoviesEntity

data class PopularMovies(
        @SerializedName(value = "results") var movies: List<MoviesEntity>) {

    @Transient
    var popularMovies: List<PopularMoviesEntity>? = null
        get() = movies.map { PopularMoviesEntity(it.id) }
}
