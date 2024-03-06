package com.example.smssender.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smssender.model.send.MessageDb


@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMessageList(popularMovieList: List<MessageDb>)

    @Query("SELECT * FROM MessageDb")
    fun getMessageListPagingSource(): List<MessageDb>


}