package com.example.qenatest.data.models

data class FinancialStatus(
    val status: String,
    val amount: Double,
    val term: Int,
    val repayments: Int
)
