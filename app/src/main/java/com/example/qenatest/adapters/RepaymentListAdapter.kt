package com.example.qenatest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qenatest.data.models.FinancialStatus
import com.example.qenatest.databinding.HistryItemLayoutBinding
import com.example.qenatest.databinding.RepaymentListLayoutBinding

class RepaymentListAdapter(
    private var newList: MutableList<FinancialStatus>,
    private val context: Context,
) :
    RecyclerView.Adapter<RepaymentListAdapter.MyViewModel>() {

    inner class MyViewModel(val binding: HistryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBuilder = HistryItemLayoutBinding.inflate(inflater, parent, false)
        return MyViewModel(listItemBuilder)
    }

    override fun onBindViewHolder(holder: RepaymentListAdapter.MyViewModel, position: Int) {
        val item = newList[position]
        holder.binding.amount.text = item.amount.toString()
        holder.binding.statusTxt.text = item.status.toString()
    }


    override fun getItemCount(): Int {
        return newList.size
    }

}