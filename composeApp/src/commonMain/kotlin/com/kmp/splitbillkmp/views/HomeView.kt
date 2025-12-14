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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.kmp.splitbillkmp.viewmodel.HomeViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun HomeView(){
    Scaffold (topBar = {
        CenterAlignedTopAppBar(title = { Text("Top bar", fontWeight = FontWeight.Bold)})
    }){
        padding ->
        BuildHomeViewContent(
            viewModel = rememberSaveable { HomeViewModel() },
            modifier = Modifier.padding(padding))
    }
}

@Composable
fun BuildHomeViewContent(
    modifier: Modifier,
    viewModel: HomeViewModel
){
    val state by viewModel.uiState.collectAsState()
    val focusManager= LocalFocusManager.current

    Column (modifier= modifier.pointerInput( key1 = Unit){
        detectTapGestures {
            focusManager.clearFocus()
        }
    }){
        MainCard(title = "Hola", description = "Description") {
            OutlinedTextField(
                label = {Text("Amount")},
                value = state.amount,
                onValueChange = viewModel::onAmountChange,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            Text(state.amount)
            Row (
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                viewModel.options.forEach { option ->
                    FilterChip(
                        selected = state.selectedTip== option,
                        onClick = {viewModel.onTipSelected(option)},
                        label = {Text("$option")}
                    )
                }
            }
            Text(state.selectedTip.toString(), fontSize = 50.sp)
            Row {
                MainIconButton(
                    imageVector = Icons.Default.ArrowCircleDown,
                    contentDescription = "Down",
                    onClick = viewModel::decrementPeople,
                    modifier = Modifier
                ){}
                Text(text = state.numberOfPeople.toString(), fontSize = 50.sp)
                MainIconButton(
                    imageVector = Icons.Default.ArrowCircleUp,
                    contentDescription = "Up",
                    onClick = viewModel::incrementPeople,
                    modifier = Modifier
                ){}
            }
            Button(onClick = {
                viewModel.calculate()
                focusManager.clearFocus()
            }){
                Text(text = "Calculate")
            }
        }
        MainCard(title = "Bill Summary", description = "Description") {
            MainRow(title = "Tip Amount", total = state.totalTip)
            MainRow(title = "Total", total = state.total)
            Surface (
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
            ){
                Text(
                    text = "Each person should pay $${state.totalByPerson}",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(0.dp)
                )

            }
        }
    }
}
