package com.rwu780.nycschoolapp.feature_school.data.remote

import com.rwu780.nycschoolapp.feature_school.data.local.model.SchoolEntity

data class SchoolDto(
    val dbn: String,
    val school_name: String,
    val overview_paragraph : String,
    val location: String,
    val phone_number: String,
    val school_email: String?,
    val website: String,
    val latitude: String?,
    val longitude: String?
) {
    fun toSchoolEntity() :  SchoolEntity {

        return SchoolEntity(
            dbn = dbn,
            overview_paragraph = overview_paragraph,
            school_name = school_name,
            location = location,
            phone_number = phone_number,
            website = website,
            school_email = school_email ?: "",
            latitude = latitude ?: "",
            longitude = longitude ?: ""
        )
    }
}