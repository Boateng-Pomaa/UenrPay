package com.example.uenrpay

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.uenrpay.Data.Api.ApiList
import com.example.uenrpay.Data.Api.ApiService
import com.example.uenrpay.Data.model.FeeResponse
import com.example.uenrpay.Data.repository.ThirdRepository
import com.example.uenrpay.ui.base.ThirdViewModelFactory
import com.example.uenrpay.ui.main.viewModel.ThirdViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext


class CheckBalActivity : AppCompatActivity() , CoroutineScope {
    private lateinit var viewModel: ThirdViewModel
    private lateinit var viewModelFactory: ThirdViewModelFactory
    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_bal)
        val apilist = ApiList.loginApiCall()
        val mainrepo = ThirdRepository(apilist)
        viewModelFactory = ThirdViewModelFactory(mainrepo)
        viewModel = ViewModelProvider(this,viewModelFactory).get(ThirdViewModel::class.java)



        val d = intent
        id = d.getStringExtra("Index_Number").toString()
        val check = findViewById<Button>(R.id.button7)

        check.setOnClickListener {
            launch{
                checkBal()
            }
        }
    }

 private suspend fun checkBal(){
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
    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}