package com.kmp.splitbillkmp.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun MainCard(title: String, description: String, content: @Composable () -> Unit){
    Card(
        modifier= Modifier
            .padding(all =16.dp)
            .fillMaxWidth(),
        colors = CardColors(
            containerColor= Color.LightGray,
            contentColor= Color.Black,
            disabledContainerColor= Color.LightGray,
            disabledContentColor= Color.DarkGray
        ),
    ) {
        Column (
            modifier= Modifier
                .padding(all=16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(title)
            Text(description)

            content()
        }

    }
}