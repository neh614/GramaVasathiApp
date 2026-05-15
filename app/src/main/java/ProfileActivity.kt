package com.example.gramavasathi

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        val name = findViewById<EditText>(R.id.profileName)
        val email = findViewById<EditText>(R.id.profileEmail)
        val phone = findViewById<EditText>(R.id.profilePhone)

        val saveBtn =
            findViewById<Button>(R.id.saveProfileBtn)

        val result =
            findViewById<TextView>(R.id.profileResult)

        saveBtn.setOnClickListener {

            result.text =
                "Profile Saved Successfully ✅"
        }
    }
}