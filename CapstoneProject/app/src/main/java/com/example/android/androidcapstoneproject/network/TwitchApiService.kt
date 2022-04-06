package com.example.android.androidcapstoneproject.network

import com.example.android.androidcapstoneproject.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Constants.BASE_URL)
    .build()

interface TwitchApiService {

}

object AsteroidApi{
    val retrofitService: TwitchApiService by lazy {
        retrofit.create(TwitchApiService::class.java)
    }
}