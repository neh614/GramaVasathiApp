package com.example.gramavasathi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChatbotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chatbot)

        val questionBox =
            findViewById<EditText>(R.id.questionBox)

        val askBtn =
            findViewById<Button>(R.id.askBtn)

        val chatLayout =
            findViewById<LinearLayout>(R.id.chatLayout)

        askBtn.setOnClickListener {

            val question =
                questionBox.text.toString()

            if (question.isNotEmpty()) {

                val userText = TextView(this)
                userText.text = "👩 You: $question"
                userText.textSize = 18f

                chatLayout.addView(userText)

                val aiReply = TextView(this)

                val answer = when {

                    question.contains("food", true) ->
                        "🍲 Organic village food is available."

                    question.contains("price", true) ->
                        "💰 Farm stay starts from ₹2500."

                    question.contains("location", true) ->
                        "📍 Located in Mandya, Karnataka."

                    question.contains("activities", true) ->
                        "🚜 Farming, campfire, bullock cart rides available."

                    else ->
                        "🤖 Sorry, I am still learning."
                }

                aiReply.text = "🤖 AI: $answer"
                aiReply.textSize = 18f

                chatLayout.addView(aiReply)

                questionBox.text.clear()
            }
        }
    }
}
