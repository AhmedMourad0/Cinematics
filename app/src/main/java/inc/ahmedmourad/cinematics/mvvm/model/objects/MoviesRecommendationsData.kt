package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesRecommendationsEntity

data class Recommendations(
        @SerializedName(value = "results") var recommendations: List<MoviesRecommendationsEntity>)
