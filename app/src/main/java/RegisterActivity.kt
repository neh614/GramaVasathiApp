package com.example.gramavasathi

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()



        val nameEdit =
            findViewById<EditText>(R.id.nameEdit)


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

            val email = emailEdit.text.toString()
            val password = passwordEdit.text.toString()
            val confirmPassword =
                confirmPasswordEdit.text.toString()

            // Gmail validation
            if (!email.endsWith("@gmail.com")) {

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

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->

                        if (task.isSuccessful) {

                            Toast.makeText(
                                this,
                                "Registration Successful",
                                Toast.LENGTH_SHORT
                            ).show()

                            val user = hashMapOf(

                                "name" to name,

                                "email" to email
                            )

                            db.collection("Users")
                                .document(auth.currentUser!!.uid)
                                .set(user)

                            startActivity(
                                Intent(this, LoginActivity::class.java)
                            )

                            finish()

                        } else {

                            Toast.makeText(
                                this,
                                "Registration Failed: ${task.exception?.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

            }

        }
    }
}