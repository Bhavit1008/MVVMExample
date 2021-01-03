package com.example.mvvmexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmexample.R
import com.example.mvvmexample.databinding.MainViewBinding
import com.example.mvvmexample.viewmodel.TaskViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: MainViewBinding
    lateinit var viewModel : TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_view)


        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)

        var count:LiveData<Int> = viewModel.initialCount()

        count.observe(this, Observer {
            binding.edtCount.text = it.toString()
        })

        binding.btnCount.setOnClickListener {
            viewModel.getCount()
        }


    }
}