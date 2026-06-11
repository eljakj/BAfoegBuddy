package com.example.bafoegbuddy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val applicationCard = findViewById<View>(R.id.applicationCard)
        applicationCard.setOnClickListener {
            val intent = Intent(this, ApplicationActivity::class.java)
            startActivity(intent)
        }

        val documentsCard = findViewById<TextView>(R.id.documentsCard)
        documentsCard.setOnClickListener {
            val intent = Intent(this, DocumentsActivity::class.java)
            startActivity(intent)
        }

        val deadlinesCard = findViewById<TextView>(R.id.deadlinesCard)
        deadlinesCard.setOnClickListener {
            val intent = Intent(this, DeadlinesActivity::class.java)
            startActivity(intent)
        }

        val followUpsCard = findViewById<TextView>(R.id.followUpsCard)
        followUpsCard.setOnClickListener {
            val intent = Intent(this, FollowUpsActivity::class.java)
            startActivity(intent)
        }
    }
}