package com.example.qenatest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qenatest.adapters.RepaymentListAdapter
import com.example.qenatest.data.models.LoanHistory
import com.example.qenatest.databinding.ActivityRepaymentBinding
import com.example.qenatest.view_model.LoginViewModel
import com.example.qenatest.view_model.RepaymentViewModel

class RepaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRepaymentBinding
    private val viewModel: RepaymentViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()
        addNew()
    }

    private fun addNew() {
        binding.submitBtn.setOnClickListener {
            viewModel.addNewFinancialHistory(
                LoanHistory("New",binding.amountEdit.text.toString())
            )
        }
    }

    private fun initRecycler() {
        recyclerView = binding.repaymentRecy
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val reportList = viewModel.financialStatuses.value ?: emptyList()

        val adapter = RepaymentListAdapter(reportList, this)
        recyclerView.adapter = adapter
    }
}