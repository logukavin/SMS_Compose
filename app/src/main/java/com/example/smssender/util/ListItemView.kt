package com.example.smssender.util

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.smssender.R
import com.example.smssender.model.send.MessageDb


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListItemView(item: MessageDb) {

    Card(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 5.dp, start = 5.dp, end = 5.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
    )

    {


        Row(

            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(),

            ) {

            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 0.dp, start = 10.dp, end = 0.dp)
                    .size(35.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )


            Column(

                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                Text(
                    text = item.contact,
                    color = Color.Black,
                    style = typography.labelSmall,
                    modifier = Modifier.absolutePadding(
                        left = 10.dp,
                        right = 10.dp,
                        top = 10.dp,
                        bottom = 0.dp
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = AESUtil.decryptMessage(item.content, "tHeApAcHe6410111"),
                    style = typography.bodyMedium,
                    maxLines = 3,
                    color = Color.Black,
                    modifier = Modifier.absolutePadding(
                        left = 10.dp,
                        right = 10.dp,
                        top = 0.dp,
                        bottom = 10.dp
                    )
                )
            }

        }
    }
}


