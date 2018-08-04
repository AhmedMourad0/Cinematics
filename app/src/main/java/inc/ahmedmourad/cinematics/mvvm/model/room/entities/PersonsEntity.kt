package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.objects.PersonCredits
import inc.ahmedmourad.cinematics.mvvm.model.objects.PersonImages
import inc.ahmedmourad.cinematics.mvvm.model.objects.PersonTaggedImages

@Entity(tableName = PersonsEntity.TABLE_NAME,
        indices = [Index(
                value = [PersonsEntity.COLUMN_IMDB_ID],
                unique = true)])
class PersonsEntity @Ignore private constructor() {

    @SerializedName(value = "id")
    @PrimaryKey
    @ColumnInfo(name = COLUMN_PERSON_ID)
    var personId = -1L

    @SerializedName(value = "also_known_as")
    @ColumnInfo(name = COLUMN_ALSO_KNOWN_AS)
    var alsoKnownAs: List<String>? = null

    @SerializedName(value = "place_of_birth")
    @ColumnInfo(name = COLUMN_PLACE_OF_BIRTH)
    var placeOfBirth: String? = null

    @SerializedName(value = "profile_path")
    @ColumnInfo(name = COLUMN_PROFILE_PATH)
    var profilePath: String? = null

    @SerializedName(value = "imdb_id")
    @ColumnInfo(name = COLUMN_IMDB_ID)
    var imdbId = ""

    @SerializedName(value = "name")
    @ColumnInfo(name = COLUMN_NAME)
    var name = ""

    @SerializedName(value = "isAdult")
    @ColumnInfo(name = COLUMN_ADULT)
    var adult: Boolean? = null

    @SerializedName(value = "biography")
    @ColumnInfo(name = COLUMN_BIOGRAPHY)
    var biography = ""

    @SerializedName(value = "birthday")
    @ColumnInfo(name = COLUMN_BIRTHDAY)
    var birthday: String? = null

    @SerializedName(value = "deathday")
    @ColumnInfo(name = COLUMN_DEATHDAY)
    var deathday: String? = null

    @SerializedName(value = "gender")
    @ColumnInfo(name = COLUMN_GENDER)
    var gender: Int? = null

    @SerializedName(value = "homepage")
    @ColumnInfo(name = COLUMN_HOMEPAGE)
    var homepage: String? = null

    @SerializedName(value = "popularity")
    @ColumnInfo(name = COLUMN_POPULARITY)
    var popularity: Double? = null

    @SerializedName(value = "credits")
    @Ignore
    var credits: PersonCredits? = null

    @SerializedName(value = "images")
    @Ignore
    var images: PersonImages? = null

    @SerializedName(value = "tagged_images")
    @Ignore
    var taggedImages: PersonTaggedImages? = null

    constructor(
            personId: Long, alsoKnownAs: List<String>?, placeOfBirth: String?, profilePath: String?,
            imdbId: String, name: String, adult: Boolean?, biography: String, birthday: String?,
            deathday: String?, gender: Int?, homepage: String?, popularity: Double?) : this() {

        this.personId = personId
        this.alsoKnownAs = alsoKnownAs
        this.placeOfBirth = placeOfBirth
        this.profilePath = profilePath
        this.imdbId = imdbId
        this.name = name
        this.adult = adult
        this.biography = biography
        this.birthday = birthday
        this.deathday = deathday
        this.gender = gender
        this.homepage = homepage
        this.popularity = popularity
    }

    @Ignore
    constructor(
            personId: Long, alsoKnownAs: List<String>?, placeOfBirth: String?, profilePath: String?,
            imdbId: String, name: String, adult: Boolean?, biography: String, birthday: String?,
            deathday: String?, gender: Int?, homepage: String?, popularity: Double?, credits: PersonCredits?,
            images: PersonImages?, taggedImages: PersonTaggedImages?) : this() {

        this.personId = personId
        this.alsoKnownAs = alsoKnownAs
        this.placeOfBirth = placeOfBirth
        this.profilePath = profilePath
        this.imdbId = imdbId
        this.name = name
        this.adult = adult
        this.biography = biography
        this.birthday = birthday
        this.deathday = deathday
        this.gender = gender
        this.homepage = homepage
        this.popularity = popularity
        this.credits = credits
        this.images = images
        this.taggedImages = taggedImages
    }

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "persons"

        @Transient
        @Ignore
        const val COLUMN_PERSON_ID = "person_id"

        @Transient
        @Ignore
        const val COLUMN_ALSO_KNOWN_AS = "also_known_as"

        @Transient
        @Ignore
        const val COLUMN_PLACE_OF_BIRTH = "place_of_birth"

        @Transient
        @Ignore
        const val COLUMN_PROFILE_PATH = "profile_path"

        @Transient
        @Ignore
        const val COLUMN_IMDB_ID = "imdb_id"

        @Transient
        @Ignore
        const val COLUMN_NAME = "name"

        @Transient
        @Ignore
        const val COLUMN_ADULT = "isAdult"

        @Transient
        @Ignore
        const val COLUMN_BIOGRAPHY = "biography"

        @Transient
        @Ignore
        const val COLUMN_BIRTHDAY = "birthday"

        @Transient
        @Ignore
        const val COLUMN_DEATHDAY = "deathday"

        @Transient
        @Ignore
        const val COLUMN_GENDER = "gender"

        @Transient
        @Ignore
        const val COLUMN_HOMEPAGE = "homepage"

        @Transient
        @Ignore
        const val COLUMN_POPULARITY = "popularity"

        @Transient
        @Ignore
        const val GENDER_NOT_AVAILABLE = 0

        @Transient
        @Ignore
        const val GENDER_FEMALE = 1

        @Transient
        @Ignore
        const val GENDER_MALE = 2
    }
}