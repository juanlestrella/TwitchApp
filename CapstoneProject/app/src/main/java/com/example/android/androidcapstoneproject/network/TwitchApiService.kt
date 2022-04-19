package com.example.android.androidcapstoneproject.network
import com.example.android.androidcapstoneproject.Constants
import com.example.android.androidcapstoneproject.Users
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
// https://medium.com/android-news/token-authorization-with-retrofit-android-oauth-2-0-747995c79720
// ^ how to add header and save token
// if more resources needed: google: API request Authorization header android kotlin

private val client = OkHttpClient.Builder().apply {
    addInterceptor(MyInterceptor())
}.build()

private val retrofit = Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface TwitchApiService {
    // https://dev.twitch.tv/docs/api/reference#get-users
    @GET("users")
    suspend fun getUsers(
        // need to work on this
//        @Header("Authorization") tokenId: String,
//        @Header("Client-Id") clientId: String
    ) : Users
}

object TwitchApi{
    val retrofitService: TwitchApiService by lazy {
        retrofit.create(TwitchApiService::class.java)
    }
}