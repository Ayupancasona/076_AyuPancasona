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
import kotlinx.android.synthetic.main.activity_1.txt2
import kotlinx.android.synthetic.main.activity_3.*
import org.json.JSONArray
import org.json.JSONObject

class Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        getdariserver()

        val context = this

        btnSimpan3.setOnClickListener {
            var data_isimarquee = isi_marquee.text.toString()

            postkeserver(data_isimarquee)

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun getdariserver(){
        AndroidNetworking.get("https://projectmenumasjid.000webhostapp.com/masjid/marquee_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for(i in 0 until jsonArray.length()){
                        val jsonObject =jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("ID"))

//                        txt1.setText(jsonObject.optString("id_marquee"))
                    }

                    val jsonArray1 = response.getJSONArray("result")
                    for(i in 0 until jsonArray1.length()){
                        val jsonObject =jsonArray1.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("isi_marquee"))

                        txt2.setText(jsonObject.optString("isi_marquee"))
                    }


                }

                override fun onError(anError: ANError?) {
                    Log.i("_err",anError.toString())
                }
            })
    }
    fun postkeserver(data1:String)
    {
        AndroidNetworking.post("https://projectmenumasjid.000webhostapp.com/masjid/proses-marquee.php")
            .addBodyParameter("isi_marquee", data1)
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
