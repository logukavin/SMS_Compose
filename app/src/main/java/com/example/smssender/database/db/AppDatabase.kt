package com.example.smssender.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.smssender.database.dao.AppDao
import com.example.smssender.model.send.MessageDb

@Database(entities = [MessageDb::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val dao: AppDao
}



