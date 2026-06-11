package com.example.bafoegbuddy


import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DocumentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_documents)

        val uploadCard = findViewById<TextView>(R.id.uploadDocumentCard)
        uploadCard.setOnClickListener {
            Toast.makeText(this, "Dokument-Upload im Prototyp vorbereitet.", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.backToDashboardButton).setOnClickListener {
            finish()
        }
    }
}