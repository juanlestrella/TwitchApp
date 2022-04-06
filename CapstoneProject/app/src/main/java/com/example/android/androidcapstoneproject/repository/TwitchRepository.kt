package com.example.android.androidcapstoneproject.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.androidcapstoneproject.Constants
import com.example.android.androidcapstoneproject.network.AuthApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TwitchRepository {

    private val scope: String = "user:edit"

    private val _token = MutableLiveData<Unit>()
    val token: LiveData<Unit>
        get()= _token

    // Ask the user to allow twitch authorization
    suspend fun auth(){
        return withContext(Dispatchers.IO){
            _token.postValue(AuthApi.authService.getAuth(
                Constants.CLIENT_ID,
                Constants.LOCAL_URL,
                "token",
                scope
            ))
        }
    }
}