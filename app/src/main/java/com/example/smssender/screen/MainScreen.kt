package com.example.smssender.screen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.smssender.BuildConfig
import com.example.smssender.R
import com.example.smssender.activity.ReceivedMessageActivity
import com.example.smssender.activity.SplashActivity
import com.example.smssender.util.AESUtil
import com.example.smssender.util.EditTextInput
import com.example.smssender.database.repo.DbRepo
import com.example.smssender.model.send.MessageDb
import com.example.smssender.model.send.RequestBodies
import com.example.smssender.model.send.SendResponse
import com.example.smssender.remote.AppConstants
import com.example.smssender.viewmodel.SendMessageViewModel
import java.math.BigInteger


@RequiresApi(Build.VERSION_CODES.P)
@SuppressLint("UnrememberedMutableState", "SuspiciousIndentation")
@Composable
fun MainScreen(dbRepo: DbRepo, mContext: SplashActivity) {


    val dashBoardViewModel = hiltViewModel<SendMessageViewModel>()

    //Mobile Number
    var number by mutableStateOf("")
    var mobileNumberErrorState by mutableStateOf(false)
    var validMobileNumberErrorState = true
    val mobileNumberFocusRequester = FocusRequester()

    //Message
    var message by mutableStateOf("")
    var messageErrorState by mutableStateOf(false)
    val messageFocusRequester = FocusRequester()

    val dataState by dashBoardViewModel.dataLoadStateFlow.collectAsState(initial = SendMessageViewModel.DataLoadState.Start)


    when (dataState) {

        SendMessageViewModel.DataLoadState.Loading -> {
            ShowLoader()
        }

        SendMessageViewModel.DataLoadState.Start -> { //do nothing
        }

        is SendMessageViewModel.DataLoadState.Success -> {
            (dataState as SendMessageViewModel.DataLoadState.Success).data


            val data =
                (dataState as SendMessageViewModel.DataLoadState.Success).data as SendResponse

            val listData = mutableListOf<MessageDb>()


            val subString = data.data!!.contact!!.substring(3)
            val currentString = BigInteger(subString).toInt()
            listData.add(
                MessageDb(
                    currentString,
                    data.data.contact!!,
                    data.data.content!!,
                    data.data.requestReceivedAt!!
                )
            )
            dbRepo.saveMessage(listData)

            mContext.startActivity(Intent(mContext, ReceivedMessageActivity::class.java))
        }

    }

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier
                .padding(top = 150.dp, bottom = 150.dp, start = 50.dp, end = 50.dp)
                .fillMaxWidth()
        ) {
            EditTextInput().editTextInput(textName = number,
                label = mContext.resources.getString(R.string.number),
                errorMSg = if (validMobileNumberErrorState) mContext.resources.getString(R.string.number) else mContext.resources.getString(
                    R.string.please_enter_mobile_number
                ),
                isError = mobileNumberErrorState,
                focusRequester = mobileNumberFocusRequester,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number, imeAction = ImeAction.Next
                ),
                modifierData = Modifier.padding(top = 25.dp),
                onTextChanged = { number = it })
            Spacer(modifier = Modifier.height(10.dp))

            EditTextInput().editTextInput(textName = message,
                label = mContext.resources.getString(R.string.message),
                errorMSg = mContext.resources.getString(R.string.message),
                isError = messageErrorState,
                focusRequester = messageFocusRequester,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password, imeAction = ImeAction.Next
                ),
                modifierData = Modifier.padding(top = 15.dp),
                onTextChanged = { message = it })

            ElevatedButton(
                onClick = {
                    mobileNumberErrorState = false
                    messageErrorState = false

                    if (number.trim() == "") {
                        validMobileNumberErrorState = true
                        mobileNumberErrorState = true
                    } else if (!isValidMobileNumber(number.trim())) {
                        validMobileNumberErrorState = false
                        mobileNumberErrorState = true
                    } else if (message.trim() == "") {
                        messageErrorState = true
                    } else {
                        val person = RequestBodies.SendRequest(
                            false,
                            AppConstants.OWNER_NUMBER,
                            AppConstants.COUNTRY_CODE + number.trim(),
                            AESUtil.encryptMessage(message.trim(), BuildConfig.APP_SECRET_KEY)
                        )

                        dashBoardViewModel.sendMessage(person)


                    }

                },
                modifier = Modifier
                    .padding(top = 40.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = mContext.resources.getString(R.string.send)
                )
            }
        }
    }


}


@Composable
fun ShowLoader() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.size(60.dp))
    }
}


fun isValidMobileNumber(number: String): Boolean {
    val regex = Regex("^(\\+\\d{1,3}[- ]?)?\\d{10}\$")
    return regex.matches(number)
}




