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
        val iD: String
        val d = intent
        iD = d.getStringExtra("Index_Number").toString()
        pay.setOnClickListener {
            val p = Intent(this,PayFeeActivity::class.java)
            p.putExtra("Index Number", iD)
            startActivity(p)
            finish()
        }
        reg.setOnClickListener {
            val r = Intent(this,RegCourseActivity::class.java)
            r.putExtra("Index Number", iD)
            startActivity(r)
            finish()
        }
        check.setOnClickListener {
            val c = Intent(this,CheckBalActivity::class.java)
            c.putExtra("Index Number", iD)
            startActivity(c)
            finish()
        }
        logout.setOnClickListener {
            val l = Intent(this,MainActivity::class.java)
            startActivity(l)
            finish()
        }
    }
}