package com.example.qenatest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qenatest.adapters.RepaymentListAdapter
import com.example.qenatest.data.models.FinancialStatus
import com.example.qenatest.data.models.LoanHistory
import com.example.qenatest.databinding.ActivityRepaymentBinding
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
            viewModel.addItem(
                FinancialStatus("New",binding.amountEdit.text.toString())
            )
        }
    }

    private fun initRecycler() {
        val mainActivity = this

        viewModel.financialStatuses.observe(this){
            binding.repaymentRecy.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = RepaymentListAdapter(it, mainActivity)
            }
        }
    }
}