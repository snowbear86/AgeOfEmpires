package com.example.ageofempires

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView_main.layoutManager = LinearLayoutManager(this)
//        recyclerView_main.adapter = MainAdapter()

        fetchJson()

    }

    fun fetchJson(){
        println("attempting to fetch JSON - Barry")


        val url = "https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onResponse(call: okhttp3.Call?, response: okhttp3.Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

//                val homeFeed = gson.fromJson(body, HomeFeed::class.java)
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)


                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(homeFeed)

                }

            }

            override fun onFailure(call: okhttp3.Call, e: IOException) {
                println("failed to execute")
            }


        })


//
    }
}

class HomeFeed(val civilizations: List<Civilization>)

class Civilization(val id: Int, val name: String, val army_type: String, val team_bonus: String)


//"civilizations": [
//{
//    "id": 1,
//    "name": "Aztecs",
//    "expansion": "The Conquerors",
//    "army_type": "Infantry and Monk",
//    "unique_unit": [
//    "https://age-of-empires-2-api.herokuapp.com/api/v1/unit/jaguar_warrior"
//    ],
//    "unique_tech": [
//    "https://age-of-empires-2-api.herokuapp.com/api/v1/technology/garland_wars"
//    ],
//    "team_bonus": "Relics generate +33% gold",
//    "civilization_bonus": [
//    "Villagers carry +5",
//    "Military units created 15% faster",
//    "+5 Monk hit points for each Monastery technology",
//    "Loom free"
//    ]
//},

