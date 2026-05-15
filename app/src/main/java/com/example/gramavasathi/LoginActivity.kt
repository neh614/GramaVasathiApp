package com.example.gramavasathi

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val loginInput =
            findViewById<EditText>(R.id.loginInput)

        val passwordInput =
            findViewById<EditText>(R.id.passwordInput)

        val loginBtn =
            findViewById<Button>(R.id.loginBtn)

        val registerText =
            findViewById<TextView>(R.id.registerText)

        // Register page open
        registerText.setOnClickListener {

            startActivity(
                Intent(this, RegisterActivity::class.java)
            )
        }

        // Login validation
        loginBtn.setOnClickListener {

            val input =
                loginInput.text.toString()

            val password =
                passwordInput.text.toString()

            // Gmail login
            if (input.contains("@gmail.com")) {

                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(this, HomeActivity::class.java)
                )
            }

            // Phone login
            else if (input.length == 10) {

                Toast.makeText(
                    this,
                    "Phone Login Successful",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(this, HomeActivity::class.java)
                )
            }

            else {

                Toast.makeText(
                    this,
                    "Enter valid Gmail or Phone Number",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}