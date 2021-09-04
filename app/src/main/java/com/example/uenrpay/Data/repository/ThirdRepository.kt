package com.example.uenrpay.Data.repository

import com.example.uenrpay.Data.Api.ApiHelper

class ThirdRepository (private val apiHelper: ApiHelper) {
    suspend fun getFee()= apiHelper.getFee()
}