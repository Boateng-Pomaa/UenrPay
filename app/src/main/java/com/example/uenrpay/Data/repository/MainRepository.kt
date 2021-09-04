package com.example.uenrpay.Data.repository

import com.example.uenrpay.Data.Api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun doLogin()= apiHelper.doLogin()

}