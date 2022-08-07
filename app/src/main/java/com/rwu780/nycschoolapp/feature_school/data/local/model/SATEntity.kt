package com.rwu780.nycschoolapp.feature_school.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rwu780.nycschoolapp.feature_school.domain.model.SAT

@Entity(tableName = "sat")
data class SATEntity(
    @PrimaryKey val dbn: String,
    val school_name: String,
    val num_of_sat_test_taker: Int,
    val reading_sat: Int,
    val math_sat: Int,
    val writing_sat: Int
) {

    fun toSAT() : SAT {
        return SAT(
            dbn = dbn,
            school_name = school_name,
            num_of_sat_taker = num_of_sat_test_taker,
            avg_math_score = math_sat,
            avg_reading_score = reading_sat,
            avg_writing_score = writing_sat
        )
    }
}
