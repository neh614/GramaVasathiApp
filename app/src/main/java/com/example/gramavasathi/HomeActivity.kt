package com.example.gramavasathi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)
        val searchBox = findViewById<EditText>(R.id.searchBox)
        val searchResult = findViewById<TextView>(R.id.searchResult)

        val cowBtn = findViewById<Button>(R.id.cowBtn)

        cowBtn.setOnClickListener {

            startActivity(Intent(this, FarmStayActivity::class.java))

        }
        val checklistBtn = findViewById<Button>(R.id.checklistBtn)

        checklistBtn.setOnClickListener {

            startActivity(Intent(this, ChecklistActivity::class.java))

        }
        val reviewBtn = findViewById<Button>(R.id.reviewBtn)

        reviewBtn.setOnClickListener {

            startActivity(Intent(this, ReviewActivity::class.java))

        }
        searchBox.setOnEditorActionListener { _, _, _ ->

            val searchText = searchBox.text.toString()

            if (searchText.contains("farm", true)) {

                searchResult.text =
                    "Farming Experience Available"

            } else if (searchText.contains("campfire", true)) {

                searchResult.text =
                    "Campfire Available"

            } else if (searchText.contains("food", true)) {

                searchResult.text =
                    "Organic Village Food Available"

            } else {

                searchResult.text =
                    "No Activities Found"

            }

            true
        }
        val chatBtn = findViewById<Button>(R.id.chatBtn)

        chatBtn.setOnClickListener {

            startActivity(Intent(this, ChatbotActivity::class.java))

        }
        val placeBtn = findViewById<Button>(R.id.placeBtn)

        placeBtn.setOnClickListener {

            startActivity(Intent(this, PlacesActivity::class.java))

        }

        val profileBtn =
            findViewById<Button>(R.id.profileBtn)

        profileBtn.setOnClickListener {

            startActivity(
                Intent(this, ProfileActivity::class.java)
            )
        }
    }
}