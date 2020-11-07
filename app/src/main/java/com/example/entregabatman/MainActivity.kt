package com.example.entregabatman

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var b : Button
    private lateinit var et : EditText
    private lateinit var tv : TextView
    private lateinit var lL : LinearLayout

    private val focusListener = View.OnFocusChangeListener { vista, isFocused ->  if (isFocused) tv.text = vista.tag.toString()}



    private val textWatcher = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                tv.text="Introduce tu nombre"
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                b.isEnabled = et.text.isNotEmpty()
                if(tv.text.isEmpty())
                    tv.text="Introduce tu nombre"
                else if (tv.text.equals("wayne"))
                    lL.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
                else if (tv.text.equals("joker")) {
                    tv.setTextColor(Color.parseColor("#FF5A1E1E"))
                    lL.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
                }
            }
        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b =  findViewById(R.id.b)
        et = findViewById(R.id.et)
        tv = findViewById(R.id.tv)
        lL = findViewById(R.id.lL)

        et.addTextChangedListener(textWatcher)
        tv.addTextChangedListener(textWatcher)
        b.setOnClickListener {
            et.text.clear()
        }

        et.onFocusChangeListener = focusListener
        tv.onFocusChangeListener = focusListener
        b.onFocusChangeListener = focusListener
    }
}