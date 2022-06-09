package com.binar.myphoto.data.remote.model.getallphotos



import com.google.gson.annotations.SerializedName

data class ImageResponseItem (
    @SerializedName("id")
    val id: String?=null,
    @SerializedName("urls")
    val urls: Urls?=null,
    @SerializedName("created_at")
    val createdAt: String?=null,
    @SerializedName("description")
    val description: String?=null,
    @SerializedName("likes")
    val likes: Int?=null,
    )