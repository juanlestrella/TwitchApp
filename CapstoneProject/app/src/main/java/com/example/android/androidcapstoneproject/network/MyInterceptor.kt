package com.example.android.androidcapstoneproject.network

import com.example.android.androidcapstoneproject.Constants
import com.example.android.androidcapstoneproject.profile.ProfileFragment
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
                .newBuilder()

        ProfileFragment().fetchToken()?.let{
            request.addHeader("Authorization", "Bearer $it")
            .addHeader("Client-Id", Constants.CLIENT_ID)
        }

        return chain.proceed(request.build())
    }

}