package com.sirketismi.lesson2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//MVVM
class MainActivityViewModel : ViewModel() {

    private var _productName = MutableLiveData<String>()
    val productName: LiveData<String> get() = _productName

    private val productList = mutableListOf<Product>()
    var onProductListUpdated = MutableLiveData<Boolean>()

    var name = MutableLiveData<String>()
    var surName = MutableLiveData<String>()
    private var fullName = MutableLiveData<String>()

    var onNextScreenObserver = MutableLiveData<Boolean>(false)
    var buttonClickObserver = MutableLiveData<Boolean>(false)
    var loginObserver = MutableLiveData<LoginType?>(null)

    fun updateProductname(newText : String) {
        _productName.postValue(newText)
    }

    fun getProductItem(index : Int) : Product? {
        return productList.getOrNull(index)
    }
    fun addNewItme() {
        onProductListUpdated.postValue(true)
    }

    fun removeItem() {
        onProductListUpdated.postValue(true)
    }

    fun updateName(prm : String, surname : String) {
        name.postValue(prm)
        surName.postValue(surname)
    }

    fun updateFullname() {
        fullName.postValue("${name.value} ${surName.value}")
    }


    fun onButtonSelected() {
        updateFullname()
        buttonClickObserver.postValue(true)
    }

    fun onFacebookLogin() {
        loginObserver.postValue(LoginType.FACEBOOK)
    }

    fun onGoogleLogin() {
        loginObserver.postValue(LoginType.GOOGLE)
    }

    override fun onCleared() {
        super.onCleared()
    }
}

enum class LoginType {
    FACEBOOK,
    GOOGLE
}