package com.example.chorddition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class splash : AppCompatActivity() {
    // creates timer for splash screen
    private val splashTimeOut: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        // redirects to MainActivity after splash screen ends
        android.os.Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, splashTimeOut)
    }
}