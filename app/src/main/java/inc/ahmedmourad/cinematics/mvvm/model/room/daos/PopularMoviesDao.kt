package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import android.arch.persistence.room.Delete
import android.arch.persistence.room.OnConflictStrategy
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.PopularMoviesEntity

@Dao
interface PopularMoviesDao {

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
            ${PopularMoviesEntity.TABLE_NAME}
        INNER JOIN
            ${MoviesEntity.TABLE_NAME}
        ON
            ${PopularMoviesEntity.TABLE_NAME}.${PopularMoviesEntity.COLUMN_MOVIE_ID}
        =
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ID}
        WHERE
            ${PopularMoviesEntity.TABLE_NAME}.${PopularMoviesEntity.COLUMN_ID}
        BETWEEN
            ((20 * (:page - 1)) + 1)
        AND
            (20 * :page)""")
    fun getMoviesByPage(page: Int): LiveData<List<MoviesEntity>>

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
            ${PopularMoviesEntity.TABLE_NAME}
        INNER JOIN
            ${MoviesEntity.TABLE_NAME}
        ON
            ${PopularMoviesEntity.TABLE_NAME}.${PopularMoviesEntity.COLUMN_MOVIE_ID}
        =
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ID}
        ORDER BY
            ${PopularMoviesEntity.TABLE_NAME}.${PopularMoviesEntity.COLUMN_ID}""")
    fun getMoviesDataSource(): DataSource.Factory<Int, MoviesEntity>

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
            ${PopularMoviesEntity.TABLE_NAME}
        INNER JOIN
            ${MoviesEntity.TABLE_NAME}
        ON
            ${PopularMoviesEntity.TABLE_NAME}.${PopularMoviesEntity.COLUMN_MOVIE_ID}
        =
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ID}
        WHERE
            ${PopularMoviesEntity.TABLE_NAME}.${PopularMoviesEntity.COLUMN_ID}
        =
            :id""")
    fun getMovieById(id: Long): MoviesEntity

    @Query("""
        SELECT
            ${PopularMoviesEntity.COLUMN_ID},
            ${PopularMoviesEntity.COLUMN_MOVIE_ID}
        FROM
            ${PopularMoviesEntity.TABLE_NAME}
        WHERE
            ${PopularMoviesEntity.COLUMN_ID}
        =
            :id""")
    fun getPopularMovieById(id: Long): PopularMoviesEntity

    @Query("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '${PopularMoviesEntity.TABLE_NAME}'")
    fun resetIndex()

    @Query("SELECT COUNT(*) FROM ${PopularMoviesEntity.TABLE_NAME}")
    fun getCount(): Long

    @Query("DELETE FROM ${PopularMoviesEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(popularMoviesEntity: PopularMoviesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg popularMoviesEntities: PopularMoviesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(popularMoviesEntities: List<PopularMoviesEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg popularMoviesEntity: PopularMoviesEntity)

    @Delete
    fun delete(vararg popularMoviesEntity: PopularMoviesEntity)
}