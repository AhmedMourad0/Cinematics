package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import android.arch.persistence.room.Delete
import android.arch.persistence.room.OnConflictStrategy
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.NowPlayingMoviesEntity

@Dao
interface NowPlayingMoviesDao {

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
            ${NowPlayingMoviesEntity.TABLE_NAME}
        INNER JOIN
            ${MoviesEntity.TABLE_NAME}
        ON
            ${NowPlayingMoviesEntity.TABLE_NAME}.${NowPlayingMoviesEntity.COLUMN_MOVIE_ID}
        =
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ID}
        WHERE
            ${NowPlayingMoviesEntity.TABLE_NAME}.${NowPlayingMoviesEntity.COLUMN_ID}
        BETWEEN
            ((20 * (:page - 1)) + 1)
        AND
            (20 * :page)""")
    fun getMoviesByPage(page: Int): List<MoviesEntity>

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
            ${NowPlayingMoviesEntity.TABLE_NAME}
        INNER JOIN
            ${MoviesEntity.TABLE_NAME}
        ON
            ${NowPlayingMoviesEntity.TABLE_NAME}.${NowPlayingMoviesEntity.COLUMN_MOVIE_ID}
        =
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ID}
        WHERE
            ${NowPlayingMoviesEntity.TABLE_NAME}.${NowPlayingMoviesEntity.COLUMN_ID}
        =
            :id""")
    fun getMovieById(id: Long) : MoviesEntity

    @Query("""
        SELECT
            ${NowPlayingMoviesEntity.COLUMN_ID},
            ${NowPlayingMoviesEntity.COLUMN_MOVIE_ID}
        FROM
            ${NowPlayingMoviesEntity.TABLE_NAME}
        WHERE
            ${NowPlayingMoviesEntity.COLUMN_ID}
        =
            :id""")
    fun getNowPlayingMovieById(id: Long) : NowPlayingMoviesEntity

    @Query("SELECT COUNT(*) FROM ${NowPlayingMoviesEntity.TABLE_NAME}")
    fun getCount() : Long

    @Query("DELETE FROM ${NowPlayingMoviesEntity.TABLE_NAME}")
    fun deleteAll()

    @Query("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '${NowPlayingMoviesEntity.TABLE_NAME}'")
    fun resetIndex()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(nowPlayingMoviesEntity: NowPlayingMoviesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg nowPlayingMoviesEntities: NowPlayingMoviesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(nowPlayingMoviesEntities: List<NowPlayingMoviesEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg nowPlayingMoviesEntity: NowPlayingMoviesEntity)

    @Delete
    fun delete(vararg nowPlayingMoviesEntity: NowPlayingMoviesEntity)
}