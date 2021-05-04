package com.example.mvvmupgrade.view.list

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmupgrade.R
import kotlinx.android.synthetic.main.custom_row.view.*
import com.example.mvvmupgrade.model.NumberTrivia
import com.example.mvvmupgrade.viewmodel.NumberTriviaViewModel
import kotlin.collections.List

class ListAdapter(private var numberTriviaViewModel: NumberTriviaViewModel): RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var triviaList = emptyList<NumberTrivia>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun getItemCount(): Int {
        return triviaList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = triviaList[position]
        holder.itemView.textViewNumber.text = currentItem.number.toString()
        holder.itemView.textViewText.text = currentItem.text
        holder.itemView.imageButton.setOnClickListener { numberTriviaViewModel.deleteTrivia(currentItem) }
    }

    fun setData(triviaList: List<NumberTrivia>){
        this.triviaList = triviaList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


}

