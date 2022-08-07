package com.rwu780.nycschoolapp.feature_school.domain.usecases

import com.rwu780.nycschoolapp.feature_school.domain.NYSchoolRepository
import javax.inject.Inject

class InsertSATList @Inject constructor(
    private val repository: NYSchoolRepository
) {

    suspend operator fun invoke() {
        repository.insertAll()
    }
}