package com.example.smssender.activity


import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.smssender.database.repo.DbRepo
import com.example.smssender.screen.MainScreen
import com.example.smssender.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    private val splashViewModel: SplashViewModel by viewModels()

    @Inject
    lateinit var dbRepo: DbRepo

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition { splashViewModel.isLoading.value }
        }
        setContent {
            MainScreen(dbRepo,this)
        }

    }
}

