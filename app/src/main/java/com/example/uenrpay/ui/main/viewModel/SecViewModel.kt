package com.example.uenrpay.ui.main.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.uenrpay.Data.repository.SecRepository
import com.example.uenrpay.utils.Resource
import kotlinx.coroutines.Dispatchers

class SecViewModel constructor (private val secRepository: SecRepository) : ViewModel() {

    fun getStudent() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = secRepository.getStudent()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("SecViewModel", "SecViewModel destroyed!")
    }
}