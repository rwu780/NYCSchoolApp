package com.rwu780.nycschoolapp.feature_school.data.remote

import com.rwu780.nycschoolapp.feature_school.data.local.model.SATEntity

data class SATDto(
    val dbn: String,
    val school_name: String,
    val num_of_sat_test_takers : String,
    val sat_critical_reading_avg_score: String,
    val sat_math_avg_score: String,
    val sat_writing_avg_score: String
) {
    fun toSATEntity() : SATEntity {
        return SATEntity(
            dbn = dbn,
            school_name = school_name,
            num_of_sat_test_taker = num_of_sat_test_takers.toIntOrNull() ?: 0,
            math_sat = sat_math_avg_score.toIntOrNull() ?: 0,
            reading_sat = sat_critical_reading_avg_score.toIntOrNull() ?: 0,
            writing_sat = sat_writing_avg_score.toIntOrNull() ?: 0
        )
    }
}