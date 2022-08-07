package com.rwu780.nycschoolapp.feature_school.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rwu780.nycschoolapp.feature_school.data.local.model.SATEntity
import com.rwu780.nycschoolapp.feature_school.data.local.model.SchoolEntity

@Database(
    entities = [SATEntity::class, SchoolEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NYSchool_DB : RoomDatabase() {

    abstract val NYSchoolDao: NYSchoolDao

    companion object {
        const val DB_NAME = "nyc_db"
    }
}