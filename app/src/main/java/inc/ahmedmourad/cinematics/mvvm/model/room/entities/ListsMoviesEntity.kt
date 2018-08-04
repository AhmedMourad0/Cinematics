package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = ListsMoviesEntity.TABLE_NAME,
        foreignKeys = [
            ForeignKey(
                entity = ListsEntity::class,
                parentColumns = [ListsEntity.COLUMN_LIST_ID],
                childColumns = [ListsMoviesEntity.COLUMN_LIST_ID],
                onDelete = ForeignKey.CASCADE),
            ForeignKey(
                entity = MoviesEntity::class,
                parentColumns = [MoviesEntity.COLUMN_ID],
                childColumns = [ListsMoviesEntity.COLUMN_ITEM_ID],
                onDelete = ForeignKey.NO_ACTION)],
        indices = [
            Index(
                value = [ListsMoviesEntity.COLUMN_LIST_ID],
                unique = false),
            Index(
                value = [ListsMoviesEntity.COLUMN_ITEM_ID],
                unique = false),
            Index(
                value = [ListsMoviesEntity.COLUMN_LIST_ID, ListsMoviesEntity.COLUMN_ITEM_ID],
                unique = true)])
data class ListsMoviesEntity(
        @Transient @ColumnInfo(name = COLUMN_LIST_ID) var listId: Long,
        @SerializedName(value = "id") @ColumnInfo(name = COLUMN_ITEM_ID) var itemId: Long) {

    @Transient
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long? = null

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "lists_movies"

        @Transient
        @Ignore
        const val COLUMN_ID = "id"

        @Transient
        @Ignore
        const val COLUMN_LIST_ID = "list_id"

        @Transient
        @Ignore
        const val COLUMN_ITEM_ID = "item_id"
    }
}
