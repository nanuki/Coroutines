package com.example.myapplication

import android.app.SearchManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton
import kotlinx.coroutines.*

class SecondActivity2 : AppCompatActivity() {

    var quantity: String = "0"
    var maxquantity: String = "0"
     var count: Int = 0
     var size: Int = 0
     var x: Int = 0
     var y: String = "0"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)



        val text = findViewById<TextView>(R.id.txt_1)
        val btn_1 = findViewById<ElegantNumberButton>(R.id.btn_1)
        val btn_2 = findViewById<Button>(R.id.btn_2)





        val intent = getIntent()
        quantity = intent.getStringExtra("q")
        y = quantity
        maxquantity = intent.getStringExtra("mq")
        size = maxquantity .toInt()
        btn_1.setNumber(quantity)

        GlobalScope.launch(Dispatchers.Main){
            text.text = " There are $y apples in the cart"
            withContext(Dispatchers.Default){

                while (btn_1.number.toInt() in 0..size){
                    btn_1.setOnClickListener(ElegantNumberButton.OnClickListener {
                        quantity  =  btn_1.number

                    })

                    withContext(Dispatchers.Main){
                        text.text = " There are $quantity apples in the cart"

                        if(btn_1.number.toInt() == 0 || btn_1.number.toInt() == size ){
                            btn_1.visibility = View.GONE
                            btn_2.visibility = View.VISIBLE
                            if (btn_1.number.toInt() == size){
                                text.text = "The cart is full and there are $quantity apples."
                            }
                            else if(btn_1.number.toInt() == 0) { text.text = "There are no apples in the cart"}
                        }
                        btn_2.setOnClickListener(View.OnClickListener {
                            btn_2.visibility = View.GONE
                            btn_1.visibility = View.VISIBLE
                            quantity = y
                            size = maxquantity .toInt()
                            btn_1.setNumber(quantity)
                            text.text = " There are $y apples in the cart"

                        })

                    }


                }


            }
        }


    }

}