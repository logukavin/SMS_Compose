package com.example.smssender.model.send

import com.google.gson.annotations.SerializedName
object RequestBodies {
	data class SendRequest(

		@field:SerializedName("encrypted")
		val encrypted: Boolean? = null,

		@field:SerializedName("from")
		val from: String? = null,

		@field:SerializedName("to")
		val to: String? = null,

		@field:SerializedName("content")
		val content: String? = null
	)
}
