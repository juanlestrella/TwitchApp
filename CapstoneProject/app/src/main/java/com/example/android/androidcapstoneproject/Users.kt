package com.example.android.androidcapstoneproject

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "users")
data class Users(
    @PrimaryKey val id: String,
    val login: String,
    val displayName: String,
    val type: String,
    val broadcasterType: String,
    val description: String,
    val profileImageUrl: String,
    val offlineImageUrl: String,
    val viewCount: Integer,
    val email: String,
    val createAt: String
) : Parcelable
