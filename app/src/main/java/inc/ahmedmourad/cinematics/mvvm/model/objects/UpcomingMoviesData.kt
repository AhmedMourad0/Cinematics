package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.UpcomingMoviesEntity

data class UpcomingMovies(
        @SerializedName(value = "results") var movies: List<MoviesEntity>) {

    @Transient
    var upcomingMovies: List<UpcomingMoviesEntity>? = null
        get() = movies.map { UpcomingMoviesEntity(it.id) }
}
