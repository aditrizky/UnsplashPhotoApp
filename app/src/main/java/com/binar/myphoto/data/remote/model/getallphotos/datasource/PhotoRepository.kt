package com.binar.myphoto.data.remote.model.getallphotos.datasource

import com.binar.myphoto.data.remote.model.getallphotos.ImageResponseItem
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class PhotoRepository constructor(private val photoRemoteDataSource: PhotoRemoteDataSource){
    fun getPhotos(photoCallBack: PhotoRemoteDataSource.PhotoCallBack):List<ImageResponseItem>{
        return photoRemoteDataSource.getPhoto(photoCallBack)
    }

   fun getDetail (detailCallback: PhotoRemoteDataSource.DetailCallback,id: String): ImageResponseItem{
        return photoRemoteDataSource.getDetailPhoto(detailCallback,id)
    }

    fun getSearch(searchResultCallBack: PhotoRemoteDataSource.SearchResultCallBack,query:String):List<ImageResponseItem>{
        return photoRemoteDataSource.getSearch(searchResultCallBack,query)
    }
}