package com.kmp.splitbillkmp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmp.splitbillkmp.componentes.MainCard
import com.kmp.splitbillkmp.componentes.MainIconButton
import com.kmp.splitbillkmp.componentes.MainRow
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
    var selectedTip by rememberSaveable { mutableStateOf(10) }
    var numberOfPeople by rememberSaveable { mutableStateOf(1) }
    val options = listOf(10, 20, 30)

    Column (modifier= modifier){
        MainCard(title = "Hola", description = "Description") {
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
            Row (
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                options.forEach { option ->
                    FilterChip(
                        selected = selectedTip== option,
                        onClick = {selectedTip = option},
                        label = {Text("$option")}
                    )
                }
            }
            Text(selectedTip.toString(), fontSize = 50.sp)
            Row {
                MainIconButton(
                    imageVector = Icons.Default.ArrowCircleDown,
                    contentDescription = "Down",
                    onClick = {numberOfPeople=down(numberOfPeople)},
                    modifier = Modifier
                ){}
                Text(text = numberOfPeople.toString(), fontSize = 50.sp)
                MainIconButton(
                    imageVector = Icons.Default.ArrowCircleUp,
                    contentDescription = "Down",
                    onClick = {numberOfPeople++},
                    modifier = Modifier
                ){}
            }
        }
        MainCard(title = "Bill Summary", description = "Description") {
            MainRow(title = "Tip Ammount", total = 123.0)
            MainRow(title = "Total", total = 123.0)
        }
    }
}

fun down(number: Int): Int{
    if(number>1){
        return number-1
    }
    return number
}