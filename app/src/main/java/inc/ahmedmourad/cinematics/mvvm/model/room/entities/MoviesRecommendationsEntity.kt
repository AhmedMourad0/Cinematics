package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = MoviesRecommendationsEntity.TABLE_NAME,
        foreignKeys = [
            ForeignKey(
                entity = MoviesEntity::class,
                parentColumns = [MoviesEntity.COLUMN_ID],
                childColumns = [MoviesRecommendationsEntity.COLUMN_MOVIE_ID],
                onDelete = ForeignKey.CASCADE),
            ForeignKey(
                entity = MoviesEntity::class,
                parentColumns = [MoviesEntity.COLUMN_ID],
                childColumns = [MoviesRecommendationsEntity.COLUMN_RECOMMENDATION_ID],
                onDelete = ForeignKey.NO_ACTION)],
        indices = [
            Index(
                value = [MoviesRecommendationsEntity.COLUMN_MOVIE_ID],
                unique = false),
            Index(
                value = [MoviesRecommendationsEntity.COLUMN_RECOMMENDATION_ID],
                unique = false),
            Index(
                value = [MoviesRecommendationsEntity.COLUMN_MOVIE_ID, MoviesRecommendationsEntity.COLUMN_RECOMMENDATION_ID],
                unique = true)])
data class MoviesRecommendationsEntity(
        @Transient @ColumnInfo(name = COLUMN_MOVIE_ID) var movieId: Long?,
        @SerializedName(value = "id") @ColumnInfo(name = COLUMN_RECOMMENDATION_ID) var recommendationId: Long) {

    @Transient
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long? = null

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "movies_recommendations"

        @Transient
        @Ignore
        const val COLUMN_ID = "id"

        @Transient
        @Ignore
        const val COLUMN_MOVIE_ID = "movie_id"

        @Transient
        @Ignore
        const val COLUMN_RECOMMENDATION_ID = "recommendation_id"
    }
}
