package com.example.uenrpay.Data.repository

import com.example.uenrpay.Data.Api.ApiHelper

class SecRepository (private val apiHelper: ApiHelper) {
    suspend fun getStudent() = apiHelper.getStudent()

}