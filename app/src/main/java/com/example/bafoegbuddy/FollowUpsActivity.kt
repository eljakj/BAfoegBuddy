package com.example.bafoegbuddy

import android.widget.TextView
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FollowUpsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_followups)

        val markDoneButton = findViewById<Button>(R.id.markDoneButton)
        markDoneButton.setOnClickListener {
            Toast.makeText(this, "Nachforderung im Prototyp als erledigt markiert.", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.backToDashboardButton).setOnClickListener {
            finish()
        }

        val addDocumentButton = findViewById<Button>(R.id.addDocumentButton)
        addDocumentButton.setOnClickListener {
            Toast.makeText(this, "Dokument zur Nachforderung im Prototyp vorbereitet.", Toast.LENGTH_SHORT).show()
        }
    }
}