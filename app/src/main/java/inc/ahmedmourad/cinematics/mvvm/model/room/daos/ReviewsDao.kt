package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.*
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.ReviewsEntity

@Dao
interface ReviewsDao {

    @Query("""
        SELECT
            ${ReviewsEntity.COLUMN_ID},
            ${ReviewsEntity.COLUMN_MOVIE_ID},
            ${ReviewsEntity.COLUMN_AUTHOR},
            ${ReviewsEntity.COLUMN_CONTENT},
            ${ReviewsEntity.COLUMN_URL}
        FROM
            ${ReviewsEntity.TABLE_NAME}
        WHERE
            ${ReviewsEntity.COLUMN_MOVIE_ID}
        =
            :movieId""")
    fun getReviewsByMovieId(movieId: Long) : List<ReviewsEntity>

    @Query("""
        SELECT
            ${ReviewsEntity.COLUMN_ID},
            ${ReviewsEntity.COLUMN_MOVIE_ID},
            ${ReviewsEntity.COLUMN_AUTHOR},
            ${ReviewsEntity.COLUMN_CONTENT},
            ${ReviewsEntity.COLUMN_URL}
        FROM
            ${ReviewsEntity.TABLE_NAME}
        WHERE
            ${ReviewsEntity.COLUMN_ID}
        =
            :id""")
    fun getReviewById(id: String) : ReviewsEntity

    @Query("DELETE FROM ${ReviewsEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(reviewsEntity: ReviewsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg reviewsEntities: ReviewsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(reviewsEntities: List<ReviewsEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg reviewsEntity: ReviewsEntity)

    @Delete
    fun delete(vararg reviewsEntity: ReviewsEntity)
}
