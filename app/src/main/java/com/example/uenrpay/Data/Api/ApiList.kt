package com.example.uenrpay.Data.Api

import LoginResponse
import com.example.uenrpay.Data.model.FeeResponse
import com.example.uenrpay.Data.model.StudentResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiList {


    //TODO : Login User
    @POST("login.php")
    suspend fun doLogin():
            Call<LoginResponse> // body data

    //TODO : Get Student
    @GET("getStudent.php")
    suspend fun getStudent(): Call<StudentResponse>

    //TODO : Get Fee
    @GET("fee.php")
    suspend fun getFee(): Call<FeeResponse>

    companion object {
        private val TAG = "--ApiService"

        const val BASE_URL = "http://10.0.2.2:3306/"

        fun loginApiCall() = Retrofit.Builder()
            .baseUrl(BASE_URL)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ApiWorker.gsonConverter)
            .client(ApiWorker.client)
            .build()
            .create(ApiList::class.java)!!
    }
}
