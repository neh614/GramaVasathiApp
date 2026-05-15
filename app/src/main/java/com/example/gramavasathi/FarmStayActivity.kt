package com.example.gramavasathi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FarmStayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farm_stay)

        val bookBtn = findViewById<Button>(R.id.bookBtn)
        val mapBtn = findViewById<Button>(R.id.mapBtn)

        // Booking button
        bookBtn.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            startActivity(intent)
        }

        // Map button
        mapBtn.setOnClickListener {

            val gmmIntentUri =
                Uri.parse("geo:0,0?q=Mandya Farm Stay Karnataka")

            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

            mapIntent.setPackage("com.google.android.apps.maps")

            startActivity(mapIntent)
        }
    }
}