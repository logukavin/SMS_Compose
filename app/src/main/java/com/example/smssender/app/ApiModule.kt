package com.example.smssender.app

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.smssender.repository.DataRepository
import com.example.smssender.remote.ApiDataSource
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class ApiModule {


    @Provides
    @Singleton
    fun bindsApiDataSource(retrofit: Retrofit): ApiDataSource {
        return retrofit.create(ApiDataSource::class.java)
    }

    @Provides
    @Singleton
    fun bindsAppRepo(apiDataSource: ApiDataSource): DataRepository {
        return DataRepository(apiDataSource)
    }
}