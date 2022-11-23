package com.example.tareaenretag

import retrofit2.Call
import retrofit2.http.GET

interface Servi {
    @GET("viewUser/1")
    fun getUser(): Call<Data>
}