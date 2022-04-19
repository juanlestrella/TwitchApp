package com.example.android.androidcapstoneproject.profile

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import com.example.android.androidcapstoneproject.Constants
import com.example.android.androidcapstoneproject.Users
import com.example.android.androidcapstoneproject.repository.TwitchRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class ProfileViewModel(private val repository: TwitchRepository) : ViewModel() {

    var users: MutableLiveData<Users> = MutableLiveData()

    fun getUsers(){
        viewModelScope.launch {
            repository.getUsers()
            users.value = repository.user.value
        }
    }






    class Factory(private val repository: TwitchRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ProfileViewModel(repository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

}

