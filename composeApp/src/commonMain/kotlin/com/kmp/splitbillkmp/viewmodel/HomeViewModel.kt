package com.kmp.splitbillkmp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.round

data class HomeUiState(
    val amount: String = "",
    val selectedTip: Int = 10,
    val numberOfPeople: Int = 1,
    val totalTip: Double = 0.0,
    val total: Double = 0.0,
    val totalByPerson: Double = 0.0
)

class HomeViewModel: ViewModel() {

    val options = listOf(10, 20, 30)

    private val _uiState = MutableStateFlow(HomeUiState())

    val uiState: StateFlow<HomeUiState> = _uiState

    fun onAmountChange(value: String) {
        _uiState.value = _uiState.value.copy(amount = value)
    }

    fun onTipSelected(tip: Int) {
        _uiState.value = _uiState.value.copy(selectedTip = tip)
    }

    fun incrementPeople() {
        _uiState.value = _uiState.value.copy(numberOfPeople = _uiState.value.numberOfPeople + 1)
    }

    fun decrementPeople() {
        val current = _uiState.value.numberOfPeople
        if (current > 1) {
            _uiState.value = _uiState.value.copy(numberOfPeople = current - 1)
        }
    }

    fun calculate() {
        val amount = _uiState.value.amount.toDoubleOrNull() ?: 0.0
        val tip = _uiState.value.selectedTip
        val people = _uiState.value.numberOfPeople

        val tipAmount = amount * (tip / 100.0)
        val total = amount + tipAmount
        val perPerson = total / people

        _uiState.value = _uiState.value.copy(
            totalTip = tipAmount.round2(),
            total = total.round2(),
            totalByPerson = perPerson.round2()
        )
    }

    private fun Double.round2() = round(this * 100) / 100

}