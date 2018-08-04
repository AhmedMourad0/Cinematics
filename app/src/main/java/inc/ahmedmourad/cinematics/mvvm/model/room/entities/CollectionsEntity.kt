package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.objects.CollectionImages

@Entity(tableName = CollectionsEntity.TABLE_NAME)
class CollectionsEntity @Ignore private constructor() {

    @SerializedName(value = "id")
    @PrimaryKey
    @ColumnInfo(name = COLUMN_COLLECTION_ID)
    var collectionId = -1L

    @SerializedName(value = "poster_path")
    @ColumnInfo(name = COLUMN_POSTER_PATH)
    var posterPath = ""

    @SerializedName(value = "backdrop_path")
    @ColumnInfo(name = COLUMN_BACKDROP_PATH)
    var backdropPath = ""

    @SerializedName(value = "name")
    @ColumnInfo(name = COLUMN_NAME)
    var name = ""

    @SerializedName(value = "overview")
    @ColumnInfo(name = COLUMN_OVERVIEW)
    var overview = ""

    @SerializedName(value = "parts")
    @Ignore
    var movies: List<CollectionsMoviesEntity>? = null

    @SerializedName(value = "images")
    @Ignore
    var images: CollectionImages? = null

    constructor(
            collectionId: Long, posterPath: String, backdropPath: String, name: String, overview: String) : this() {

        this.collectionId = collectionId
        this.posterPath = posterPath
        this.backdropPath = backdropPath
        this.name = name
        this.overview = overview
    }

    @Ignore
    constructor(
            collectionId: Long, posterPath: String, backdropPath: String, name: String, overview: String,
            movies: List<CollectionsMoviesEntity>?, images: CollectionImages?) : this() {

        this.collectionId = collectionId
        this.posterPath = posterPath
        this.backdropPath = backdropPath
        this.name = name
        this.overview = overview
        this.movies = movies
        this.images = images
    }

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "collections"

        @Transient
        @Ignore
        const val COLUMN_COLLECTION_ID = "collection_id"

        @Transient
        @Ignore
        const val COLUMN_POSTER_PATH = "poster_path"

        @Transient
        @Ignore
        const val COLUMN_BACKDROP_PATH = "backdrop_path"

        @Transient
        @Ignore
        const val COLUMN_NAME = "name"

        @Transient
        @Ignore
        const val COLUMN_OVERVIEW = "overview"
    }
}