package com.example.smssender.database.repo

import com.example.smssender.model.send.MessageDb


interface DbRepo {
    fun saveMessage(data: List<MessageDb>)
    fun getMessageList(): List<MessageDb>

}