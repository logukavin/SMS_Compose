package com.example.smssender.model.send

import com.google.gson.annotations.SerializedName

data class SendResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Data(

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("scheduled_at")
	val scheduledAt: Any? = null,

	@field:SerializedName("expired_at")
	val expiredAt: Any? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("can_be_polled")
	val canBePolled: Boolean? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("last_attempted_at")
	val lastAttemptedAt: Any? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("sim")
	val sim: String? = null,

	@field:SerializedName("contact")
	val contact: String? = null,

	@field:SerializedName("request_received_at")
	val requestReceivedAt: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("send_attempt_count")
	val sendAttemptCount: Int? = null,

	@field:SerializedName("delivered_at")
	val deliveredAt: Any? = null,

	@field:SerializedName("owner")
	val owner: String? = null,

	@field:SerializedName("max_send_attempts")
	val maxSendAttempts: Int? = null,

	@field:SerializedName("order_timestamp")
	val orderTimestamp: String? = null,

	@field:SerializedName("failure_reason")
	val failureReason: Any? = null,

	@field:SerializedName("sent_at")
	val sentAt: Any? = null,

	@field:SerializedName("send_time")
	val sendTime: Any? = null,

	@field:SerializedName("scheduled_send_time")
	val scheduledSendTime: Any? = null,

	@field:SerializedName("encrypted")
	val encrypted: Boolean? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("received_at")
	val receivedAt: Any? = null,

	@field:SerializedName("failed_at")
	val failedAt: Any? = null,

	@field:SerializedName("request_id")
	val requestId: Any? = null,

	@field:SerializedName("status")
	val status: String? = null
)
