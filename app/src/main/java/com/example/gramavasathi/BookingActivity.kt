package com.example.gramavasathi

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import android.widget.Toast
import android.content.Intent

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_booking)

        val name = findViewById<EditText>(R.id.name)
        val date = findViewById<EditText>(R.id.date)

        val confirmBtn = findViewById<Button>(R.id.confirmBtn)
        val result = findViewById<TextView>(R.id.result)

        // Calendar Date Picker
        date.setOnClickListener {

            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->

                    val selectedDate =
                        "$selectedDay/${selectedMonth + 1}/$selectedYear"

                    date.setText(selectedDate)
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }

        // Confirm Booking Button
        confirmBtn.setOnClickListener {

            result.text =
                "Booking Confirmed for ${name.text} on ${date.text}"

            Toast.makeText(
                this,
                "Booking Successful!",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(
                Intent(this, PaymentActivity::class.java)
            )
        }
    }
}