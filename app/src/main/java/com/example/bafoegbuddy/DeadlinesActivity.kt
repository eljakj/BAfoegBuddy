package com.example.bafoegbuddy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DeadlinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deadlines)

        findViewById<TextView>(R.id.backToDashboardButton).setOnClickListener {
            finish()
        }
    }
}