package com.example.smssender.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smssender.database.repo.DbRepo
import com.example.smssender.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReceivedMessageViewModel @Inject constructor(private val repository: DataRepository) :
    ViewModel() {


    private val _dataLoadStateFlow = MutableStateFlow<DataLoadState>(DataLoadState.Start)
    val dataLoadStateFlow: StateFlow<DataLoadState> get() = _dataLoadStateFlow

    fun getMessageList(dbRepo: DbRepo) {
        _dataLoadStateFlow.value = DataLoadState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getMessage(dbRepo)
            result.collect {
                _dataLoadStateFlow.value = DataLoadState.Success(it)
            }
        }
    }


    sealed class DataLoadState {
        data object Start : DataLoadState()
        data object Loading : DataLoadState()
        data class Success(val data: Any) : DataLoadState()
    }

}