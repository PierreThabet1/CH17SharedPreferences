package com.example.ch17sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    private fun saveData() {

        val filename = "$packageName TESTFILE"
        val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)
        val edit = pref.edit()

        edit.putString("lastname", txtlastname.text.toString())
        edit.putString("firstname", txtfirstname.text.toString())
        edit.apply()

        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()

        txtlastname.setText("")
        txtfirstname.setText("")
        txtfirstname.setHint("first name")
        txtlastname.setHint("last name")
    }


}