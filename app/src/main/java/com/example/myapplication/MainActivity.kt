package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

     var quantity: String = "0"
     var maxquantity: String = "0"

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val elegantNumberButton_1 = findViewById<ElegantNumberButton>(R.id.button_1)
        val elegantNumberButton_2 = findViewById<ElegantNumberButton>(R.id.button_2)
        val text = findViewById<TextView>(R.id.text_2)
        val button = findViewById<Button>(R.id.button_3)



        elegantNumberButton_1.setOnClickListener(ElegantNumberButton.OnClickListener {
            maxquantity = elegantNumberButton_1.number
            text.visibility = View.VISIBLE
            elegantNumberButton_2.visibility = View.VISIBLE

        })


            elegantNumberButton_2.setOnClickListener(ElegantNumberButton.OnClickListener {
                quantity = elegantNumberButton_2.number
                button.visibility = View.VISIBLE

            })



        button.setOnClickListener(View.OnClickListener {
            if(quantity.toInt() > maxquantity.toInt()){
                Toast.makeText(this, " There are $quantity apples in the cart", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, SecondActivity2::class.java)
                intent.putExtra("q", quantity )
                intent.putExtra("mq", maxquantity )
                startActivity(intent)
            }

            })




    }
}