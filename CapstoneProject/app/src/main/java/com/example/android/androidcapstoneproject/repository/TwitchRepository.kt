package com.example.android.androidcapstoneproject.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.androidcapstoneproject.Constants
import com.example.android.androidcapstoneproject.Users
import com.example.android.androidcapstoneproject.network.AuthApi
import com.example.android.androidcapstoneproject.network.TwitchApi
import com.example.android.androidcapstoneproject.network.TwitchApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TwitchRepository {

    private val _user = MutableLiveData<Users>()
    val user: LiveData<Users>
        get()= _user

    suspend fun getUsers(){
        withContext(Dispatchers.IO){
            _user.postValue(TwitchApi.retrofitService.getUsers())
            //Log.i("repository",tokenId.toString())
            Log.i("repository", _user.value.toString())
        }
    }
}