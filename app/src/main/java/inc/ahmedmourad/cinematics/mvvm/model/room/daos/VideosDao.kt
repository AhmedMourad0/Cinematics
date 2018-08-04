package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.*
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.VideosEntity

@Dao
interface VideosDao {

    @Query("""
        SELECT
            ${VideosEntity.COLUMN_ID},
            ${VideosEntity.COLUMN_MOVIE_ID},
            ${VideosEntity.COLUMN_KEY},
            ${VideosEntity.COLUMN_SIZE},
            ${VideosEntity.COLUMN_NAME},
            ${VideosEntity.COLUMN_TYPE},
            ${VideosEntity.COLUMN_SOURCE}
        FROM
            ${VideosEntity.TABLE_NAME}
        WHERE
            ${VideosEntity.COLUMN_MOVIE_ID}
        =
            :movieId""")
    fun getVideosByMovieId(movieId: Long) : List<VideosEntity>

    @Query("""
        SELECT
            ${VideosEntity.COLUMN_ID},
            ${VideosEntity.COLUMN_MOVIE_ID},
            ${VideosEntity.COLUMN_KEY},
            ${VideosEntity.COLUMN_SIZE},
            ${VideosEntity.COLUMN_NAME},
            ${VideosEntity.COLUMN_TYPE},
            ${VideosEntity.COLUMN_SOURCE}
        FROM
            ${VideosEntity.TABLE_NAME}
        WHERE
            ${VideosEntity.COLUMN_ID}
        =
            :id""")
    fun getVideoById(id: Long) : VideosEntity

    @Query("DELETE FROM ${VideosEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(videosEntity: VideosEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg videosEntities: VideosEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(videosEntities: List<VideosEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg videosEntity: VideosEntity)

    @Delete
    fun delete(vararg videosEntity: VideosEntity)
}