package com.example.qenatest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qenatest.adapters.HistoryAdapter
import com.example.qenatest.databinding.ActivityHistoryBinding
import com.example.qenatest.view_model.RepaymentViewModel

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private lateinit var recyclerView: RecyclerView
    private val viewModel: RepaymentViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()
    }

    private fun initRecycler() {
        recyclerView = binding.historyRecy
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val reportList = viewModel.financialHistory.value ?: emptyList()

        val adapter = HistoryAdapter(reportList, this)
        recyclerView.adapter = adapter
    }
}