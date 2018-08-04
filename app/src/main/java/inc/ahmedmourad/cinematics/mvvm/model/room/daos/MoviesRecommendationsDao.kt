package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.*
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesRecommendationsEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity

@Dao
interface MoviesRecommendationsDao {

    @Query("""
        SELECT
            ${MoviesRecommendationsEntity.COLUMN_ID},
            ${MoviesRecommendationsEntity.COLUMN_MOVIE_ID},
            ${MoviesRecommendationsEntity.COLUMN_RECOMMENDATION_ID}
        FROM
            ${MoviesRecommendationsEntity.TABLE_NAME}
        WHERE
            ${MoviesRecommendationsEntity.COLUMN_ID}
        =
            :id""")
    fun getMoviesRecommendationsById(id: Long) : List<MoviesRecommendationsEntity>

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
            ${MoviesRecommendationsEntity.TABLE_NAME}
        INNER JOIN
            ${MoviesEntity.TABLE_NAME}
        ON
            ${MoviesRecommendationsEntity.TABLE_NAME}.${MoviesRecommendationsEntity.COLUMN_RECOMMENDATION_ID}
        =
            ${MoviesEntity.TABLE_NAME}.${MoviesEntity.COLUMN_ID}
        WHERE
            ${MoviesRecommendationsEntity.TABLE_NAME}.${MoviesRecommendationsEntity.COLUMN_MOVIE_ID}
        =
            :movieId""")
    fun getMoviesByMovieId(movieId: Long) : List<MoviesEntity>

    @Query("DELETE FROM ${MoviesRecommendationsEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(moviesRecommendationsEntity: MoviesRecommendationsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg moviesRecommendationsEntity: MoviesRecommendationsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(moviesRecommendationsEntity: List<MoviesRecommendationsEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg moviesRecommendationsEntity: MoviesRecommendationsEntity)

    @Delete
    fun delete(vararg moviesRecommendationsEntity: MoviesRecommendationsEntity)
}
