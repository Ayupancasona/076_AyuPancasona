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
import kotlinx.android.synthetic.main.activity_1.txt3
import kotlinx.android.synthetic.main.activity_2.*
import org.json.JSONArray
import org.json.JSONObject

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        getdariserver()

        val context = this

        btnSimpan2.setOnClickListener {
            var data_namamasjid = nama_masjid.text.toString()
            var data_alamatmasjid = alamat.text.toString()

            postkeserver(data_namamasjid, data_alamatmasjid)

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun getdariserver(){
        AndroidNetworking.get("https://projectmenumasjid.000webhostapp.com/masjid/identitas_masjid_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

//                    val jsonArray = response.getJSONArray("result")
//                    for (i in 0 until jsonArray.length()) {
//                        val jsonObject = jsonArray.getJSONObject(i)
//                        Log.e("_kotlinTitle", jsonObject.optString("id_identitas"))
//
//                        txt1.setText(jsonObject.optString("id_identitas"))
//                    }

                    val jsonArray1 = response.getJSONArray("result")
                    for (i in 0 until jsonArray1.length()) {
                        val jsonObject = jsonArray1.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("nama_masjid"))

                        txt2.setText(jsonObject.optString("nama_masjid"))
                    }

                    val jsonArray2 = response.getJSONArray("result")
                    for (i in 0 until jsonArray2.length()) {
                        val jsonObject = jsonArray2.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("alamat_masjid"))

                        txt3.setText(jsonObject.optString("alamat_masjid"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err",anError.toString())
                }
            })
                    }

    fun postkeserver(data1:String, data2:String)
    {
        AndroidNetworking.post("https://projectmenumasjid.000webhostapp.com/masjid/proses-identitas.php")
            .addBodyParameter("nama_masjid", data1)
            .addBodyParameter("alamat_masjid", data2)
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
