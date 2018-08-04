package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.*
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesListsEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.ListsEntity

@Dao
interface MoviesListsDao {

    @Query("""
        SELECT
            ${MoviesListsEntity.COLUMN_ID},
            ${MoviesListsEntity.COLUMN_MOVIE_ID},
            ${MoviesListsEntity.COLUMN_LIST_ID}
        FROM
            ${MoviesListsEntity.TABLE_NAME}
        WHERE
            ${MoviesListsEntity.COLUMN_ID}
        =
            :id""")
    fun getMoviesListsById(id: Long) : List<MoviesListsEntity>

    @Query("""
        SELECT
            ${ListsEntity.TABLE_NAME}.${ListsEntity.COLUMN_LIST_ID},
            ${ListsEntity.TABLE_NAME}.${ListsEntity.COLUMN_CREATED_BY},
            ${ListsEntity.TABLE_NAME}.${ListsEntity.COLUMN_ITEMS_COUNT},
            ${ListsEntity.TABLE_NAME}.${ListsEntity.COLUMN_POSTER_PATH},
            ${ListsEntity.TABLE_NAME}.${ListsEntity.COLUMN_NAME},
            ${ListsEntity.TABLE_NAME}.${ListsEntity.COLUMN_DESCRIPTION}
        FROM
            ${MoviesListsEntity.TABLE_NAME}
        INNER JOIN
            ${ListsEntity.TABLE_NAME}
        ON
            ${MoviesListsEntity.TABLE_NAME}.${MoviesListsEntity.COLUMN_LIST_ID}
        =
            ${ListsEntity.TABLE_NAME}.${ListsEntity.COLUMN_LIST_ID}
        WHERE
            ${MoviesListsEntity.TABLE_NAME}.${MoviesListsEntity.COLUMN_MOVIE_ID}
        =
            :movieId""")
    fun getListsByMovieId(movieId: Long) : List<ListsEntity>

    @Query("DELETE FROM ${MoviesListsEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(moviesListsEntity: MoviesListsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg moviesListsEntity: MoviesListsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(moviesListsEntity: List<MoviesListsEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg moviesListsEntity: MoviesListsEntity)

    @Delete
    fun delete(vararg moviesListsEntity: MoviesListsEntity)
}
