package com.example.smssender.remote

import com.example.smssender.model.send.RequestBodies
import com.example.smssender.model.send.SendResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiDataSource {


    @POST(ApiConstants.SEND_BASE_URL)
    suspend fun sendMessage(
        @Header(ApiConstants.X_API_KEY) apiKey: String,
        @Header(ApiConstants.CONTENT_TYPE) contentType: String,
        @Body body: RequestBodies.SendRequest
    ): Response<SendResponse>


}
