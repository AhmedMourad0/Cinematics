package inc.ahmedmourad.cinematics.mvvm.model.room.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import android.arch.persistence.room.Delete
import android.arch.persistence.room.OnConflictStrategy
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.PersonsEntity

@Dao
interface PersonsDao {

    @Query("SELECT ${PersonsEntity.COLUMN_PERSON_ID} FROM ${PersonsEntity.TABLE_NAME}")
    fun getAllPersonIds(): List<Long>

    @Query("""
        SELECT
            ${PersonsEntity.COLUMN_PERSON_ID},
            ${PersonsEntity.COLUMN_ALSO_KNOWN_AS},
            ${PersonsEntity.COLUMN_PLACE_OF_BIRTH},
            ${PersonsEntity.COLUMN_PROFILE_PATH},
            ${PersonsEntity.COLUMN_IMDB_ID},
            ${PersonsEntity.COLUMN_NAME},
            ${PersonsEntity.COLUMN_ADULT},
            ${PersonsEntity.COLUMN_BIOGRAPHY},
            ${PersonsEntity.COLUMN_BIRTHDAY},
            ${PersonsEntity.COLUMN_DEATHDAY},
            ${PersonsEntity.COLUMN_GENDER},
            ${PersonsEntity.COLUMN_HOMEPAGE},
            ${PersonsEntity.COLUMN_POPULARITY}
        FROM
            ${PersonsEntity.TABLE_NAME}
        WHERE
            ${PersonsEntity.COLUMN_PERSON_ID}
        =
            :personId""")
    fun getPersonByPersonId(personId: Long): PersonsEntity

    @Query("DELETE FROM ${PersonsEntity.TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(personsEntity: PersonsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg personsEntities: PersonsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(personsEntities: List<PersonsEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg personsEntity: PersonsEntity)

    @Delete
    fun delete(vararg personsEntity: PersonsEntity)
}
