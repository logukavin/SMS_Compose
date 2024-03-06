package com.example.smssender.model.received

import com.google.gson.annotations.SerializedName

data class ReceivedMessageResponse(

	@field:SerializedName("data")
	val data: List<Any?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
