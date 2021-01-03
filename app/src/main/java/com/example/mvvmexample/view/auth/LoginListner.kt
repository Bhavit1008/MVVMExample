package com.example.mvvmexample.view.auth

import androidx.lifecycle.LiveData

interface LoginListner {
    fun onStarted()

    fun onSuccess(loginResponseFromRepository:LiveData<String>)

    fun onFailure(message:String)
}