package com.example.gramavasathi

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FarmActivitiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_farm_activities)

        val listView =
            findViewById<ListView>(R.id.activitiesList)

        val activities = arrayOf(

            "🐄 Cow Milking Experience",
            "🌾 Organic Farming Activity",
            "🔥 Village Campfire Night",
            "🍲 Traditional Village Cooking",
            "🐂 Bullock Cart Ride"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            activities
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->

            Toast.makeText(
                this,
                "${activities[position]} selected",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}