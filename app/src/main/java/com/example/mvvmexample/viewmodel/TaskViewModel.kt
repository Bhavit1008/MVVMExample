package com.example.mvvmexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.model.Task
import java.util.*
import kotlin.properties.ObservableProperty

class TaskViewModel () : ViewModel(){

    var count :Int = 0
    var countLiveData = MutableLiveData<Int>()

    fun getCount() : MutableLiveData<Int>{
        count++
        countLiveData.value = count
        return countLiveData
    }

    fun initialCount() : MutableLiveData<Int> {
        countLiveData.value = count
        return countLiveData
    }
}