package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.objects.Media

@Entity(tableName = ImagesEntity.TABLE_NAME,
        foreignKeys = [
            ForeignKey(
                    entity = MoviesEntity::class,
                    parentColumns = [MoviesEntity.COLUMN_ID],
                    childColumns = [ImagesEntity.COLUMN_MOVIE_ID],
                    onDelete = ForeignKey.CASCADE),
            ForeignKey(
                    entity = CollectionsEntity::class,
                    parentColumns = [CollectionsEntity.COLUMN_COLLECTION_ID],
                    childColumns = [ImagesEntity.COLUMN_COLLECTION_ID],
                    onDelete = ForeignKey.CASCADE),
            ForeignKey(
                    entity = PersonsEntity::class,
                    parentColumns = [PersonsEntity.COLUMN_PERSON_ID],
                    childColumns = [ImagesEntity.COLUMN_PERSON_ID],
                    onDelete = ForeignKey.CASCADE)],
        indices = [
            Index(value = [ImagesEntity.COLUMN_FILE_PATH], unique = true),
            Index(value = [ImagesEntity.COLUMN_MOVIE_ID], unique = false),
            Index(value = [ImagesEntity.COLUMN_COLLECTION_ID], unique = false),
            Index(value = [ImagesEntity.COLUMN_PERSON_ID], unique = false)])
data class ImagesEntity(
        @Transient @ColumnInfo(name = COLUMN_MOVIE_ID) var movieId: Long?,
        @Transient @ColumnInfo(name = COLUMN_COLLECTION_ID) var collectionId: Long?,
        @Transient @ColumnInfo(name = COLUMN_PERSON_ID) var personId: Long?,
        @SerializedName(value = "file_path") @ColumnInfo(name = COLUMN_FILE_PATH) var filePath: String,
        @SerializedName(value = "aspect_ratio") @ColumnInfo(name = COLUMN_ASPECT_RATIO) var aspectRatio: Double,
        @SerializedName(value = "vote_average") @ColumnInfo(name = COLUMN_VOTES_AVERAGE) var voteAverage: Double,
        @SerializedName(value = "vote_count") @ColumnInfo(name = COLUMN_VOTES_COUNT) var voteCount: Long,
        @SerializedName(value = "media_type") @ColumnInfo(name = COLUMN_MEDIA_TYPE) var mediaType: String?,
        @SerializedName(value = "media") @ColumnInfo(name = COLUMN_MEDIA) var media: Media?,
        @SerializedName(value = "width") @ColumnInfo(name = COLUMN_WIDTH) var width: Long,
        @SerializedName(value = "height") @ColumnInfo(name = COLUMN_HEIGHT) var height: Long,
        @Transient @ColumnInfo(name = COLUMN_TYPE) var type: Int) {

    @Transient
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long? = null

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "images"

        @Transient
        @Ignore
        const val COLUMN_ID = "id"

        @Transient
        @Ignore
        const val COLUMN_MOVIE_ID = "movie_id"

        @Transient
        @Ignore
        const val COLUMN_COLLECTION_ID = "collection_id"

        @Transient
        @Ignore
        const val COLUMN_PERSON_ID = "person_id"

        @Transient
        @Ignore
        const val COLUMN_FILE_PATH = "file_path"

        @Transient
        @Ignore
        const val COLUMN_ASPECT_RATIO = "aspect_ratio"

        @Transient
        @Ignore
        const val COLUMN_VOTES_AVERAGE = "vote_average"

        @Transient
        @Ignore
        const val COLUMN_VOTES_COUNT = "vote_count"

        @Transient
        @Ignore
        const val COLUMN_MEDIA_TYPE = "media_type"

        @Transient
        @Ignore
        const val COLUMN_MEDIA = "media"

        @Transient
        @Ignore
        const val COLUMN_WIDTH = "width"

        @Transient
        @Ignore
        const val COLUMN_HEIGHT = "height"

        @Transient
        @Ignore
        const val COLUMN_TYPE = "type"

        @Transient
        @Ignore
        const val TYPE_POSTER = 0

        @Transient
        @Ignore
        const val TYPE_BACKDROP = 1

        @Transient
        @Ignore
        const val TYPE_PROFILE = 2
    }
}
