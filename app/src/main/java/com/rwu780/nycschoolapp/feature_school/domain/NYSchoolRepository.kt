package com.rwu780.nycschoolapp.feature_school.domain

import com.rwu780.nycschoolapp.feature_school.domain.model.SAT
import kotlinx.coroutines.flow.Flow

interface NYSchoolRepository {

    suspend fun insertAll()

    fun getAll() : Flow<List<SAT>>

    fun filterByKeyword(keyword: String) : Flow<List<SAT>>

}