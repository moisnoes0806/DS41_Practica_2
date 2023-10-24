package com.moises.convertidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var temperatura: String =  ""
    private var selectedOption : Int = 0
    private var conversion : Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = findViewById<TextView>(R.id.textViewResult)
        val option = findViewById<Spinner>(R.id.spinner)
        val temp = findViewById<EditText>(R.id.editTextCelsius)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            temperatura = temp.text.toString()
            result.setText("La conversion es: "+ conversion(selectedOption).toString())
            conversion(selectedOption)
        }

        if (option != null){

            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.convert_options)
            )
            option.adapter = adapter

            option.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    selectedOption = position
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }

    }

    private fun conversion(option: Int): Double {
        when (option ){
            0->{
                val grados = Integer.parseInt(temperatura)
                conversion = grados * 1.8 + 32
            }
            1->{
                val grados = Integer.parseInt(temperatura)
                conversion =  grados + 273.0
            }
            2->{
                val grados = Integer.parseInt(temperatura)
                conversion = (grados - 32.0) / (5/9)
            }
            3->{
                val grados = Integer.parseInt(temperatura)
                conversion = ((grados - 32)) / (1.8) + 273.0
            }
            4->{
                val grados = Integer.parseInt(temperatura)
                conversion = grados -273.0
            }
            5->{
                val grados = Integer.parseInt(temperatura)
                conversion = (grados - 273.0) *1.8 +32.0
            }
        }
        return conversion.toDouble()
    }
}