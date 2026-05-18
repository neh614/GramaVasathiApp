
package com.example.gramavasathi

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_booking)

        val name = findViewById<EditText>(R.id.name)

        val checkIn =
            findViewById<EditText>(R.id.checkInDate)

        val checkOut =
            findViewById<EditText>(R.id.checkOutDate)

        val guests =
            findViewById<EditText>(R.id.guests)

        val confirmBtn =
            findViewById<Button>(R.id.confirmBtn)

        val result =
            findViewById<TextView>(R.id.result)

        checkIn.setOnClickListener {

            showDatePicker(checkIn)
        }

        checkOut.setOnClickListener {

            showDatePicker(checkOut)
        }

        confirmBtn.setOnClickListener {

            val userName = name.text.toString()

            val inDate = checkIn.text.toString()

            val outDate = checkOut.text.toString()

            val guestCount = guests.text.toString()

            result.text =
                "Booking Confirmed for $userName\nGuests: $guestCount"
        }
    }

    private fun showDatePicker(editText: EditText) {

        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)

        val month = calendar.get(Calendar.MONTH)

        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->

                val selectedDate =
                    "$selectedDay/${selectedMonth + 1}/$selectedYear"

                editText.setText(selectedDate)
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }
}

