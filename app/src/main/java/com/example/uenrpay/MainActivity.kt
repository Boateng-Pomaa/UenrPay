package com.example.uenrpay

import LoginResponse
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.uenrpay.Data.Api.ApiList
import com.example.uenrpay.Data.Api.ApiService
import com.example.uenrpay.Data.repository.MainRepository
import com.example.uenrpay.ui.base.BaseViewModelFactory
import com.example.uenrpay.ui.main.viewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: BaseViewModelFactory
    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apilist = ApiList.loginApiCall()
        val mainrepo = MainRepository(apilist)
        viewModelFactory = BaseViewModelFactory(mainrepo)
         viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        username = findViewById(R.id.editTextTextPersonName)
            password = findViewById(R.id.editTextTextPassword)

            val login = findViewById<Button>(R.id.button)
            login.setOnClickListener {
               launch {
                    login()
                }
            }
        }


     private suspend fun login (){
        if (validation()) {
            val json = JSONObject()
            json.put("Index_Number", username.text.toString())
            json.put("Password", password.text.toString())

            ApiService.loginApiCall().doLogin().enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                ) {

                    Log.d("Response::::", response.body().toString())
                    if (response.body()!!.isLogin) {

                        val o = Intent(this@MainActivity, MenuActivity::class.java)
                        o.putExtra("Index_Number", response.body()!!.data.Index_Number)
                        startActivity(o)

                    } else {
                        Toast.makeText(applicationContext, response.body()!!.message, Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                }

            })
        }
    }



        private fun validation(): Boolean {
            var value = true

            val passw = password.text.toString().trim()
            val user = username.text.toString().trim()

            if (passw.isEmpty()) {
                password.error = "Password required"
                password.requestFocus()
                value = false
            }

            if (user.isEmpty()) {
                username.error = "Index Number required"
                username.requestFocus()
                value = false
            }

            return value
        }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
    }

