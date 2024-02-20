package com.example.apis.util

import com.example.apis.model.MyProductData
import com.example.apis.model.Product
import com.example.apis.model.Profile
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("api/profile")
    fun getPorfile(): Call<Profile>

    @POST("api/profile")
    fun postProfile(@Body profile: Profile): Call<String>

}