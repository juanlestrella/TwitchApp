package com.example.android.androidcapstoneproject.network

import com.example.android.androidcapstoneproject.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Constants.AUTH_URL)
    .build()

interface AuthApiService {
    @GET("oauth2/authorize")
    suspend fun getAuth(
        @Query("client_id") clientID : String, // Constants.ClIENT_ID
        @Query("redirect_uri") redirectUri : String, // Constants.LOCAL_URL
        @Query("response_type") responseType : String, // token
        @Query("scope") scope : String // Space-separated list of scopes.
    )
}

object AuthApi {
    val authService : AuthApiService by lazy {
        retrofit.create(AuthApiService::class.java)
    }
}