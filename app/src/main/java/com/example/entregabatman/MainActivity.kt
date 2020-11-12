package com.example.entregabatman

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b =  findViewById<Button>(R.id.b)
        val et  =  findViewById<EditText>(R.id.et)
        val im = findViewById<ImageView>(R.id.im)
        val lL = findViewById<LinearLayout>(R.id.lL)

        b.setOnClickListener {
            if (et.visibility == View.INVISIBLE) {
                et.visibility = View.VISIBLE
                b.text = "Finalizar"
            }else{
                et.visibility = View.INVISIBLE
            }
        }

        b.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                b.text = "Finalizar"
            } else {
                b.append("Comenzar")
            }

        }

        et.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) {
                et.text.clear()
            }else{
                et.text.append("Introduce tu nombre: ")
            }
        }
        et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if(it.contains("Wayne")){
                        im.visibility = View.VISIBLE
                    }else
                        if (it.contains("Joker")){
                            b.setBackgroundColor(Color.parseColor(" #9b807a"))
                            et.setBackgroundColor(Color.parseColor("#a2270c"))
                            lL.setBackgroundColor(Color.parseColor("#421d16"))
                        }
                }
            }
        })
    }
}
















