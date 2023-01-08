package edu.iliana.ageinseconds

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var btnSelectDate: Button
    private lateinit var txtDateSelected: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSelectDate = findViewById(R.id.btnSelectDate)
        btnSelectDate.setOnClickListener{
            clickSelectDate()
        }

        txtDateSelected = findViewById(R.id.txtDateSelected)
    }

    private fun clickSelectDate() {
        // create a calendar object
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        // create an object for the date picker dialog
        val datePickerDialog = DatePickerDialog(this, {
            // define event handler for datePickerDialog
            _, pickedYear, pickedMonth, pickedDay ->
            val dateSelected = "${pickedMonth + 1}/" +
                    "$pickedDay/$pickedYear"
            txtDateSelected.text = dateSelected
        },year, month, day).show()
    }

}