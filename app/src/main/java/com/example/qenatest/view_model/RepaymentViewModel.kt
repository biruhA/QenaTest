package com.example.qenatest.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qenatest.data.models.FinancialStatus
import com.example.qenatest.data.models.LoanHistory

class RepaymentViewModel:ViewModel() {
    private val _financialStatuses = MutableLiveData<List<FinancialStatus>>()
    val financialStatuses: LiveData<List<FinancialStatus>> get() = _financialStatuses

    private val _financialHistory = MutableLiveData<List<LoanHistory>>()
    val financialHistory: LiveData<List<FinancialStatus>> get() = _financialStatuses

    init {
        _financialStatuses.value = listOf(
            FinancialStatus("Good", 10000.0, 12, 24),
            FinancialStatus("Fair", 5000.0, 6, 12)
        )
        _financialHistory.value = listOf(
            LoanHistory("Good", "10000.0"),
            LoanHistory("Fair", "5000.0")
        )
    }

    fun addNewFinancialHistory(newEntry: LoanHistory) {
        val currentHistory = _financialHistory.value ?: emptyList()
        _financialHistory.value = listOf(currentHistory, newEntry)
    }
}