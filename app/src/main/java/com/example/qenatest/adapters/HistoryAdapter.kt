package com.example.qenatest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qenatest.data.models.LoanHistory
import com.example.qenatest.databinding.HistryItemLayoutBinding
import com.example.qenatest.databinding.RepaymentListLayoutBinding

class HistoryAdapter(
    private var newList: List<LoanHistory>,
    private val context: Context,
) :
    RecyclerView.Adapter<HistoryAdapter.MyViewModel>() {

    inner class MyViewModel(val binding: RepaymentListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBuilder = RepaymentListLayoutBinding.inflate(inflater, parent, false)
        return MyViewModel(listItemBuilder)
    }

    override fun onBindViewHolder(holder: HistoryAdapter.MyViewModel, position: Int) {
        val item = newList[position]
        holder.binding.textView3.text = item.status.toString()
        holder.binding.textView4.text = item.amount.toString()
        holder.binding.textView5.text = item.term.toString()
        holder.binding.textView6.text = item.repayments.toString()

    }


    override fun getItemCount(): Int {
        return newList.size
    }

}