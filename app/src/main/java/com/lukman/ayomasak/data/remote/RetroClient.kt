package com.lukman.ayomasak.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClient {

    private const val BASE_URL = "https://masak-apa.tomorisakura.vercel.app/api/"

    val getInstance: Api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}