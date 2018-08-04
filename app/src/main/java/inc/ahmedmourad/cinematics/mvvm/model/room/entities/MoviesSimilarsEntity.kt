package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = MoviesSimilarsEntity.TABLE_NAME,
        foreignKeys = [
            ForeignKey(
                entity = MoviesEntity::class,
                parentColumns = [MoviesEntity.COLUMN_ID],
                childColumns = [MoviesSimilarsEntity.COLUMN_MOVIE_ID],
                onDelete = ForeignKey.CASCADE),
            ForeignKey(
                entity = MoviesEntity::class,
                parentColumns = [MoviesEntity.COLUMN_ID],
                childColumns = [MoviesSimilarsEntity.COLUMN_SIMILAR_ID],
                onDelete = ForeignKey.NO_ACTION)],
        indices = [
            Index(
                value = [MoviesSimilarsEntity.COLUMN_MOVIE_ID],
                unique = false),
            Index(
                value = [MoviesSimilarsEntity.COLUMN_SIMILAR_ID],
                unique = false),
            Index(
                value = [MoviesSimilarsEntity.COLUMN_MOVIE_ID, MoviesSimilarsEntity.COLUMN_SIMILAR_ID],
                unique = true)])
data class MoviesSimilarsEntity(
        @Transient @ColumnInfo(name = COLUMN_MOVIE_ID) var movieId: Long?,
        @SerializedName(value = "id") @ColumnInfo(name = COLUMN_SIMILAR_ID) var similarId: Long) {

    @Transient
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long? = null

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "movies_similars"

        @Transient
        @Ignore
        const val COLUMN_ID = "id"

        @Transient
        @Ignore
        const val COLUMN_MOVIE_ID = "movie_id"

        @Transient
        @Ignore
        const val COLUMN_SIMILAR_ID = "similar_id"
    }
}
