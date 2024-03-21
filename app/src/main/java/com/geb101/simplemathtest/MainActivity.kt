package com.geb101.simplemathtest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val editText = findViewById<TextView>(R.id.editTextNumbers)
        val button = findViewById<Button>(R.id.buttonAnswer)
        val correct = findViewById<TextView>(R.id.correctAnswer)
        val incorrect = findViewById<TextView>(R.id.incorrectAnswer)
        button.setOnClickListener {
            val number = editText.text.toString()
            if (number.equals("15")) {
                correct.visibility = View.VISIBLE
                incorrect.visibility = View.GONE
            } else {
                correct.visibility = View.GONE
                incorrect.visibility = View.VISIBLE
            }
        }
    }
}