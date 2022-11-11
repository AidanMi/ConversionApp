package com.example.conversionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.databinding.DataBindingUtil
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var radButton1: RadioButton
    lateinit var radButton2: RadioButton
    lateinit var radButton3: RadioButton
    lateinit var input:EditText
    lateinit var convertButton:Button
    lateinit var output: TextView

    //setOnCheckedChangeListener
    lateinit var radioGroup: RadioGroup
    lateinit var radioButton0: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sendError = "ERROR"

        radButton1 = findViewById(R.id.radioButton1)
        radButton2 = findViewById(R.id.radioButton2)
        input = findViewById(R.id.numInput)
        convertButton = findViewById(R.id.convertButton)
        output = findViewById(R.id.numOutput)

        radioGroup = findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            radioButton0 = findViewById(checkedId)
            if(checkedId == R.id.radioButton1){
                Toast.makeText(applicationContext,"You selected: ${radioButton0.text}", Toast.LENGTH_SHORT).show()
            }
            if(checkedId == R.id.radioButton2){
                Toast.makeText(applicationContext,"You selected: ${radioButton0.text}", Toast.LENGTH_SHORT).show()
            }
        }

        convertButton.setOnClickListener {
            val hundredth = DecimalFormat("##,####.00")
            val num = input.text.toString().toDouble()
            val conversionRate = 1.03

            var convertedNum = 0.0

            if(radButton1.isChecked){
                if(num<=10000){
                    convertedNum = num*conversionRate
                    output.text = "€${hundredth.format(convertedNum)}"
                }
                else{
                    Toast.makeText(this@MainActivity, "Dollars must be less than 10000", Toast.LENGTH_SHORT).show()
                    output.text = sendError
                }
            }
            else if(radButton2.isChecked){
                if(num<=10300){
                    convertedNum = num/conversionRate
                    output.text = "$${hundredth.format(convertedNum)}"

                }
                else{
                    Toast.makeText(this@MainActivity, "Euros must be less than 10300", Toast.LENGTH_SHORT).show()
                    output.text = sendError
                }
            }
            else{
                output.text = sendError
            }
        }
    }
}