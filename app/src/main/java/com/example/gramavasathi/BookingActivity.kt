
package com.example.gramavasathi

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import com.google.firebase.firestore.FirebaseFirestore


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
        

        val result =
            findViewById<TextView>(R.id.result)

        checkIn.setOnClickListener {

            showDatePicker(checkIn)
        }

        checkOut.setOnClickListener {

            showDatePicker(checkOut)
        }

        val confirmBtn = findViewById<Button>(R.id.confirmBtn)

        confirmBtn.setOnClickListener {


            val bookingData = hashMapOf(

                "name" to name.text.toString(),
                "checkIn" to checkIn.text.toString(),
                "checkOut" to checkOut.text.toString(),
                "guests" to guests.text.toString()

            )

            FirebaseFirestore.getInstance()
                .collection("Bookings")
                .add(bookingData)

                .addOnSuccessListener {

                    result.text = "Booking Saved Successfully"

                }

                .addOnFailureListener {

                    result.text = "Booking Failed"

                }


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

