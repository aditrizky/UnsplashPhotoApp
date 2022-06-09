package com.binar.myphoto.service

import com.binar.myphoto.data.remote.model.getallphotos.ImageResponse
import com.binar.myphoto.data.remote.model.getallphotos.ImageResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/photos/?client_id=wziJhPi_f-F1uwsDgqUsSMcF9sjSrG7uFBKDS35jcqU")
    suspend fun searchPhoto(
        @Query("query") query: String
    ): Response<ImageResponse>

    @GET("photos/?client_id=wziJhPi_f-F1uwsDgqUsSMcF9sjSrG7uFBKDS35jcqU&per_page=25")
    suspend fun getAllPhoto(): Response<List<ImageResponseItem>>

    @GET("photos/{id}/?client_id=wziJhPi_f-F1uwsDgqUsSMcF9sjSrG7uFBKDS35jcqU")
    suspend fun getDetail(
        @Path("id") id : String
    ): Response<ImageResponseItem>
}