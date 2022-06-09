package com.binar.myphoto.data.remote.model.getallphotos.datasource


import com.binar.myphoto.data.remote.model.getallphotos.ImageResponseItem
import com.binar.myphoto.service.ApiService
import kotlinx.coroutines.*

class PhotoRemoteDataSource(private val apiService: ApiService) {
    @DelicateCoroutinesApi
    fun getPhoto(photoCallBack: PhotoCallBack): List<ImageResponseItem> {
        GlobalScope.launch(Dispatchers.IO) {
            val response = apiService.getAllPhoto()
            runBlocking(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val result = response.body()
                    result.let {
                        if (it != null) {
                            photoCallBack.onComplete(it)
                        }
                    }
                }
            }
        }

        return emptyList()
    }

    fun getDetailPhoto(detailCallback: DetailCallback, id: String): ImageResponseItem {
        GlobalScope.launch(Dispatchers.IO) {
            val response = apiService.getDetail(id)
            runBlocking(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val result = response.body()
                    result.let {
                        if (it != null) {
                            detailCallback.onComplete(it)
                        }
                    }
                }
            }
        }
        return ImageResponseItem()
    }

    fun getSearch(
        searchResultCallBack: SearchResultCallBack,
        query: String
    ): List<ImageResponseItem> {
        GlobalScope.launch(Dispatchers.IO) {
            val response = apiService.searchPhoto(query)
            runBlocking(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val result = response.body()
                    result.let {
                        if (it != null) {
                            searchResultCallBack.onComplete(it.result)
                        }
                    }
                }
            }
        }

        return emptyList()
    }


    interface PhotoCallBack {
        fun onComplete(result: List<ImageResponseItem>)
    }

    interface DetailCallback {
        fun onComplete(responseItem: ImageResponseItem)
    }

    interface SearchResultCallBack {
        fun onComplete(result: List<ImageResponseItem>)
    }
}