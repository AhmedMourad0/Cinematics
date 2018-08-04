package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.ListsEntity

data class Lists(
        @SerializedName(value = "results") var lists: List<ListsEntity>)
