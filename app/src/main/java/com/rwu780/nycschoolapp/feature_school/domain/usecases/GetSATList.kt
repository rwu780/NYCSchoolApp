package com.rwu780.nycschoolapp.feature_school.domain.usecases

import com.rwu780.nycschoolapp.feature_school.domain.NYSchoolRepository
import com.rwu780.nycschoolapp.feature_school.domain.model.SAT
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetSATList @Inject constructor(
    private val repository: NYSchoolRepository
) {

    operator fun invoke(keyword: String) : Flow<List<SAT>> {

        if (keyword.isBlank()){
            return repository.getAll()
        }

        return repository.filterByKeyword(keyword.lowercase())
    }
}