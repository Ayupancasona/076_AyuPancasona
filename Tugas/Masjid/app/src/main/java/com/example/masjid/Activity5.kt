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
import kotlinx.android.synthetic.main.activity_5.*
import org.json.JSONArray
import org.json.JSONObject

class Activity5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)

        getdariserver()

        val context = this

        btnSimpan5.setOnClickListener {
            var data_isitagline = edit_isi_tagline.text.toString()

            postkeserver(data_isitagline)

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun getdariserver(){
        AndroidNetworking.get("https://projectmenumasjid.000webhostapp.com/masjid/tagline_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())


                    val jsonArray1 = response.getJSONArray("result")
                    for(i in 0 until jsonArray1.length()){
                        val jsonObject =jsonArray1.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("isi_tagline"))

                        isi_tagline.setText(jsonObject.optString("isi_tagline"))
                    }


                }

                override fun onError(anError: ANError?) {
                    Log.i("_err",anError.toString())
                }
            })
    }
    fun postkeserver(data1:String)
    {
        AndroidNetworking.post("https://projectmenumasjid.000webhostapp.com/masjid/proses-tagline.php")
            .addBodyParameter("isi_tagline", data1)

            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }
                override fun onError(error: ANError){
                }
            })
    }
}
