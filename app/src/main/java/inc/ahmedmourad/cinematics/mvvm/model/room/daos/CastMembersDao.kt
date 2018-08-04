package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.*
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.CastMembersEntity

@Dao
interface CastMembersDao {

    @Query("""
        SELECT
            ${CastMembersEntity.COLUMN_CREDIT_ID},
            ${CastMembersEntity.COLUMN_MOVIE_ID},
            ${CastMembersEntity.COLUMN_PERSON_ID},
            ${CastMembersEntity.COLUMN_NAME},
            ${CastMembersEntity.COLUMN_CHARACTER},
            ${CastMembersEntity.COLUMN_ORIGINAL_TITLE},
            ${CastMembersEntity.COLUMN_IMAGE_PATH},
            ${CastMembersEntity.COLUMN_SOURCE}
        FROM
            ${CastMembersEntity.TABLE_NAME}
        WHERE
            ${CastMembersEntity.COLUMN_PERSON_ID}
        =
            :personId
        AND
            ${CastMembersEntity.COLUMN_SOURCE}
        =
            ${CastMembersEntity.SOURCE_PERSON}""")
    fun getCastMembersByPersonId(personId: Long) : List<CastMembersEntity>

    @Query("""
        SELECT
            ${CastMembersEntity.COLUMN_CREDIT_ID},
            ${CastMembersEntity.COLUMN_MOVIE_ID},
            ${CastMembersEntity.COLUMN_PERSON_ID},
            ${CastMembersEntity.COLUMN_NAME},
            ${CastMembersEntity.COLUMN_CHARACTER},
            ${CastMembersEntity.COLUMN_ORIGINAL_TITLE},
            ${CastMembersEntity.COLUMN_IMAGE_PATH},
            ${CastMembersEntity.COLUMN_SOURCE}
        FROM
            ${CastMembersEntity.TABLE_NAME}
        WHERE
            ${CastMembersEntity.COLUMN_MOVIE_ID}
        =
            :movieId
        AND
            ${CastMembersEntity.COLUMN_SOURCE}
        =
            ${CastMembersEntity.SOURCE_MOVIE}""")
    fun getCastMembersByMovieId(movieId: Long) : List<CastMembersEntity>

    @Query("""
        SELECT
            ${CastMembersEntity.COLUMN_CREDIT_ID},
            ${CastMembersEntity.COLUMN_MOVIE_ID},
            ${CastMembersEntity.COLUMN_PERSON_ID},
            ${CastMembersEntity.COLUMN_NAME},
            ${CastMembersEntity.COLUMN_CHARACTER},
            ${CastMembersEntity.COLUMN_ORIGINAL_TITLE},
            ${CastMembersEntity.COLUMN_IMAGE_PATH},
            ${CastMembersEntity.COLUMN_SOURCE}
        FROM
            ${CastMembersEntity.TABLE_NAME}
        WHERE
            ${CastMembersEntity.COLUMN_CREDIT_ID}
        =
            :creditId""")
    fun getCastMemberByCreditId(creditId: String) : CastMembersEntity

    @Query("DELETE FROM ${CastMembersEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(castMembersEntity: CastMembersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg castMembersEntity: CastMembersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(castMembersEntity: List<CastMembersEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg castMembersEntity: CastMembersEntity)

    @Delete
    fun delete(vararg castMembersEntity: CastMembersEntity)
}
