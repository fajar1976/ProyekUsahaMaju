package com.proyek.usahamaju.retrofit

import retrofit2.http.GET

interface ApiEndPoint {
    @GET("photos")
    fun getPhotos()
}