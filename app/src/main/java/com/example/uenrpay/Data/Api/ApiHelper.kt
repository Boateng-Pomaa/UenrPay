package com.example.uenrpay.Data.Api

import LoginResponse
import com.example.uenrpay.Data.model.FeeResponse
import com.example.uenrpay.Data.model.StudentResponse
import retrofit2.Call

class ApiHelper (private val apiList: ApiList) {

    suspend fun doLogin(): Call<LoginResponse> = apiList.doLogin("","")
    suspend fun getStudent():Call<StudentResponse> = apiList.getStudent()
    suspend fun getFee():Call<FeeResponse> = apiList.getFee()
}