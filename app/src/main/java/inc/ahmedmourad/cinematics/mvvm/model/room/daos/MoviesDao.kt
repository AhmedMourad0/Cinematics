package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import android.arch.persistence.room.Delete
import android.arch.persistence.room.OnConflictStrategy
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity

@Dao
interface MoviesDao {

    @Query("SELECT ${MoviesEntity.COLUMN_ID} FROM ${MoviesEntity.TABLE_NAME}")
    fun getAllIds() : List<Long>

    @Query("""
        SELECT
            ${MoviesEntity.COLUMN_ID},
            ${MoviesEntity.COLUMN_POSTER_PATH},
            ${MoviesEntity.COLUMN_RELEASE_DATE},
            ${MoviesEntity.COLUMN_ORIGINAL_TITLE},
            ${MoviesEntity.COLUMN_ORIGINAL_LANGUAGE},
            ${MoviesEntity.COLUMN_VOTES_AVERAGE},
            ${MoviesEntity.COLUMN_VOTES_COUNT},
            ${MoviesEntity.COLUMN_BACKDROP_PATH},
            ${MoviesEntity.COLUMN_COLLECTION_INFO},
            ${MoviesEntity.COLUMN_PRODUCTION_COMPANIES},
            ${MoviesEntity.COLUMN_PRODUCTION_COUNTRIES},
            ${MoviesEntity.COLUMN_SPOKEN_LANGUAGES},
            ${MoviesEntity.COLUMN_ALTERNATIVE_TITLES},
            ${MoviesEntity.COLUMN_IMDB_ID},
            ${MoviesEntity.COLUMN_IS_ADULT},
            ${MoviesEntity.COLUMN_OVERVIEW},
            ${MoviesEntity.COLUMN_POPULARITY},
            ${MoviesEntity.COLUMN_VIDEO},
            ${MoviesEntity.COLUMN_GENRES},
            ${MoviesEntity.COLUMN_BUDGET},
            ${MoviesEntity.COLUMN_HOMEPAGE},
            ${MoviesEntity.COLUMN_REVENUE},
            ${MoviesEntity.COLUMN_RUNTIME},
            ${MoviesEntity.COLUMN_STATUS},
            ${MoviesEntity.COLUMN_TAGLINE},
            ${MoviesEntity.COLUMN_KEYWORDS},
            ${MoviesEntity.COLUMN_TRANSLATIONS},
            ${MoviesEntity.COLUMN_RELEASES}
        FROM
            ${MoviesEntity.TABLE_NAME}
        WHERE
            ${MoviesEntity.COLUMN_ID}
        =
            :id""")
    fun getMovieById(id: Long) : MoviesEntity

    @Query("SELECT COUNT(*) FROM ${MoviesEntity.TABLE_NAME}")
    fun getCount() : Long

    @Query("DELETE FROM ${MoviesEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(moviesEntity: MoviesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg moviesEntities: MoviesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(moviesEntities: List<MoviesEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg moviesEntity: MoviesEntity)

    @Delete
    fun delete(vararg moviesEntity: MoviesEntity)
}
