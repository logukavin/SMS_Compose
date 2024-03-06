package com.example.smssender.database.repo

import com.example.smssender.database.dao.AppDao
import com.example.smssender.model.send.MessageDb


class DbRepoImpl(private val dao: AppDao) : DbRepo {

    override fun saveMessage(data: List<MessageDb>) {
        dao.insertMessageList(data)
    }

    override fun getMessageList(): List<MessageDb> {
        return dao.getMessageListPagingSource()
    }


}