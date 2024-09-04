package com.example.projet_collectif_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spot)


        // Récupère nom et location spot depuis intent
        val spotName = intent.getStringExtra("SPOT_NAME")
        val spotLocation = intent.getStringExtra("SPOT_LOCATION")

        // Affiche details
        val nameTextView = findViewById<TextView>(R.id.spot_activity_name)
        val locationTextView = findViewById<TextView>(R.id.spot_activity_location)

        nameTextView.text = spotName
        locationTextView.text = spotLocation

        val button = findViewById<Button>(R.id.back_button)
        button.setOnClickListener {
            finish()
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

    }
}