package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = VideosEntity.TABLE_NAME,
        foreignKeys = [(ForeignKey(
                entity = MoviesEntity::class,
                parentColumns = [MoviesEntity.COLUMN_ID],
                childColumns = [VideosEntity.COLUMN_MOVIE_ID],
                onDelete = ForeignKey.CASCADE))],
        indices = [Index(
                value = [VideosEntity.COLUMN_MOVIE_ID, VideosEntity.COLUMN_KEY],
                unique = true)])
data class VideosEntity(
        @Transient @ColumnInfo(name = COLUMN_MOVIE_ID) var movieId: Long?,
        @SerializedName(value = "source") @ColumnInfo(name = COLUMN_KEY) var key: String,
        @SerializedName(value = "size") @ColumnInfo(name = COLUMN_SIZE) var size: String,
        @SerializedName(value = "name") @ColumnInfo(name = COLUMN_NAME) var name: String,
        @SerializedName(value = "type") @ColumnInfo(name = COLUMN_TYPE) var type: String,
        @Transient @ColumnInfo(name = COLUMN_SOURCE) var source: Int?) {

    @Transient
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long? = null

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "videos"

        @Transient
        @Ignore
        const val COLUMN_ID = "id"

        @Transient
        @Ignore
        const val COLUMN_MOVIE_ID = "movie_id"

        @Transient
        @Ignore
        const val COLUMN_KEY = "key"

        @Transient
        @Ignore
        const val COLUMN_SIZE = "size"

        @Transient
        @Ignore
        const val COLUMN_NAME = "name"

        @Transient
        @Ignore
        const val COLUMN_TYPE = "type"

        @Transient
        @Ignore
        const val COLUMN_SOURCE = "source"

        @Transient
        @Ignore
        const val SOURCE_YOUTUBE = 0

        @Transient
        @Ignore
        const val SOURCE_QUICKTIME = 1
    }
}