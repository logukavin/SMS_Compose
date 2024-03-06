package com.example.smssender.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.smssender.util.ListItemView
import com.example.smssender.database.repo.DbRepo
import com.example.smssender.model.send.MessageDb
import com.example.smssender.viewmodel.ReceivedMessageViewModel

@Composable
fun ReceivedMessageScreen(dbRepo: DbRepo) {

    val receivedMessageViewModel = hiltViewModel<ReceivedMessageViewModel>()
    receivedMessageViewModel.getMessageList(dbRepo)

    val dataState by receivedMessageViewModel.dataLoadStateFlow.collectAsState(initial = ReceivedMessageViewModel.DataLoadState.Start)

    when (dataState) {

        ReceivedMessageViewModel.DataLoadState.Loading -> {
            ShowLoader()
        }

        ReceivedMessageViewModel.DataLoadState.Start -> {
        }

        is ReceivedMessageViewModel.DataLoadState.Success -> {
            (dataState as ReceivedMessageViewModel.DataLoadState.Success).data


            val data =
                (dataState as ReceivedMessageViewModel.DataLoadState.Success).data as List<MessageDb>
            val reversedSet = data.asReversed().toSet()


            LazyColumn(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 9.dp, end = 9.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp), //space between each items in list
            ) {
                item {
                    reversedSet.forEach {
                        ListItemView(it)
                    }
                }

            }

        }
    }
}

