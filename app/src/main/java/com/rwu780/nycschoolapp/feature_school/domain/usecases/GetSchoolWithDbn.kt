package com.rwu780.nycschoolapp.feature_school.domain.usecases

import com.rwu780.nycschoolapp.feature_school.data.local.model.SchoolEntity
import com.rwu780.nycschoolapp.feature_school.domain.NYSchoolRepository
import javax.inject.Inject

class GetSchoolWithDbn @Inject constructor(
    private val repository: NYSchoolRepository
) {

    suspend operator fun invoke(dbn: String): SchoolEntity? {

        return repository.getSchoolWithDbn(dbn)

    }
}