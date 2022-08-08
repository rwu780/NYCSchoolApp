package com.rwu780.nycschoolapp.feature_school.data.local

import androidx.room.*
import com.rwu780.nycschoolapp.feature_school.data.local.model.SATEntity
import com.rwu780.nycschoolapp.feature_school.data.local.model.SchoolEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NYSchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSATs(sat_list: List<SATEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchools(school_list: List<SchoolEntity>)

    @Query("DELETE FROM sat")
    suspend fun deleteAll()

    @Query("DELETE FROM school")
    suspend fun deleteAllSchool()

    @Query("SELECT * FROM sat")
    fun getAllSATs(): Flow<List<SATEntity>>

    @Query("SELECT * FROM sat where LOWER(school_name) like '%' || :keyword || '%'")
    fun filterByKeyword(keyword: String): Flow<List<SATEntity>>

    @Query("SELECT * FROM school WHERE dbn=:dbn")
    suspend fun getSchoolWithDbn(dbn: String): SchoolEntity?

}