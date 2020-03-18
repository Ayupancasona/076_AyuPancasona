package com.example.kalkulatorb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jumlahkan.setOnClickListener(){
            var bilangan1:String=bil1.text.toString()
            var bilangan2:String=bil2.text.toString()
            var a:Int=bilangan1.toInt()
            var b:Int=bilangan2.toInt()

            tambah(a, b)

        }

        kali.setOnClickListener(){
            var bilangan1:String=bil1.text.toString()
            var bilangan2:String=bil2.text.toString()

            var a: Int=bilangan1.toInt()
            var b: Int=bilangan2.toInt()

            kalikan(a, b)

 }

        kurang.setOnClickListener(){
            var bilangan1:String=bil1.text.toString()
            var bilangan2:String=bil2.text.toString()

            var a: Int=bilangan1.toInt()
            var b: Int=bilangan2.toInt()

            kurangi(a, b)
//
//
        }
        bagi.setOnClickListener(){
            var bilangan1:String=bil1.text.toString()
            var bilangan2:String=bil2.text.toString()

            var a: Int=bilangan1.toInt()
            var b: Int=bilangan2.toInt()

            bagikan(a,b)
        }


    }

    fun tambah(a:Int, b:Int) {

        var c:Int=a+b

        hasil.setText(c.toString())

    }

    fun kalikan(a:Int, b:Int) {
    var c:Int=a*b

    hasil.setText(c.toString())
    }

    fun kurangi(a:Int, b:Int) {

        var c:Int=a-b

            hasil.setText(c.toString())

    }

    fun bagikan(a:Int, b:Int) {

        var c:Int=a/b

            hasil.setText(c.toString())
    }

}
