package com.example.uenrpay.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uenrpay.Data.repository.MainRepository
import com.example.uenrpay.ui.main.viewModel.MainViewModel

@Suppress("UNCHECKED_CAST")
class BaseViewModelFactory constructor( private val Index_Number:String, private val Password:String) : ViewModelProvider.Factory {

    private val repo = MainRepository()
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if
                       (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repo) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}