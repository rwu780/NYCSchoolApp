package com.rwu780.nycschoolapp.feature_school.data

import com.rwu780.nycschoolapp.feature_school.data.local.NYSchoolDao
import com.rwu780.nycschoolapp.feature_school.data.remote.NYSchoolApi
import com.rwu780.nycschoolapp.feature_school.domain.NYSchoolRepository
import com.rwu780.nycschoolapp.feature_school.domain.model.SAT
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NYSchoolRepositoryImpl @Inject constructor(
    private val dao: NYSchoolDao,
    private val api: NYSchoolApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : NYSchoolRepository {

    override suspend fun insertAll() = withContext(dispatcher) {

        val lists = api.getAllSAT()

        if (lists.isNotEmpty()){
            dao.deleteAll()
            dao.insertSATs(lists.map {
                it.toSATEntity()
            })
        }
    }

    override fun getAll(): Flow<List<SAT>> {
        return dao.getAllSATs().map { list ->
            list.map {
                it.toSAT()
            }
        }
    }

    override fun filterByKeyword(keyword: String): Flow<List<SAT>> {
        return dao.filterByKeyword(keyword).map { list ->
            list.map {
                it.toSAT()
            }
        }
    }
}