package com.example.projet_collectif_mobile.network

import com.example.projet_collectif_mobile.models.ClassJson
import com.example.projet_collectif_mobile.models.SurfSpot
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL ="http://10.0.2.2:8080"

private val retrofit = Retrofit.Builder()
    //.addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface SpotsApiService {
    @GET("simplespots")
    suspend fun getSpots(): List<SurfSpot>
}

object SpotsApi {
    val retrofitService : SpotsApiService by lazy {
        retrofit.create(SpotsApiService::class.java)
    }
}