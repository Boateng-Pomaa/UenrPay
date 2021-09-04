package com.example.uenrpay

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val pay = findViewById<Button>(R.id.button6)
        val reg = findViewById<Button>(R.id.button9)
        val check = findViewById<Button>(R.id.button10)
        val logout = findViewById<Button>(R.id.button11)

        pay.setOnClickListener {
            val p = Intent(this,PayFeeActivity::class.java)
            startActivity(p)
        }
        reg.setOnClickListener {
            val r = Intent(this,RegCourseActivity::class.java)
            startActivity(r)
        }
        check.setOnClickListener {
            val c = Intent(this,CheckBalActivity::class.java)
            startActivity(c)
        }
        logout.setOnClickListener {
            val l = Intent(this,MainActivity::class.java)
            startActivity(l)
        }
    }
}