package com.example.qenatest.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val _toolBarTitle = MutableLiveData<String>()
    val toolBarTitle: LiveData<String> get() = _toolBarTitle

    fun updateToolBarTitle(newTitle: String) {
        _toolBarTitle.value = newTitle
    }
}