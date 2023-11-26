package com.proyek.usahamaju.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServices {
    val BASE_URL : String = "https://jsonplaceholder.typicode.com/"
    val endPoint: ApiEndPoint
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiEndPoint::class.java)
        }
}