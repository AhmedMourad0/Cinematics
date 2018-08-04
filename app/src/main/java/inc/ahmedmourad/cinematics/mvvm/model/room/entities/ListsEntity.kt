package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = ListsEntity.TABLE_NAME)
class ListsEntity @Ignore private constructor() {

    @SerializedName(value = "id")
    @PrimaryKey
    @ColumnInfo(name = COLUMN_LIST_ID)
    var listId = -1L

    @SerializedName(value = "created_by")
    @ColumnInfo(name = COLUMN_CREATED_BY)
    var createdBy: String? = null

    @SerializedName(value = "item_count")
    @ColumnInfo(name = COLUMN_ITEMS_COUNT)
    var itemsCount = -1

    @SerializedName(value = "poster_path")
    @ColumnInfo(name = COLUMN_POSTER_PATH)
    var posterPath: String? = null

    @SerializedName(value = "name")
    @ColumnInfo(name = COLUMN_NAME)
    var name = ""

    @SerializedName(value = "description")
    @ColumnInfo(name = COLUMN_DESCRIPTION)
    var description: String? = null

    @SerializedName(value = "items")
    @Ignore
    var items: List<ListsMoviesEntity>? = null

    constructor(
            listId: Long, createdBy: String?, itemsCount: Int, posterPath: String?, name: String,
            description: String?) : this() {

        this.listId = listId
        this.createdBy = createdBy
        this.itemsCount = itemsCount
        this.posterPath = posterPath
        this.name = name
        this.description = description
    }

    @Ignore
    constructor(
            listId: Long, createdBy: String?, itemsCount: Int, posterPath: String?, name: String,
            description: String?, items: List<ListsMoviesEntity>?) : this() {
        this.listId = listId
        this.createdBy = createdBy
        this.itemsCount = itemsCount
        this.posterPath = posterPath
        this.name = name
        this.description = description
        this.items = items
    }

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "lists"

        @Transient
        @Ignore
        const val COLUMN_LIST_ID = "list_id"

        @Transient
        @Ignore
        const val COLUMN_CREATED_BY = "created_by"

        @Transient
        @Ignore
        const val COLUMN_ITEMS_COUNT = "items_count"

        @Transient
        @Ignore
        const val COLUMN_POSTER_PATH = "poster_path"

        @Transient
        @Ignore
        const val COLUMN_NAME = "name"

        @Transient
        @Ignore
        const val COLUMN_DESCRIPTION = "description"
    }
}