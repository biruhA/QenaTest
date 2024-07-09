package com.example.qenatest.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qenatest.data.models.FinancialStatus
import com.example.qenatest.data.models.LoanHistory

class RepaymentViewModel:ViewModel() {
    var financialStatuses = MutableLiveData<MutableList<FinancialStatus>>()
    var financialHistory = MutableLiveData<MutableList<LoanHistory>>()

    init {
        financialStatuses.value = mutableListOf()
        financialHistory.value = mutableListOf()
    }

    fun addItem(newEntry: FinancialStatus)
    {
        val list = financialStatuses.value
        list!!.add(newEntry)
        financialStatuses.postValue(list)
    }

    fun addHistory(newEntry: LoanHistory)
    {
        val list = financialHistory.value
        list!!.add(newEntry)
        financialHistory.postValue(list)
    }
}