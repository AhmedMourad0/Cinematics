package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.*
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.ImagesEntity

@Dao
interface ImagesDao {

    @Query("""
        SELECT
            ${ImagesEntity.COLUMN_ID},
            ${ImagesEntity.COLUMN_MOVIE_ID},
            ${ImagesEntity.COLUMN_PERSON_ID},
            ${ImagesEntity.COLUMN_COLLECTION_ID},
            ${ImagesEntity.COLUMN_FILE_PATH},
            ${ImagesEntity.COLUMN_ASPECT_RATIO},
            ${ImagesEntity.COLUMN_VOTES_AVERAGE},
            ${ImagesEntity.COLUMN_VOTES_COUNT},
            ${ImagesEntity.COLUMN_MEDIA_TYPE},
            ${ImagesEntity.COLUMN_MEDIA},
            ${ImagesEntity.COLUMN_WIDTH},
            ${ImagesEntity.COLUMN_HEIGHT},
            ${ImagesEntity.COLUMN_TYPE}
        FROM
            ${ImagesEntity.TABLE_NAME}
        WHERE
            ${ImagesEntity.COLUMN_PERSON_ID}
        =
            :personId
        AND
            ${ImagesEntity.COLUMN_TYPE}
        !=
            ${ImagesEntity.TYPE_PROFILE}""")
    fun getMovieImagesByPersonId(personId: Long) : List<ImagesEntity>

    @Query("""
        SELECT
            ${ImagesEntity.COLUMN_ID},
            ${ImagesEntity.COLUMN_MOVIE_ID},
            ${ImagesEntity.COLUMN_PERSON_ID},
            ${ImagesEntity.COLUMN_COLLECTION_ID},
            ${ImagesEntity.COLUMN_FILE_PATH},
            ${ImagesEntity.COLUMN_ASPECT_RATIO},
            ${ImagesEntity.COLUMN_VOTES_AVERAGE},
            ${ImagesEntity.COLUMN_VOTES_COUNT},
            ${ImagesEntity.COLUMN_MEDIA_TYPE},
            ${ImagesEntity.COLUMN_MEDIA},
            ${ImagesEntity.COLUMN_WIDTH},
            ${ImagesEntity.COLUMN_HEIGHT},
            ${ImagesEntity.COLUMN_TYPE}
        FROM
            ${ImagesEntity.TABLE_NAME}
        WHERE
            ${ImagesEntity.COLUMN_PERSON_ID}
        =
            :personId
        AND
            ${ImagesEntity.COLUMN_TYPE}
        =
            ${ImagesEntity.TYPE_PROFILE}""")
    fun getImagesByPersonId(personId: Long) : List<ImagesEntity>

    @Query("""
        SELECT
            ${ImagesEntity.COLUMN_ID},
            ${ImagesEntity.COLUMN_MOVIE_ID},
            ${ImagesEntity.COLUMN_PERSON_ID},
            ${ImagesEntity.COLUMN_COLLECTION_ID},
            ${ImagesEntity.COLUMN_FILE_PATH},
            ${ImagesEntity.COLUMN_ASPECT_RATIO},
            ${ImagesEntity.COLUMN_VOTES_AVERAGE},
            ${ImagesEntity.COLUMN_VOTES_COUNT},
            ${ImagesEntity.COLUMN_MEDIA_TYPE},
            ${ImagesEntity.COLUMN_MEDIA},
            ${ImagesEntity.COLUMN_WIDTH},
            ${ImagesEntity.COLUMN_HEIGHT},
            ${ImagesEntity.COLUMN_TYPE}
        FROM
            ${ImagesEntity.TABLE_NAME}
        WHERE
            ${ImagesEntity.COLUMN_MOVIE_ID}
        =
            :movieId""")
    fun getImagesByMovieId(movieId: Long) : List<ImagesEntity>

    @Query("""
        SELECT
            ${ImagesEntity.COLUMN_ID},
            ${ImagesEntity.COLUMN_MOVIE_ID},
            ${ImagesEntity.COLUMN_PERSON_ID},
            ${ImagesEntity.COLUMN_COLLECTION_ID},
            ${ImagesEntity.COLUMN_FILE_PATH},
            ${ImagesEntity.COLUMN_ASPECT_RATIO},
            ${ImagesEntity.COLUMN_VOTES_AVERAGE},
            ${ImagesEntity.COLUMN_VOTES_COUNT},
            ${ImagesEntity.COLUMN_MEDIA_TYPE},
            ${ImagesEntity.COLUMN_MEDIA},
            ${ImagesEntity.COLUMN_WIDTH},
            ${ImagesEntity.COLUMN_HEIGHT},
            ${ImagesEntity.COLUMN_TYPE}
        FROM
            ${ImagesEntity.TABLE_NAME}
        WHERE
            ${ImagesEntity.COLUMN_COLLECTION_ID}
        =
            :collectionId""")
    fun getImagesByCollectionId(collectionId: Long) : List<ImagesEntity>

    @Query("""
        SELECT
            ${ImagesEntity.COLUMN_ID},
            ${ImagesEntity.COLUMN_MOVIE_ID},
            ${ImagesEntity.COLUMN_COLLECTION_ID},
            ${ImagesEntity.COLUMN_PERSON_ID},
            ${ImagesEntity.COLUMN_FILE_PATH},
            ${ImagesEntity.COLUMN_ASPECT_RATIO},
            ${ImagesEntity.COLUMN_VOTES_AVERAGE},
            ${ImagesEntity.COLUMN_VOTES_COUNT},
            ${ImagesEntity.COLUMN_MEDIA_TYPE},
            ${ImagesEntity.COLUMN_MEDIA},
            ${ImagesEntity.COLUMN_WIDTH},
            ${ImagesEntity.COLUMN_HEIGHT},
            ${ImagesEntity.COLUMN_TYPE}
        FROM
            ${ImagesEntity.TABLE_NAME}
        WHERE
            ${ImagesEntity.COLUMN_ID}
        =
            :id""")
    fun getImageById(id: Long) : ImagesEntity

    @Query("DELETE FROM ${ImagesEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(imagesEntity: ImagesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg imagesEntities: ImagesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(imagesEntities: List<ImagesEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg imagesEntity: ImagesEntity)

    @Delete
    fun delete(vararg imagesEntity: ImagesEntity)
}
