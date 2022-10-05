package com.example.applicationkotlin

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


enum class Signs(val sign:String){
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
}

class MainActivity : AppCompatActivity() {

    private fun setText(value: Int, text: TextView){
        text.text = value.toString();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner2);


        val list_potions = ArrayList<String>();

        Signs.values().forEach {
            list_potions.add(it.sign)
        }

        val adapter =  ArrayAdapter(this, android.R.layout.simple_spinner_item,list_potions);

        spinner.adapter = adapter;


        val value = findViewById<EditText>(R.id.editTextNumber3);
        val value1 = findViewById<EditText>(R.id.editTextNumber4);

        var sum = 0;

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // ничего не выбрали
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                println(spinner.selectedItem);
                when(spinner.selectedItem){
                    Signs.PLUS.sign -> println(1)
                    Signs.MINUS.sign -> println(2)
                    Signs.DIVIDE.sign -> println(3)
                    Signs.MULTIPLY.sign -> println(4)
                }
            }
        }


    }
}

