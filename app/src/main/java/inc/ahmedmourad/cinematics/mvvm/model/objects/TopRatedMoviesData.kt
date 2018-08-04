package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.TopRatedMoviesEntity

data class TopRatedMovies(
        @SerializedName(value = "results") var movies: List<MoviesEntity>) {

    @Transient
    var topRatedMovies: List<TopRatedMoviesEntity>? = null
        get() = movies.map { TopRatedMoviesEntity(it.id) }
}
