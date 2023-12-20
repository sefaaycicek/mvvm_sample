package com.sirketismi.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sirketismi.lesson2.databinding.ActivityMainBinding
import com.sirketismi.lesson2.databinding.ActivityMainBindingImpl

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }

    fun observerAll() {
        viewModel.buttonClickObserver.observe(this, Observer {
            if(it) {
                viewModel.updateProductname("Product-1")
            }
        })

        viewModel.onProductListUpdated.observe(this) {

        }

        viewModel.loginObserver.observe(this) {loginType->
            when(loginType) {
                LoginType.FACEBOOK-> {}
                LoginType.GOOGLE-> {}
                else->{}
            }

        }
    }

    fun removeAllObservers() {
        viewModel.buttonClickObserver.removeObservers(this)
        viewModel.buttonClickObserver.postValue(false)
    }

    override fun onResume() {
        super.onResume()
        observerAll()
    }

    override fun onPause() {
        super.onPause()
        removeAllObservers()

    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}