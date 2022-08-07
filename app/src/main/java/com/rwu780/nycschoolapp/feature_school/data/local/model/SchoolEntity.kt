package com.rwu780.nycschoolapp.feature_school.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "school")
data class SchoolEntity(
    @PrimaryKey val dbn: String,
    val school_name: String,
    val overview_paragraph : String,
    val location: String,
    val phone_number: String,
    val school_email: String,
    val website: String,
    val latitude: String,
    val longitude: String
)
