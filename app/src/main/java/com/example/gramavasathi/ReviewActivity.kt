package com.example.gramavasathi

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_review)

        val name = findViewById<EditText>(R.id.nameReview)
        val review = findViewById<EditText>(R.id.reviewText)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)


        val output = findViewById<TextView>(R.id.outputReview)

        val submitBtn = findViewById<Button>(R.id.submitBtn)

        submitBtn.setOnClickListener {


            val name = findViewById<EditText>(R.id.nameReview)
            val review = findViewById<EditText>(R.id.reviewText)

            val reviewData = hashMapOf(

                "name" to name.text.toString(),
                "review" to review.text.toString(),
                "rating" to ratingBar.rating

            )

            FirebaseFirestore.getInstance()
                .collection("Reviews")
                .add(reviewData)

                .addOnSuccessListener {

                    Toast.makeText(
                        this,
                        "Review Saved",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                .addOnFailureListener {

                    Toast.makeText(
                        this,
                        "Failed",
                        Toast.LENGTH_SHORT
                    ).show()

                }


        }

    }
}
