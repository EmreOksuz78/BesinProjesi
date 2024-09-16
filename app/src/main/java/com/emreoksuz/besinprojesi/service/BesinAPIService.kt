package com.emreoksuz.besinprojesi.service

import com.emreoksuz.besinprojesi.model.Besin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BesinAPIService {

    /*private val BASE_URL = "https://raw.githubusercontent.com/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BesinAPI::class.java)

    suspend fun getData(): List<Besin>{
        return api.getBesin()

    }

     */




    private val BASE_URL = "https://raw.githubusercontent.com/"
    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BesinAPI::class.java)


    suspend fun getData() : List<Besin>{
        return api.getBesin()
    }




}