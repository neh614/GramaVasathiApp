package com.example.gramavasathi

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class FarmStayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_farm_stay)

        val searchEdit =
            findViewById<EditText>(R.id.searchEdit)

        val farmListView =
            findViewById<ListView>(R.id.farmListView)

        val farmStays = arrayListOf(

            "🌾 Green Village Farm Stay",
            "🐄 Cow Milking Experience Stay",
            "🔥 Campfire Nature Stay",
            "🌿 Organic Farming Stay",
            "🍲 Traditional Village Cooking Stay",
            "🐂 Bullock Cart Ride Stay",
            "🌴 Coconut Garden Farm Stay",
            "🌄 Sunrise Village Resort"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            farmStays
        )

        farmListView.adapter = adapter

        searchEdit.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {

                adapter.filter.filter(s)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
}