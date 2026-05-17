package com.example.gramavasathi

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod


class LoginActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val loginInput =
            findViewById<EditText>(R.id.loginInput)

        val passwordInput =
            findViewById<EditText>(R.id.passwordInput)


        var isPasswordVisible = false

        passwordInput.setOnClickListener {
            // keep normal click working
        }


        passwordInput.setOnTouchListener { _, event ->

            val drawableRight = 2

            if (event.action == android.view.MotionEvent.ACTION_UP) {

                if (event.rawX >= (passwordInput.right -
                            passwordInput.compoundDrawables[drawableRight].bounds.width())) {

                    if (isPasswordVisible) {

                        passwordInput.transformationMethod =
                            PasswordTransformationMethod.getInstance()

                        isPasswordVisible = false

                    } else {

                        passwordInput.transformationMethod =
                            HideReturnsTransformationMethod.getInstance()

                        isPasswordVisible = true
                    }

                    passwordInput.setSelection(passwordInput.text.length)

                    return@setOnTouchListener true
                }
            }

            false
        }
        val loginBtn =
            findViewById<Button>(R.id.loginBtn)

        val registerText =
            findViewById<TextView>(R.id.registerText)

        val forgotPassword =
            findViewById<TextView>(R.id.forgotPassword)



        // Open Register Page
        registerText.setOnClickListener {

            startActivity(
                Intent(this, RegisterActivity::class.java)
            )
        }

        forgotPassword.setOnClickListener {

            val email =
                loginInput.text.toString().trim()

            if (email.isEmpty()) {

                Toast.makeText(
                    this,
                    "Enter your Gmail first",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener {

                        if (it.isSuccessful) {

                            Toast.makeText(
                                this,
                                "Reset email sent",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {

                            Toast.makeText(
                                this,
                                "Failed to send reset email",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }

        // Firebase Login
        loginBtn.setOnClickListener {

            val email =
                loginInput.text.toString().trim()

            val password =
                passwordInput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Enter Email and Password",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->

                        if (task.isSuccessful) {

                            Toast.makeText(
                                this,
                                "Login Successful",
                                Toast.LENGTH_SHORT
                            ).show()

                            startActivity(
                                Intent(this, HomeActivity::class.java)
                            )

                            finish()

                        } else {

                            Toast.makeText(
                                this,
                                "Login Failed: ${task.exception?.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }
    }


}
