package com.example.bafoegbuddy

import android.widget.TextView
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ApplicationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)

        val saveButton = findViewById<Button>(R.id.saveApplicationButton)
        saveButton.setOnClickListener {
            Toast.makeText(this, "Antragsdaten im Prototyp gespeichert.", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.backToDashboardButton).setOnClickListener {
            finish()
        }
    }
}