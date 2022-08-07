package com.rwu780.nycschoolapp.feature_school.data.remote

data class SchoolDto(
    val dbn: String,
    val school_name: String,
    val overview_paragraph : String,
    val location: String,
    val phone_number: String,
    val school_email: String,
    val website: String,
    val latitude: String,
    val longitude: String
)