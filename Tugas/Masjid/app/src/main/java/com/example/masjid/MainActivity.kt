package com.example.masjid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context=this
        jamsholat.setOnClickListener {
            val intent= Intent(context, Activity1::class.java)
            startActivity(intent)

        }
        identitas.setOnClickListener {
            val intent= Intent(context, Activity2::class.java)
            startActivity(intent)
        }
        marquee.setOnClickListener {
            val intent= Intent(context, Activity3::class.java)
            startActivity(intent)
        }
        pengumuman.setOnClickListener {
            val intent= Intent(context, Activity4::class.java)
            startActivity(intent)
        }
        tagline.setOnClickListener {
            val intent= Intent(context, Activity5::class.java)
            startActivity(intent)
        }
        slideshow.setOnClickListener {
            val intent= Intent(context, Activity6::class.java)
            startActivity(intent)
        }
    }
    

}
