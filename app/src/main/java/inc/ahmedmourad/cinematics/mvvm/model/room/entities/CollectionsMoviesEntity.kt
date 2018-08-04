package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = CollectionsMoviesEntity.TABLE_NAME,
        foreignKeys = [
            ForeignKey(
                entity = CollectionsEntity::class,
                parentColumns = [CollectionsEntity.COLUMN_COLLECTION_ID],
                childColumns = [CollectionsMoviesEntity.COLUMN_COLLECTION_ID],
                onDelete = ForeignKey.CASCADE),
            ForeignKey(
                entity = MoviesEntity::class,
                parentColumns = [MoviesEntity.COLUMN_ID],
                childColumns = [CollectionsMoviesEntity.COLUMN_PART_ID],
                onDelete = ForeignKey.NO_ACTION)],
        indices = [
            Index(
                value = [CollectionsMoviesEntity.COLUMN_COLLECTION_ID],
                unique = false),
            Index(
                value = [CollectionsMoviesEntity.COLUMN_PART_ID],
                unique = false),
            Index(
                value = [CollectionsMoviesEntity.COLUMN_COLLECTION_ID, CollectionsMoviesEntity.COLUMN_PART_ID],
                unique = true)])
data class CollectionsMoviesEntity(
        @Transient @ColumnInfo(name = COLUMN_COLLECTION_ID) var collectionId: Long,
        @SerializedName("id") @ColumnInfo(name = COLUMN_PART_ID) var partId: Long) {

    @Transient
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long? = null

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "collections_movies"

        @Transient
        @Ignore
        const val COLUMN_ID = "id"

        @Transient
        @Ignore
        const val COLUMN_COLLECTION_ID = "collection_id"

        @Transient
        @Ignore
        const val COLUMN_PART_ID = "part_id"
    }
}
