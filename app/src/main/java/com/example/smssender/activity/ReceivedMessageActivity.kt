package com.example.smssender.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.smssender.database.repo.DbRepo
import com.example.smssender.screen.ReceivedMessageScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ReceivedMessageActivity : ComponentActivity() {
    @Inject
    lateinit var dbRepo: DbRepo

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ReceivedMessageScreen(dbRepo)

        }
    }

}



