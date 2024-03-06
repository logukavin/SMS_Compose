package com.example.smssender.model.send

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class MessageDb(
    @PrimaryKey(autoGenerate = true)
    var messageId: Int = 0,
    val contact: String,
    val content: String,
    val requestReceivedAt: String
)