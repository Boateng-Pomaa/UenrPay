package com.example.uenrpay.Data.Api

import LoginResponse
import com.example.uenrpay.Data.model.FeeResponse
import com.example.uenrpay.Data.model.StudentResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiList {



        //TODO : Login User
        @POST("login2.php")
      suspend  fun doLogin(
            @Field("Index Number")Index_Number:String,
            @Field("Password")Password:String
      ):
                Call<LoginResponse> // body data

        //TODO : Get Student
       @GET("getStudent.php")
       suspend fun getStudent(): Call<StudentResponse>

        //TODO : Get Fee
        @GET("fee.php")
      suspend  fun getFee(): Call<FeeResponse>
    }
