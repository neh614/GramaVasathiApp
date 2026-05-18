package com.example.gramavasathi

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PlacesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_places)

        val listView =
            findViewById<ListView>(R.id.placesList)

        val places = arrayOf(

            "🌊 Shivanasamudra Waterfalls",
            "🏛 Somanathapura Temple",
            "🌳 Ranganathittu Bird Sanctuary",
            "🚜 Village Farming Experience"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            places
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->

            Toast.makeText(
                this,
                "${places[position]} selected",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}