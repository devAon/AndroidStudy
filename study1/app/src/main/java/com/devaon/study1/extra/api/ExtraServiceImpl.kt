package com.devaon.study1.extra.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ExtraServiceImpl {
    private const val BASE_URL = "http://106.10.59.71:3000/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : ExtraService = retrofit.create(ExtraService::class.java)
}