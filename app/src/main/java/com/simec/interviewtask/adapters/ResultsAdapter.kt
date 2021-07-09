package com.simec.interviewtask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simec.interviewtask.R
import com.simec.interviewtask.model.Results
import kotlinx.android.synthetic.main.recycler_view_list_row.view.*

class ResultsAdapter : RecyclerView.Adapter<ResultsAdapter.MyViewHolder>() {

    private var listData: List<Results>? = null;


    fun setUpdatedData(listData: List<Results>) {
        this.listData = listData
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textviewName = view.textviewNameArabic


        fun bind(data: Results) {
            textviewName.setText(data.text)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (listData == null) return 0
        else return listData?.size!!
    }


}
