package com.example.gramavasathi

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        val nameEdit =
            findViewById<EditText>(R.id.nameEdit)

        val phoneEdit =
            findViewById<EditText>(R.id.phoneEdit)

        val emailEdit =
            findViewById<EditText>(R.id.emailEdit)

        val passwordEdit =
            findViewById<EditText>(R.id.passwordEdit)

        val confirmPasswordEdit =
            findViewById<EditText>(R.id.confirmPasswordEdit)

        val registerBtn =
            findViewById<Button>(R.id.registerBtn)

        registerBtn.setOnClickListener {

            val name = nameEdit.text.toString()
            val phone = phoneEdit.text.toString()
            val email = emailEdit.text.toString()
            val password = passwordEdit.text.toString()
            val confirmPassword =
                confirmPasswordEdit.text.toString()

            // Phone validation
            if (phone.length != 10) {

                Toast.makeText(
                    this,
                    "Phone number must be 10 digits",
                    Toast.LENGTH_SHORT
                ).show()

            }

            // Gmail validation
            else if (!email.endsWith("@gmail.com")) {

                Toast.makeText(
                    this,
                    "Enter valid Gmail ID",
                    Toast.LENGTH_SHORT
                ).show()

            }

            // Password validation
            else if (password != confirmPassword) {

                Toast.makeText(
                    this,
                    "Passwords do not match",
                    Toast.LENGTH_SHORT
                ).show()

            }

            else {

                Toast.makeText(
                    this,
                    "Registration Successful",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(this, LoginActivity::class.java)
                )
            }
        }
    }
}