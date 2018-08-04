package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.*
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.ListsMoviesEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity

@Dao
interface ListsMoviesDao {

    @Query("""
        SELECT
            ${ListsMoviesEntity.COLUMN_ID},
            ${ListsMoviesEntity.COLUMN_LIST_ID},
            ${ListsMoviesEntity.COLUMN_ITEM_ID}
        FROM
            ${ListsMoviesEntity.TABLE_NAME}
        WHERE
            ${ListsMoviesEntity.COLUMN_ID}
        =
            :id""")
    fun getListsMoviesById(id: Long) : List<ListsMoviesEntity>

    @Query("""
        SELECT
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ID},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_POSTER_PATH},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_RELEASE_DATE},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ORIGINAL_TITLE},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ORIGINAL_LANGUAGE},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_VOTES_AVERAGE},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_VOTES_COUNT},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_BACKDROP_PATH},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_COLLECTION_INFO},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_PRODUCTION_COMPANIES},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_PRODUCTION_COUNTRIES},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_SPOKEN_LANGUAGES},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ALTERNATIVE_TITLES},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_IMDB_ID},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_IS_ADULT},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_OVERVIEW},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_POPULARITY},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_VIDEO},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_GENRES},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_BUDGET},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_HOMEPAGE},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_REVENUE},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_RUNTIME},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_STATUS},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_TAGLINE},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_KEYWORDS},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_TRANSLATIONS},
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_RELEASES}
        FROM
            ${ListsMoviesEntity.TABLE_NAME}
        INNER JOIN
            ${MoviesEntity.TABLE_NAME}
        ON
            ${ListsMoviesEntity.TABLE_NAME}.${ListsMoviesEntity.COLUMN_ITEM_ID}
        =
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ID}
        WHERE
            ${ListsMoviesEntity.TABLE_NAME}.${ListsMoviesEntity.COLUMN_LIST_ID}
        =
            :listId""")
    fun getMoviesByListId(listId: Long) : List<MoviesEntity>

    @Query("DELETE FROM ${ListsMoviesEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(collectionsMoviesEntity: ListsMoviesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg collectionsMoviesEntity: ListsMoviesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(collectionsMoviesEntity: List<ListsMoviesEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg collectionsMoviesEntity: ListsMoviesEntity)

    @Delete
    fun delete(vararg collectionsMoviesEntity: ListsMoviesEntity)
}
