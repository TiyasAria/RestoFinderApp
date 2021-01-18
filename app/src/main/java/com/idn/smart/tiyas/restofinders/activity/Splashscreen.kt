package com.idn.smart.tiyas.restofinders.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.idn.smart.tiyas.restofinders.R

class Splashscreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long = 4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java ))
            finish()
        }, SPLASH_TIME_OUT)

    }
}