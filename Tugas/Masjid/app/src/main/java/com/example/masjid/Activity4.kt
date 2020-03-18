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
//import kotlinx.android.synthetic.main.activity_3.txt1
import kotlinx.android.synthetic.main.activity_4.*
import org.json.JSONArray
import org.json.JSONObject

class Activity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        getdariserver()

        val context = this

        btnSimpan4.setOnClickListener {
            var data_judulpengumuman = edit_jdl_pengumuman.text.toString()
            var data_isipengumuman = edit_isi_pengumuman.text.toString()

            postkeserver( data_judulpengumuman, data_isipengumuman)

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun getdariserver(){
        AndroidNetworking.get("https://projectmenumasjid.000webhostapp.com/masjid/pengumuman_masjid_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for(i in 0 until jsonArray.length()){
                        val jsonObject =jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("judul_pengumuman"))

                        jdl_pengumuman.setText(jsonObject.optString("judul_pengumuman"))
                    }

                    val jsonArray1 = response.getJSONArray("result")
                    for(i in 0 until jsonArray1.length()){
                        val jsonObject =jsonArray1.getJSONObject(i)
                        Log.e("_kotlinTitle",jsonObject.optString("isi_pengumuman"))

                        isi_pengumuman.setText(jsonObject.optString("isi_pengumuman"))
                    }


                }

                override fun onError(anError: ANError?) {
                    Log.i("_err",anError.toString())
                }
            })
    }
    fun postkeserver(data1:String, data2:String)
    {
        AndroidNetworking.post("https://projectmenumasjid.000webhostapp.com/masjid/proses-pengumuman.php")
            .addBodyParameter("judul_pengumuman", data1)
            .addBodyParameter("isi_pengumuman", data2)
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
