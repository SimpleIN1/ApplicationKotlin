package com.example.applicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private fun setText(value: Int, text: TextView){
        text.text = value.toString();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView> (R.id.textView2)
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber);
        var value = 0;

        findViewById<Button>(R.id.button3).setOnClickListener {
            val chislo = editTextNumber.text.toString();

            if(chislo != ""){
                value+= chislo.toInt();
                setText(value, text)
            }

        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            val chislo = editTextNumber.text.toString();
            if(chislo != ""){
                val chval = chislo.toInt();
                if(value-chval  >= 0){
                    value-= chval;
                    setText(value, text)
                }
            }
        }



    }
}

