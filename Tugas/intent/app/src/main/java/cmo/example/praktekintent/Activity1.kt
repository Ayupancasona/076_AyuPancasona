package com.example.praktekintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_1.*
import kotlinx.android.synthetic.main.activity_1.txtIntentUtama
import kotlinx.android.synthetic.main.activity_main.*

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val intentObject:Intent=intent
        val name= intentObject.getStringExtra("name")
        txtIntentUtama.text = "Hey $name"

        val context=this
        BtnIntentUtama1.setOnClickListener {
            val intent= Intent(context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
