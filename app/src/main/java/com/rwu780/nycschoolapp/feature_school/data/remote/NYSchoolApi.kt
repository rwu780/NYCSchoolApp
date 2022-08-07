package com.rwu780.nycschoolapp.feature_school.data.remote

import retrofit2.http.GET

interface NYSchoolApi {

    @GET(SAT_END_POINT)
    suspend fun getAllSAT() : List<SATDto>

    @GET(SCHOOL_END_POINT)
    suspend fun getAllSchool() : List<SchoolDto>

    companion object {
        const val BASE_URL = "https://data.cityofnewyork.us/"
        const val SAT_END_POINT = "resource/f9bf-2cp4.json"
        const val SCHOOL_END_POINT = "resource/s3k6-pzi2.json"
    }
}