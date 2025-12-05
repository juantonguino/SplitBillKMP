package com.kmp.splitbillkmp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import com.kmp.splitbillkmp.componentes.MainCard
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun HomeView(){
    Scaffold (topBar = {
        CenterAlignedTopAppBar(title = { Text("Top bar", fontWeight = FontWeight.Bold)})
    }){
        padding ->
        buildHomeViewContent(modifier = Modifier.padding(padding))
    }
}

@Composable
fun buildHomeViewContent(modifier: Modifier){
    var amount by rememberSaveable { mutableStateOf("") }
    Column (modifier= modifier){
        MainCard(title = "Hola", description = "Description"){
            OutlinedTextField(
                label = {Text("Amount")},
                value = amount, onValueChange = {amount = it},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            Text(amount)
            Button({}){
                Text("Click me!")
            }
        }
    }
}