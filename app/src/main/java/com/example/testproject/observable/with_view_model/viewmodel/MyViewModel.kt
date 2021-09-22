package com.example.testproject.observable.with_view_model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MyViewModel(): ViewModel() {

    private var _subscribeData = MutableSharedFlow<String>()
    val subscribeData: Flow<String> = _subscribeData

    fun sendData (text: String){
        viewModelScope.launch {
            _subscribeData.emit(text)
        }
    }
}