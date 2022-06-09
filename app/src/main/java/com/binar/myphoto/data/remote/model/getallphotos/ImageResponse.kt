package com.binar.myphoto.data.remote.model.getallphotos

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("results")
    val result: List<ImageResponseItem>,
)
