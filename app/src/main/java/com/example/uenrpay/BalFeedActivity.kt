package com.example.uenrpay

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class BalFeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bal_feed)

        val fb: String
        val fee = intent
        fb = fee.getStringExtra("fee balance").toString()

        val fees = findViewById<EditText>(R.id.editTextTextPersonName2)
        fees.setText(fb)


        val ok = findViewById<Button>(R.id.button4)
        ok.setOnClickListener {
            val menu = Intent(this,MenuActivity::class.java)
            startActivity(menu)
        }
    }
}

