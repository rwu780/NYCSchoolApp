package com.rwu780.nycschoolapp.feature_school.domain.model

import com.rwu780.nycschoolapp.feature_school.data.local.model.SATEntity

data class SAT(
    val dbn: String,
    val school_name: String,
    val num_of_sat_taker: Int,
    val avg_reading_score: Int,
    val avg_math_score: Int,
    val avg_writing_score: Int,
) {

    fun toSATEntity() : SATEntity {
        return SATEntity(
            dbn = dbn,
            school_name = school_name,
            num_of_sat_test_taker = num_of_sat_taker,
            math_sat = avg_math_score,
            reading_sat = avg_reading_score,
            writing_sat = avg_writing_score,
        )
    }

}