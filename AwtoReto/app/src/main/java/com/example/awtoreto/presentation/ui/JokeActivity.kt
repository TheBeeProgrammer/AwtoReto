package com.example.awtoreto.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.awtoreto.R

class JokeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AwtoReto)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)
    }
}