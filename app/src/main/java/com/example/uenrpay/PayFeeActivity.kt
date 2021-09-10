package com.example.uenrpay

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.uenrpay.Data.Api.ApiList
import com.example.uenrpay.Data.Api.ApiService
import com.example.uenrpay.Data.model.StudentResponse
import com.example.uenrpay.Data.repository.SecRepository
import com.example.uenrpay.ui.base.SecViewModelFactory
import com.example.uenrpay.ui.main.viewModel.SecViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext


class PayFeeActivity : AppCompatActivity(), CoroutineScope {
    private lateinit var viewModel: SecViewModel
    private lateinit var viewModelFactory: SecViewModelFactory
    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job



    var result = findViewById<TextView>(R.id.textView6)
    val verify = findViewById<Button>(R.id.button2)
    val proceed = findViewById<Button>(R.id.button3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_fee)

        val apilist = ApiList.loginApiCall()
        val mainrepo = SecRepository(apilist)
        viewModelFactory = SecViewModelFactory(mainrepo)
        viewModel = ViewModelProvider(this,viewModelFactory).get(SecViewModel::class.java)

        result.addTextChangedListener(valid)

        verify.setOnClickListener {
            launch {
                details()
            }
        }
        proceed.setOnClickListener {
            launch{
                proceed()
            }
        }

    }
    private val valid = object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            result.text = s
            if (result.text.isNotEmpty()) {
                proceed.isEnabled = true
            }
        }
        override fun afterTextChanged(s: Editable?) {
            TODO("Not yet implemented")
        }


    }
    private suspend fun details(){
        ApiService.loginApiCall().getStudent().enqueue(object : Callback<StudentResponse> {
            override fun onResponse(
                call: Call<StudentResponse>,
                response: Response<StudentResponse>
            ) {
                Log.d("Response Student ::::", response.body().toString())
                if (response.body()!!.status){
                    result.setText(response.body()!!.data.toString())

                }
            }

            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
//                            Log.d("error::::",t?.message)
            }

        })
    }
    private suspend fun proceed(){
        ApiService.loginApiCall().getStudent().enqueue(object : Callback<StudentResponse> {
            override fun onResponse(
                call: Call<StudentResponse>,
                response: Response<StudentResponse>
            ) {
                Log.d("Response Student ::::", response.body().toString())
                if (response.body()!!.status){
                    //API CALL
                    val b = Intent(this@PayFeeActivity,MenuActivity::class.java)
                    startActivity(b)
                }
            }

            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
//                            Log.d("error::::",t?.message)
            }

        })
    }
    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
