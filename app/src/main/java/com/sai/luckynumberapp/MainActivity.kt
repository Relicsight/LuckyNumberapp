package com.sai.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText:EditText = findViewById(R.id.editText)

        val b1 = findViewById<Button>(R.id.button)

        b1.setOnClickListener{

            val ed = editText.text

            val i = Intent(this,Luckynumber::class.java)
            i.putExtra("name",ed)
            startActivity(i)
        }
    }
}