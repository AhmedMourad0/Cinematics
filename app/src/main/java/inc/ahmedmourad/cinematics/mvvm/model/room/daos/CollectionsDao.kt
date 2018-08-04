package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import android.arch.persistence.room.Delete
import android.arch.persistence.room.OnConflictStrategy
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.CollectionsEntity

@Dao
interface CollectionsDao {

    @Query("SELECT ${CollectionsEntity.COLUMN_COLLECTION_ID} FROM ${CollectionsEntity.TABLE_NAME}")
    fun getAllCollectionIds() : List<Long>

    @Query("""
        SELECT
            ${CollectionsEntity.COLUMN_COLLECTION_ID},
            ${CollectionsEntity.COLUMN_POSTER_PATH},
            ${CollectionsEntity.COLUMN_BACKDROP_PATH},
            ${CollectionsEntity.COLUMN_NAME},
            ${CollectionsEntity.COLUMN_OVERVIEW}
        FROM
            ${CollectionsEntity.TABLE_NAME}
        WHERE
            ${CollectionsEntity.COLUMN_COLLECTION_ID}
        =
            :collectionId""")
    fun getCollectionByCollectionId(collectionId: Long) : CollectionsEntity

    @Query("DELETE FROM ${CollectionsEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(collectionsEntity: CollectionsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg collectionsEntities: CollectionsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(collectionsEntities: List<CollectionsEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg collectionsEntity: CollectionsEntity)

    @Delete
    fun delete(vararg collectionsEntity: CollectionsEntity)
}
