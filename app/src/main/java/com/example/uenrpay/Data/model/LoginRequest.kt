package com.example.uenrpay.Data.model

import com.google.gson.annotations.SerializedName

class LoginRequest(
        @SerializedName("Index_Number") var Index_Number: String,
        @SerializedName("Password") var Password: String,
)