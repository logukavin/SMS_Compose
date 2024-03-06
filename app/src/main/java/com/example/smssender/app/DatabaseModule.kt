package com.example.smssender.app

import android.app.Application
import androidx.room.Room
import com.example.smssender.database.db.AppDatabase
import com.example.smssender.database.repo.DbRepo
import com.example.smssender.database.repo.DbRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java, DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    private const val DATABASE_NAME = "AppDB"


    @Provides
    @Singleton
    fun providesTodoRepository(db: AppDatabase): DbRepo {

        return DbRepoImpl(db.dao)
    }
}