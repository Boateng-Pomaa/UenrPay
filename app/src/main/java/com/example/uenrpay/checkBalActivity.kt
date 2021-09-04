package com.example.uenrpay

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.uenrpay.Data.Api.ApiService
import com.example.uenrpay.Data.model.FeeResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext


class CheckBalActivity : AppCompatActivity() , CoroutineScope {
    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
    var iD = ""
    var Index_Number = findViewById<EditText>(R.id.editTextTextPersonName4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_bal)
        val d = intent
        iD = d.getStringExtra("Index_Number").toString()
        val check = findViewById<Button>(R.id.button7)

        check.setOnClickListener {
            launch{
                checkBal()
            }
        }
    }

 suspend fun checkBal(){
    ApiService.loginApiCall().getFee().enqueue(object : Callback<FeeResponse> {
        override fun onResponse(
            call: Call<FeeResponse>,
            response: Response<FeeResponse>
        ) {
            Log.d("Response Fee ::::", response.body().toString())
            if (response.body()!!.status){
                val v = Intent(this@CheckBalActivity,BalFeedActivity::class.java)
                v.putExtra("Fee Balance",response.body()!!.data.fee_balance)
                startActivity(v)


            }
        }

        override fun onFailure(call: Call<FeeResponse>, t: Throwable) {
//                            Log.d("error::::",t?.message)
        }

    })
}

}