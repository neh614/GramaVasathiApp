package com.example.gramavasathi

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class BookingHistoryActivity : AppCompatActivity() {


    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_history)

        db = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()

        val historyLayout =
            findViewById<LinearLayout>(R.id.historyLayout)

        val currentUser =
            auth.currentUser

        if (currentUser != null) {

            db.collection("Bookings")
                .get()
                .addOnSuccessListener { documents ->

                    for (document in documents) {

                        val name =
                            document.getString("name")

                        val checkIn =
                            document.getString("checkInDate")

                        val checkOut =
                            document.getString("checkOutDate")

                        val guests =
                            document.getString("guests")

                        val bookingText = TextView(this)

                        bookingText.text =
                            "Name: $name\nCheck-In: $checkIn\nCheck-Out: $checkOut\nGuests: $guests"

                        bookingText.textSize = 18f
                        bookingText.setPadding(20,20,20,20)

                        historyLayout.addView(bookingText)
                    }
                }
        }
    }

}
