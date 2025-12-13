package com.kmp.splitbillkmp.views

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
        BuildHomeViewContent(modifier = Modifier.padding(padding))
    }
}

@Composable
fun BuildHomeViewContent(modifier: Modifier){
    var amount by rememberSaveable { mutableStateOf("") }
    var selectedTip by rememberSaveable { mutableStateOf(10) }
    var numberOfPeople by rememberSaveable { mutableStateOf(1) }
    var totalTip by rememberSaveable { mutableStateOf(0.0) }
    var total by rememberSaveable { mutableStateOf(0.0) }
    var totalByPerson by rememberSaveable { mutableStateOf(0.0) }
    var focusManager= LocalFocusManager.current

    val options = listOf(10, 20, 30)

    Column (modifier= modifier.pointerInput( key1 = Unit){
        detectTapGestures {
            focusManager.clearFocus()
        }
    }){
        MainCard(title = "Hola", description = "Description") {
            OutlinedTextField(
                label = {Text("Amount")},
                value = amount, onValueChange = {amount = it},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            Text(amount)
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
                    onClick = {numberOfPeople=downV2(numberOfPeople)},
                    modifier = Modifier
                ){}
                Text(text = numberOfPeople.toString(), fontSize = 50.sp)
                MainIconButton(
                    imageVector = Icons.Default.ArrowCircleUp,
                    contentDescription = "Up",
                    onClick = {numberOfPeople++},
                    modifier = Modifier
                ){}
            }
            Button(onClick = {
                val amountDouble = amount.toDoubleOrNull() ?: 0.0
                val calculateResult = calculateV2(amountDouble, selectedTip, numberOfPeople)
                totalTip= calculateResult.first
                total= calculateResult.second
                totalByPerson= calculateResult.third
                focusManager.clearFocus()
            }){
                Text(text = "Calculate")
            }
        }
        MainCard(title = "Bill Summary", description = "Description") {
            MainRow(title = "Tip Amount", total = totalTip.roundTowDecimals())
            MainRow(title = "Total", total = total.roundTowDecimals())
            Surface (
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
            ){
                Text(
                    text = "Each person should pay $${totalByPerson.roundTowDecimals()}",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )

            }
        }
    }
}

fun downV2(number: Int): Int =if (number>1) number-1 else number

fun Double.roundTowDecimals(): Double= kotlin.math.round(this * 100) / 100

fun calculateV2(amount: Double, tip:Int, numberOfPeople:Int): Triple<Double, Double, Double>{
    val tipRes= amount*(tip.toDouble()/ 100)
    val totalWithTip= amount+tipRes
    val totalByPerson= totalWithTip / numberOfPeople
    return Triple(tipRes, totalWithTip, totalByPerson)
}
