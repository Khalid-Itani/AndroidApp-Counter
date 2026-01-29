package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterText = findViewById<TextView>(R.id.textView)
        val mainButton = findViewById<Button>(R.id.button)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)

        mainButton.setOnClickListener {
            counter++
            counterText.text = counter.toString()

            if (counter >= 100) {
                upgradeButton.visibility = View.VISIBLE
            }
        }

        upgradeButton.setOnClickListener {
            // After upgrade, each tap adds 2
            mainButton.setOnClickListener {
                counter += 2
                counterText.text = counter.toString()
            }

            upgradeButton.visibility = View.INVISIBLE
        }
    }
}
