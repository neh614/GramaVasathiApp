package com.example.gramavasathi

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChecklistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_checklist)

        val waterCheck = findViewById<CheckBox>(R.id.waterCheck)
        val roomCheck = findViewById<CheckBox>(R.id.roomCheck)
        val toiletCheck = findViewById<CheckBox>(R.id.toiletCheck)
        val foodCheck = findViewById<CheckBox>(R.id.foodCheck)

        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateBtn.setOnClickListener {

            var score = 0

            if (waterCheck.isChecked) score += 25
            if (roomCheck.isChecked) score += 25
            if (toiletCheck.isChecked) score += 25
            if (foodCheck.isChecked) score += 25

            resultText.text = "Host Readiness Score: $score%"
        }
    }
}