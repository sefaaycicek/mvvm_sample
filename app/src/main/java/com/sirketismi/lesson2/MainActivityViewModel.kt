package com.sirketismi.lesson2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//MVVM
class MainActivityViewModel : ViewModel() {

    val productList = mutableListOf<Product>()

    var name = MutableLiveData<String>()
    var surName = MutableLiveData<String>()
    var fullName = MutableLiveData<String>()

    fun updateName(prm : String, surname : String) {
        name.postValue(prm)
        surName.postValue(surname)
    }

    fun updateFullname() {
        fullName.postValue("${name.value} ${surName.value}")
    }

    override fun onCleared() {
        super.onCleared()
    }
}