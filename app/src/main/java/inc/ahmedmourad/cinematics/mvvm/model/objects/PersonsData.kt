package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.CastMembersEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.CrewMembersEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.ImagesEntity

data class PersonCredits(
        @SerializedName(value = "cast") var castMembers: List<CastMembersEntity>,
        @SerializedName(value = "crew") var crewMembers: List<CrewMembersEntity>)

data class PersonImages(
        @SerializedName(value = "profiles") var profiles: List<ImagesEntity>)

data class PersonTaggedImages(
        @SerializedName(value = "results") var images: List<ImagesEntity>)
