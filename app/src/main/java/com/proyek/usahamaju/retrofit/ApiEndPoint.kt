package com.proyek.usahamaju.retrofit

import com.proyek.usahamaju.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("photos")
    fun getPhotos():Call<List<MainModel>>
}