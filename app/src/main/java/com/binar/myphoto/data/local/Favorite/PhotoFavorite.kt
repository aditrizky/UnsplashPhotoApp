package com.binar.myphoto.data.local.Favorite

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PhotoFavorite(
    @PrimaryKey(autoGenerate = true)
    val pId:Int=0,
    @SerializedName("id")
    val id: String?=null,
    @SerializedName("urls")
    val urls: String?=null,
    @SerializedName("created_at")
    val createdAt: String?=null,
    @SerializedName("description")
    val description: String?=null,
    @SerializedName("likes")
    val likes: Int?=null,
)
