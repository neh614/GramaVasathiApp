package com.example.gramavasathi

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_payment)

        val amountEdit =
            findViewById<EditText>(R.id.amountEdit)

        val paymentGroup =
            findViewById<RadioGroup>(R.id.paymentGroup)

        val payBtn =
            findViewById<Button>(R.id.payBtn)

        val paymentResult =
            findViewById<TextView>(R.id.paymentResult)

        payBtn.setOnClickListener {

            val amount =
                amountEdit.text.toString()

            val selectedId =
                paymentGroup.checkedRadioButtonId

            if (amount.isEmpty()) {

                Toast.makeText(
                    this,
                    "Enter amount",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else if (selectedId == -1) {

                Toast.makeText(
                    this,
                    "Select payment method",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else {

                val selectedRadio =
                    findViewById<RadioButton>(selectedId)

                paymentResult.text =
                    "✅ Payment of ₹$amount successful using ${selectedRadio.text}"

                Toast.makeText(
                    this,
                    "Payment Successful",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}