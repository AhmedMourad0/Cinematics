package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.ImagesEntity

data class TaggedImages(
        @SerializedName(value = "results") var images: List<ImagesEntity>)
