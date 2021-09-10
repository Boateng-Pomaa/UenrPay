package com.example.uenrpay.Data.Api

import retrofit2.Retrofit

object ApiService {
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