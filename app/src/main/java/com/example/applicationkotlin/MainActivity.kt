package com.example.applicationkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged


enum class Signs(val sign:String){
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
}

class MainActivity : AppCompatActivity() {


    private fun get_valid_value (str: String): String {
        return if ( str == "") "0" else str
    }

    private fun execute_action(spinner: Spinner,first_value: Double, second_value: Double): Double{
        when(spinner.selectedItem){
            Signs.PLUS.sign -> {
                return first_value + second_value
            }
            Signs.MINUS.sign -> {
                return first_value - second_value
            }
            Signs.DIVIDE.sign -> {
                return first_value / second_value
            }
            Signs.MULTIPLY.sign -> {
                return first_value * second_value
            }
            else -> {
                return 0.0
            }
        }
    }

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner2);
        val list_potions = ArrayList<String>();

        Signs.values().forEach {
            list_potions.add(it.sign)
        }

        val adapter =  ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            list_potions
        );

        spinner.adapter = adapter;


        val first_value = findViewById<EditText>(R.id.editTextNumber4);
        val second_value = findViewById<EditText>(R.id.editTextNumber3);
        val textView = findViewById<TextView>(R.id.textView);


        first_value.doAfterTextChanged {
            textView.text = execute_action(
                spinner,
                get_valid_value(first_value.text.toString()).toDouble(),
                get_valid_value(second_value.text.toString()).toDouble()
            ).toString();
        }

        second_value.doAfterTextChanged {
            textView.text = execute_action(
                spinner,
                get_valid_value(first_value.text.toString()).toDouble(),
                get_valid_value(second_value.text.toString()).toDouble()
            ).toString();
        }


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                textView.text = execute_action(
                    spinner,
                    get_valid_value(first_value.text.toString()).toDouble(),
                    get_valid_value(second_value.text.toString()).toDouble()
                ).toString();
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}


