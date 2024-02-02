package com.example.blink.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.blink.R


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    // Set the duration of the splash screen
    private val SPLASH_TIME_OUT: Long = 3000 // 3 seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        // Use Handler to delay the transition to the main activity
        Handler().postDelayed({
            // Start the main activity after the splash time out
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}