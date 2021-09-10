package com.example.uenrpay.ui.main.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.uenrpay.Data.repository.MainRepository
import com.example.uenrpay.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel constructor(private val mainRepository: MainRepository ) : ViewModel() {
   fun  doLogin() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.doLogin()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("MainViewModel", "MainViewModel destroyed!")
    }
}