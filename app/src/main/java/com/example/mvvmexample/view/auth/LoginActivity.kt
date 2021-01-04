package com.example.mvvmexample.view.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmexample.R
import com.example.mvvmexample.databinding.ActivityLoginBinding
import com.example.mvvmexample.hide
import com.example.mvvmexample.myToast
import com.example.mvvmexample.show
import com.example.mvvmexample.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), LoginListner {
    var progressBar :ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.loginListner = this

        progressBar = findViewById(R.id.progressBar)
    }

    override fun onStarted() {
        findViewById<ProgressBar>(R.id.progressBar).show()
        myToast("login started")
    }

    override fun onSuccess(loginResponseFromRepository: LiveData<String>) {
        loginResponseFromRepository.observe(this, Observer {
            findViewById<ProgressBar>(R.id.progressBar).hide()
            myToast(it)
        })
    }

    override fun onFailure(message: String) {
        findViewById<ProgressBar>(R.id.progressBar).hide()
        myToast("login Falied")
    }


}