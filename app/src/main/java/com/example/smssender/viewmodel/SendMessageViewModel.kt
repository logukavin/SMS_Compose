package com.example.smssender.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smssender.model.send.RequestBodies
import com.example.smssender.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SendMessageViewModel @Inject constructor(private val repository: DataRepository) :
    ViewModel() {

    private val _dataLoadStateFlow = MutableStateFlow<DataLoadState>(DataLoadState.Start)
    val dataLoadStateFlow: StateFlow<DataLoadState> get() = _dataLoadStateFlow

    @SuppressLint("SuspiciousIndentation")
    fun sendMessage(hashMap: RequestBodies.SendRequest) {
        _dataLoadStateFlow.value = DataLoadState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getSendMessage(hashMap)
            result.collect {
                _dataLoadStateFlow.value = DataLoadState.Success(it.body()!!)
            }
        }
    }


    sealed class DataLoadState {
        data object Start : DataLoadState()
        data object Loading : DataLoadState()
        data class Success(val data: Any) : DataLoadState()
    }
}