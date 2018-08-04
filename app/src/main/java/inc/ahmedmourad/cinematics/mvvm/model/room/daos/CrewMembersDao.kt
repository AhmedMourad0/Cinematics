package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.*
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.CrewMembersEntity

@Dao
interface CrewMembersDao {

    @Query("""
        SELECT
            ${CrewMembersEntity.COLUMN_CREDIT_ID},
            ${CrewMembersEntity.COLUMN_MOVIE_ID},
            ${CrewMembersEntity.COLUMN_PERSON_ID},
            ${CrewMembersEntity.COLUMN_NAME},
            ${CrewMembersEntity.COLUMN_JOB},
            ${CrewMembersEntity.COLUMN_DEPARTMENT},
            ${CrewMembersEntity.COLUMN_ORIGINAL_TITLE},
            ${CrewMembersEntity.COLUMN_IMAGE_PATH},
            ${CrewMembersEntity.COLUMN_SOURCE}
        FROM
            ${CrewMembersEntity.TABLE_NAME}
        WHERE
            ${CrewMembersEntity.COLUMN_PERSON_ID}
        =
            :personId
        AND
            ${CrewMembersEntity.COLUMN_SOURCE}
        =
            ${CrewMembersEntity.SOURCE_PERSON}""")
    fun getCrewMembersByPersonId(personId: Long) : List<CrewMembersEntity>

    @Query("""
        SELECT
            ${CrewMembersEntity.COLUMN_CREDIT_ID},
            ${CrewMembersEntity.COLUMN_MOVIE_ID},
            ${CrewMembersEntity.COLUMN_PERSON_ID},
            ${CrewMembersEntity.COLUMN_NAME},
            ${CrewMembersEntity.COLUMN_JOB},
            ${CrewMembersEntity.COLUMN_DEPARTMENT},
            ${CrewMembersEntity.COLUMN_ORIGINAL_TITLE},
            ${CrewMembersEntity.COLUMN_IMAGE_PATH},
            ${CrewMembersEntity.COLUMN_SOURCE}
        FROM
            ${CrewMembersEntity.TABLE_NAME}
        WHERE
            ${CrewMembersEntity.COLUMN_MOVIE_ID}
        =
            :movieId
        AND
            ${CrewMembersEntity.COLUMN_SOURCE}
        =
            ${CrewMembersEntity.SOURCE_MOVIE}""")
    fun getCrewMembersByMovieId(movieId: Long) : List<CrewMembersEntity>

    @Query("""
        SELECT
            ${CrewMembersEntity.COLUMN_CREDIT_ID},
            ${CrewMembersEntity.COLUMN_MOVIE_ID},
            ${CrewMembersEntity.COLUMN_PERSON_ID},
            ${CrewMembersEntity.COLUMN_NAME},
            ${CrewMembersEntity.COLUMN_JOB},
            ${CrewMembersEntity.COLUMN_DEPARTMENT},
            ${CrewMembersEntity.COLUMN_ORIGINAL_TITLE},
            ${CrewMembersEntity.COLUMN_IMAGE_PATH},
            ${CrewMembersEntity.COLUMN_SOURCE}
        FROM
            ${CrewMembersEntity.TABLE_NAME}
        WHERE
            ${CrewMembersEntity.COLUMN_CREDIT_ID}
        =
            :creditId""")
    fun getCrewMemberByCreditId(creditId: String) : CrewMembersEntity

    @Query("DELETE FROM ${CrewMembersEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(crewMembersEntity: CrewMembersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg crewMembersEntity: CrewMembersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(crewMembersEntity: List<CrewMembersEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg crewMembersEntity: CrewMembersEntity)

    @Delete
    fun delete(vararg crewMembersEntity: CrewMembersEntity)
}
