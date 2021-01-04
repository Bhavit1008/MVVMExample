package com.example.mvvmexample.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.model.repository.UserRepository
import com.example.mvvmexample.view.auth.LoginListner

class LoginViewModel:ViewModel() {

    var email:String = ""
    var password:String = ""

    var loginListner:LoginListner? = null

    fun onLoginButtonClick(view:View){
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            loginListner?.onFailure("please enter mail and password is mendatory")
            return
        }
        else{
            val userLoginResponse = UserRepository().loginUser(email!!,password!!)
            loginListner?.onSuccess(userLoginResponse)
        }
    }

}