package com.example.smssender.repository

import com.example.smssender.BuildConfig
import com.example.smssender.database.repo.DbRepo
import com.example.smssender.model.send.MessageDb
import com.example.smssender.model.send.RequestBodies
import com.example.smssender.model.send.SendResponse
import kotlinx.coroutines.flow.Flow
import com.example.smssender.remote.ApiDataSource
import com.example.smssender.remote.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiDataSource: ApiDataSource) {

    suspend fun getSendMessage(body: RequestBodies.SendRequest): Flow<Response<SendResponse>> {
        return flow {
            val response = apiDataSource.sendMessage(
                BuildConfig.APP_API_KEY,
                AppConstants.APP_CONTENT_TYPE,
                body
            )
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMessage(dbRepo: DbRepo): Flow<List<MessageDb>> {
        return flow {
            val response = dbRepo.getMessageList()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

}
