package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = MoviesListsEntity.TABLE_NAME,
        foreignKeys = [
            ForeignKey(
                entity = MoviesEntity::class,
                parentColumns = [MoviesEntity.COLUMN_ID],
                childColumns = [MoviesListsEntity.COLUMN_MOVIE_ID],
                onDelete = ForeignKey.CASCADE),
            ForeignKey(
                entity = ListsEntity::class,
                parentColumns = [ListsEntity.COLUMN_LIST_ID],
                childColumns = [MoviesListsEntity.COLUMN_LIST_ID],
                onDelete = ForeignKey.NO_ACTION)],
        indices = [
            Index(
                value = [MoviesListsEntity.COLUMN_MOVIE_ID],
                unique = false),
            Index(
                value = [MoviesListsEntity.COLUMN_LIST_ID],
                unique = false),
            Index(
                value = [MoviesListsEntity.COLUMN_MOVIE_ID, MoviesListsEntity.COLUMN_LIST_ID],
                unique = true)])
data class MoviesListsEntity(
        @Transient @ColumnInfo(name = COLUMN_MOVIE_ID) var movieId: Long,
        @SerializedName(value = "id") @ColumnInfo(name = COLUMN_LIST_ID) var listId: Long) {

    @Transient
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long? = null

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "movies_lists"

        @Transient
        @Ignore
        const val COLUMN_ID = "id"

        @Transient
        @Ignore
        const val COLUMN_MOVIE_ID = "movie_id"

        @Transient
        @Ignore
        const val COLUMN_LIST_ID = "list_id"
    }
}
