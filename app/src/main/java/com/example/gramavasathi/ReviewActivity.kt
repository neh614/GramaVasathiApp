package com.example.gramavasathi

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_review)

        val name = findViewById<EditText>(R.id.nameReview)
        val review = findViewById<EditText>(R.id.reviewText)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val output = findViewById<TextView>(R.id.outputReview)

        submitBtn.setOnClickListener {

            output.text =
                "Thank You ${name.text}!\n\nRating: ${ratingBar.rating} ⭐\n\nReview:\n${review.text}"
        }
    }
}
