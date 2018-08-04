package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = ReviewsEntity.TABLE_NAME,
        foreignKeys = [(ForeignKey(
                entity = MoviesEntity::class,
                parentColumns = [MoviesEntity.COLUMN_ID],
                childColumns = [ReviewsEntity.COLUMN_MOVIE_ID],
                onDelete = ForeignKey.CASCADE))],
        indices = [Index(
                value = [ReviewsEntity.COLUMN_MOVIE_ID, ReviewsEntity.COLUMN_URL],
                unique = true)])
data class ReviewsEntity(
        @SerializedName(value = "id") @PrimaryKey @ColumnInfo(name = COLUMN_ID) var id: String,
        @Transient @ColumnInfo(name = COLUMN_MOVIE_ID) var movieId: Long?,
        @SerializedName(value = "author") @ColumnInfo(name = COLUMN_AUTHOR) var author: String,
        @SerializedName(value = "content") @ColumnInfo(name = COLUMN_CONTENT) var content: String,
        @SerializedName(value = "url") @ColumnInfo(name = COLUMN_URL) var url: String) {

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "reviews"

        @Transient
        @Ignore
        const val COLUMN_ID = "id"

        @Transient
        @Ignore
        const val COLUMN_MOVIE_ID = "movie_id"

        @Transient
        @Ignore
        const val COLUMN_AUTHOR = "author"

        @Transient
        @Ignore
        const val COLUMN_CONTENT = "content"

        @Transient
        @Ignore
        const val COLUMN_URL = "url"
    }
}
