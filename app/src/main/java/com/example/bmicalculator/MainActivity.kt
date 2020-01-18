package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            calculateBMI()
        }
    }

    private fun calculateBMI(){
        val weight : Float= editTextWeight.text.toString().toFloat()
        val height : Float= editTextHeight.text.toString().toFloat()

        val bmi = weight/ height.pow(2)

        val under = "Under Weight"
        val normal = "Normal Weight"
        val over = "Over Weight"

        if(editTextHeight.text.isEmpty()){
            editTextHeight.setError(getString(R.string.error_input))
            return
        }

        if(editTextHeight.text.isBlank()){
            editTextWeight.setError(getString(R.string.error_input))
            return
        }

        if(bmi < 18.5){
            imageViewProfilePicture.setImageResource(R.drawable.under)

            textViewStatus.text = getString(R.string.status) + ": ${under}"
            //textViewStatus.text = String.format("%s %.2f", getString(R.string.underWeight),)
        }else if((bmi >= 18.5)&&(bmi <= 24.9)){
            imageViewProfilePicture.setImageResource(R.drawable.normal)
            textViewStatus.text = getString(R.string.status) + ": ${normal}"
        }else
        {
            imageViewProfilePicture.setImageResource(R.drawable.over)
            textViewStatus.text = getString(R.string.status) + ": ${over}"
        }

        textViewBMI.text = String.format("%s %.2f", getString(R.string.bmi),bmi)
       // textViewStatus.text = getString(R.string.status) +
    }

    fun resetOutput(view : View){
        editTextHeight.text.clear()
        editTextWeight.text.clear()

        textViewStatus.text = getString(R.string.status)
        textViewBMI.text = getString(R.string.bmi)
        imageViewProfilePicture.setImageResource(R.drawable.empty)
    }

}
