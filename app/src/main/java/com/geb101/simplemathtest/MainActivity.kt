package com.geb101.simplemathtest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var number1 = randNumber()
    private var number2 = randNumber()
    private lateinit var textViewExample: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            number1 = it.getInt("number1")
            number2 = it.getInt("number2")
        }

        textViewExample = findViewById(R.id.example)
        val editText = findViewById<TextView>(R.id.editTextNumbers)
        val button = findViewById<Button>(R.id.buttonAnswer)
        val correct = findViewById<TextView>(R.id.correctAnswer)
        val incorrect = findViewById<TextView>(R.id.incorrectAnswer)

        setExample()

        button.setOnClickListener {
            val number = editText.text.toString()
            val answer = number1 + number2
                if (number == answer.toString()) {
                    number1 = randNumber()
                    number2 = randNumber()
                    setExample()
                    correct.visibility = View.VISIBLE
                    incorrect.visibility = View.GONE
                } else {
                    correct.visibility = View.GONE
                    incorrect.visibility = View.VISIBLE
                }
        }
    }
    private fun randNumber(): Int {
        return (0..100).random()
    }
    private fun setExample() {
        textViewExample.text = "$number1 + $number2 = ?"
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("number1", number1)
        outState.putInt("number2", number2)
    }
}