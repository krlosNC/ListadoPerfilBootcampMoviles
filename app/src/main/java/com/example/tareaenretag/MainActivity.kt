package com.example.tareaenretag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        respuesta()
    }

    private fun respuesta(){
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.192.57:8057/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var servicios : Servi= retrofit.create(Servi::class.java)
        servicios.getUser().enqueue(object : Callback<Data> {
            override fun onResponse(
                call : Call<Data>,
                response: Response<Data>
            ){
                Log.e( "onResponse: ", response.message() )
                Log.e( "onResponse: ", response.code().toString() )
                Log.e( "onResponse: ", response.body().toString() )

            }

            override  fun onFailure(Call : Call<Data>, t: Throwable){
                Log.e( "onFailure: ", t.toString())
            }

        }
        )
    }
}