package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.ReviewsEntity

data class Reviews(
        @SerializedName(value = "results") var reviews: List<ReviewsEntity>)
