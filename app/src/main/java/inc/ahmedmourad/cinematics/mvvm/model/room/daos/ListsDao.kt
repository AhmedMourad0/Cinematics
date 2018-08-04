package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import android.arch.persistence.room.Delete
import android.arch.persistence.room.OnConflictStrategy
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.ListsEntity

@Dao
interface ListsDao {

    @Query("SELECT ${ListsEntity.COLUMN_LIST_ID} FROM ${ListsEntity.TABLE_NAME}")
    fun getAllListIds() : List<Long>

    @Query("""
        SELECT
            ${ListsEntity.COLUMN_LIST_ID},
            ${ListsEntity.COLUMN_CREATED_BY},
            ${ListsEntity.COLUMN_ITEMS_COUNT},
            ${ListsEntity.COLUMN_POSTER_PATH},
            ${ListsEntity.COLUMN_NAME},
            ${ListsEntity.COLUMN_DESCRIPTION}
        FROM
            ${ListsEntity.TABLE_NAME}
        WHERE
            ${ListsEntity.COLUMN_LIST_ID}
        =
            :listId""")
    fun getListByListId(listId: Long) : ListsEntity

    @Query("DELETE FROM ${ListsEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(listsEntity: ListsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg listsEntities: ListsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(listsEntities: List<ListsEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg listsEntity: ListsEntity)

    @Delete
    fun delete(vararg listsEntity: ListsEntity)
}
