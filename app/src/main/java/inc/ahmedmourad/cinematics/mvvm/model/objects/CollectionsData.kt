package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.*

data class CollectionImages(
        @SerializedName(value = "backdrops") var backdrops: List<ImagesEntity>,
        @SerializedName(value = "posters") var posters: List<ImagesEntity>)