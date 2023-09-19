package com.sai.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random as Random

class Luckynumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luckynumber)

        val b2 = findViewById<Button>(R.id.button2)

        val user_name:String = recieveusername()
        val random_number = luckynumbergenerator().toString()

        val ed:TextView = findViewById(R.id.textView3)
        ed.setText(random_number)

        b2.setOnClickListener{
            sharedata(user_name,random_number)

        }
    }
    fun recieveusername():String{

        val bundle:Bundle? = intent.extras
        val username = bundle?.get("name").toString()
        return username
    }


    fun luckynumbergenerator():Int{
        val a = Random.nextInt(999)
        return a
    }

    fun sharedata(username:String,randomnumber:String){
        val i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT,"$username is Lucky today")
        i.putExtra(Intent.EXTRA_TEXT,"Your Lucky number is $randomnumber")
        startActivity(i)
    }
}