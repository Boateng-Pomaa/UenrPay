package com.example.uenrpay

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegCourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_course)

        val reg = findViewById<Button>(R.id.button7)

        reg.setOnClickListener {
            finish()
            val r = Intent(this,MenuActivity::class.java)
            startActivity(r)
        }

    }
}