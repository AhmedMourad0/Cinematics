package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesSimilarsEntity

data class Similars(
        @SerializedName(value = "results") var reviews: List<MoviesSimilarsEntity>)
