package com.example.uenrpay.ui.main.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.uenrpay.Data.repository.ThirdRepository
import com.example.uenrpay.utils.Resource
import kotlinx.coroutines.Dispatchers

class ThirdViewModel constructor (private val mainRepository: ThirdRepository) : ViewModel() {

    fun getFee() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getFee()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("ThirdViewModel", "ThirdViewModel destroyed!")
    }
}