package com.rwu780.nycschoolapp.di

import android.content.Context
import androidx.room.Room
import com.rwu780.nycschoolapp.feature_school.data.NYSchoolRepositoryImpl
import com.rwu780.nycschoolapp.feature_school.data.local.NYSchoolDao
import com.rwu780.nycschoolapp.feature_school.data.local.NYSchool_DB
import com.rwu780.nycschoolapp.feature_school.data.remote.NYSchoolApi
import com.rwu780.nycschoolapp.feature_school.domain.NYSchoolRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object SAT_Module {

    @Provides
    @Singleton
    fun provideSATDatabase(@ApplicationContext cxt: Context): NYSchool_DB {
        return Room.databaseBuilder(cxt, NYSchool_DB::class.java, NYSchool_DB.DB_NAME).build()
    }

    @Provides
    @Singleton
    fun provideSATDao(db: NYSchool_DB): NYSchoolDao {
        return db.NYSchoolDao
    }

    @Provides
    @Singleton
    fun provideSATRepository(dao: NYSchoolDao, api: NYSchoolApi, dispatcher: CoroutineDispatcher) : NYSchoolRepository {
        return NYSchoolRepositoryImpl(dao, api, dispatcher)
    }

    @Provides
    @Singleton
    fun provideSATApi(moshi: Moshi) : NYSchoolApi {
        return Retrofit.Builder().baseUrl(NYSchoolApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(NYSchoolApi::class.java)
    }

}