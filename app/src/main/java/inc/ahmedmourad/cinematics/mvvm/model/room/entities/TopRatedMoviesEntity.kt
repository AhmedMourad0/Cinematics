package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = TopRatedMoviesEntity.TABLE_NAME,
        foreignKeys = [ForeignKey(
                entity = MoviesEntity::class,
                parentColumns = [MoviesEntity.COLUMN_ID],
                childColumns = [TopRatedMoviesEntity.COLUMN_MOVIE_ID],
                onDelete = ForeignKey.CASCADE)],
        indices = [Index(
                value = [TopRatedMoviesEntity.COLUMN_MOVIE_ID],
                unique = true)])
data class TopRatedMoviesEntity(
        @SerializedName("id") @ColumnInfo(name = COLUMN_MOVIE_ID) var movieId: Long) {

    @Transient
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long? = null

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "top_rated_movies"

        @Transient
        @Ignore
        const val COLUMN_ID = "id"

        @Transient
        @Ignore
        const val COLUMN_MOVIE_ID = "movie_id"
    }
}
