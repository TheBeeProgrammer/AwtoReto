package com.example.awtoreto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class JokeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AwtoReto)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)
    }
}