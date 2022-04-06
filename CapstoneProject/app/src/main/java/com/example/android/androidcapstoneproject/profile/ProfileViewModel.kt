package com.example.android.androidcapstoneproject.profile

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import com.example.android.androidcapstoneproject.Constants
import com.example.android.androidcapstoneproject.repository.TwitchRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class ProfileViewModel() : ViewModel() {

    fun twitchAuth(){
        //startActivity(intent)
//        viewModelScope.launch {
//            try {
//                val result = repository.token.toString()
//                Log.i("ProfileViewModel", result)
//            } catch (e: Exception){
//                Log.e("ProfileViewModel", "twitch authorization")
//            }
//        }
        // rather than calling an apiservice, i need to launch an intent that will open
        // a browser for the user to give this app an auth
        // also i need to figure out what the redirected_uri is if local host doesnt work
    }

}