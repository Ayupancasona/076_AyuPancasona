package com.example.ayuminggu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*  var nilai = 70

        if(nilai >= 90 && nilai <= 100){
            Log.i("Hasil", "A")
            tampil.text ="A"
        }
        else if (nilai >=80&& nilai<=89){
            Log.i("Hasil","AB")
            tampil.text = "Nilai AB"
        }
         else if (nilai >=70 && nilai <=69){
            Log.i("Hasil", "B")
            tampil.text = "Nilai B"
        }
        else if (nilai >=60 && nilai <=69){
            Log.i("Hasil", "BC")
            tampil.text = "Nilai BC"
        }else {
            Log.i("Hasil", "C")
            tampil.text = "Nilai C"
        }

       */
//        for (x in 0..10)
//            Log.i("Hasil", "$x")
////        $x cara menampilkan variable

//        var i = 1
//
//        while (i <= 5) {
//            Log.i("Line", "$i")
//            ++i
//
//        }
//        fun main(args: Array<String>) {


//    var num = 2
//    var i = 1
//
//    do {
////             println("hasil : 2 * $i = "+ num * i)
//        Log.i("Hasil", "2 * $i = " + num * i)
//        i++
//
//    } while (i < 11)


//}
//        var a=7
//        var b =5
//        penjumlahan(a,b)

        var a=5
        var b=6
        var c=10
       hitung(a,b,c)

    }
    fun hitung (a:Int, b: Int, c:Int) {
        var d: Int
         d=(a*b-10)/c        
         Log.i("Hasil", "$d")
    }




//    fun penjumlahan (a:Int, b: Int){
//
//        var c: Int
//        c = a+b
//        Log.i("Hasil" , "$c")
//    }
}
//}
