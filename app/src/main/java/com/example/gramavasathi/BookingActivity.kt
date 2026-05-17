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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.Locale

class BookingActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_booking)

        db = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()

        val name = findViewById<EditText>(R.id.name)
        val currentUser = auth.currentUser

        if (currentUser != null) {

            name.setText(currentUser.email)
        }
        val date = findViewById<EditText>(R.id.checkIndate)
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
        val checkOutDate =
            findViewById<EditText>(R.id.checkOutDate)

        val guests =
            findViewById<EditText>(R.id.guests)

        val confirmBtn = findViewById<Button>(R.id.confirmBtn)
        val result = findViewById<TextView>(R.id.result)

        // Calendar Date Picker
        checkOutDate.setOnClickListener {

            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->

                    val selectedDate =
                        "$selectedDay/${selectedMonth + 1}/$selectedYear"

                    checkOutDate.setText(selectedDate)
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }

        // Confirm Booking Button
        confirmBtn.setOnClickListener {

            if (name.text.toString().isEmpty() ||
                date.text.toString().isEmpty() ||
                checkOutDate.text.toString().isEmpty() ||
                guests.text.toString().isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (guests.text.toString().toInt() <= 0) {

                Toast.makeText(
                    this,
                    "Guests must be greater than 0",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val format =
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

            val checkInDate =
                format.parse(date.text.toString())

            val checkOut =
                format.parse(checkOutDate.text.toString())

            if (checkOut.before(checkInDate)) {

                Toast.makeText(
                    this,
                    "Check-Out cannot be before Check-In",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val booking = hashMapOf(

                "name" to name.text.toString(),
                "checkInDate" to date.text.toString(),
                "checkOutDate" to checkOutDate.text.toString(),
                "guests" to guests.text.toString(),
                "timestamp" to System.currentTimeMillis()
            )

            db.collection("Bookings")
                .add(booking)

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