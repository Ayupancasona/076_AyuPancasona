package com.example.masjid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_1.*
import kotlinx.android.synthetic.main.activity_1.txt1
import kotlinx.android.synthetic.main.activity_1.txt2
import org.json.JSONArray
import org.json.JSONObject

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        getdariserver()

        val context = this

        btnSimpann.setOnClickListener {
            var data_shubuh = editText.text.toString()
            var data_dhuhur = editText2.text.toString()
            var data_ashar = editText3.text.toString()
            var data_maghrib = editText4.text.toString()
            var data_isha = editText5.text.toString()
            var data_dhuha = editText6.text.toString()

            postkeserver(data_shubuh, data_dhuhur, data_ashar, data_maghrib, data_isha, data_dhuha)

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }


    }

    fun getdariserver(){
        AndroidNetworking.get("https://projectmenumasjid.000webhostapp.com/masjid/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for(i in 0 until jsonArray.length()){
                        val jsonObject =jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("shubuh"))

                        txt1.setText(jsonObject.optString("shubuh"))
                    }

                    val jsonArray1 = response.getJSONArray("result")
                    for(i in 0 until jsonArray1.length()){
                        val jsonObject =jsonArray1.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("dhuhur"))

                        txt2.setText(jsonObject.optString("dhuhur"))
                    }

                    val jsonArray2 = response.getJSONArray("result")
                    for(i in 0 until jsonArray2.length()){
                        val jsonObject =jsonArray2.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("ashar"))

                        txt3.setText(jsonObject.optString("ashar"))
                    }

                    val jsonArray3 = response.getJSONArray("result")
                    for(i in 0 until jsonArray3.length()){
                        val jsonObject =jsonArray3.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("maghrib"))

                        txt4.setText(jsonObject.optString("maghrib"))
                    }

                    val jsonArray4 = response.getJSONArray("result")
                    for(i in 0 until jsonArray4.length()){
                        val jsonObject =jsonArray4.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("isha"))

                        txt5.setText(jsonObject.optString("isha"))
                    }

                    val jsonArray5 = response.getJSONArray("result")
                    for(i in 0 until jsonArray5.length()){
                        val jsonObject =jsonArray5.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("dhuha"))

                        txt6.setText(jsonObject.optString("dhuha"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err",anError.toString())
                }
            })
    }
    fun postkeserver(data1:String, data2:String, data3:String, data4:String, data5:String, data6:String)
    {
        AndroidNetworking.post("https://projectmenumasjid.000webhostapp.com/masjid/proses-jadwal_sholat.php")
            .addBodyParameter("shubuh", data1)
            .addBodyParameter("dhuhur", data2)
            .addBodyParameter("ashar", data3)
            .addBodyParameter("maghrib", data4)
            .addBodyParameter("isha", data5)
            .addBodyParameter("dhuha", data6)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }
                override fun onError(error:ANError){
                }
            })
    }

}
