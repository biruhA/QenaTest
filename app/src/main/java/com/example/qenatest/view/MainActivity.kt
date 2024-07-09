package com.example.qenatest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.qenatest.data.models.FinancialStatus
import com.example.qenatest.data.models.LoanHistory
import com.example.qenatest.databinding.ActivityMainBinding
import com.example.qenatest.view_model.RepaymentViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: RepaymentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.repamentBtn.setOnClickListener {
            val intent = Intent(this, RepaymentActivity::class.java)
            startActivity(intent)
        }

        binding.historyBtn.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
        addNew()
    }

    private fun addNew() {
        binding.submitBtn.setOnClickListener {
            viewModel.addHistory(
                LoanHistory("New",binding.usernameEdit.text.toString(),binding.passwordEdit.text.toString(),"Non")
            )
        }
    }
}