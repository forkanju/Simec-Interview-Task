package com.simec.interviewtask.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.simec.interviewtask.MainViewModel
import com.simec.interviewtask.R
import com.simec.interviewtask.adapters.ResultsAdapter
import com.simec.interviewtask.model.RecyclerList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycler_view_list_row.*

class MainActivity : AppCompatActivity() {

    private lateinit var rAdapter: ResultsAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        parentRecyclerView.layoutManager = LinearLayoutManager(this)

        rAdapter = ResultsAdapter()

        parentRecyclerView.adapter = rAdapter
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.getLiveDataObserver().observe(this, object : Observer<RecyclerList> {
            override fun onChanged(t: RecyclerList?) {
                if (t != null) {
                    rAdapter.setUpdatedData(t.results)
                    rAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@MainActivity, "Error getting the data", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })


        mainViewModel.makeApiCall()
    }
}
