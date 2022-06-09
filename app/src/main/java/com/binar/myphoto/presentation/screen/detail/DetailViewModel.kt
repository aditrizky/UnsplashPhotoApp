package com.binar.myphoto.presentation.screen.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.myphoto.data.local.Favorite.FavoriteLocalDataSource
import com.binar.myphoto.data.local.Favorite.FavoriteRepository
import com.binar.myphoto.data.local.Favorite.PhotoFavorite
import com.binar.myphoto.data.remote.model.getallphotos.ImageResponseItem
import com.binar.myphoto.data.remote.model.getallphotos.datasource.PhotoRemoteDataSource
import com.binar.myphoto.data.remote.model.getallphotos.datasource.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DetailViewModel(private val repository: PhotoRepository,private val favoriteRepository: FavoriteRepository) : ViewModel() {

    private val detailPhoto: MutableLiveData<ImageResponseItem> by lazy { MutableLiveData<ImageResponseItem>() }


    fun detailPhoto(): LiveData<ImageResponseItem> {
        return detailPhoto
    }


    fun getDetail(id: String) {
        repository.getDetail(object : PhotoRemoteDataSource.DetailCallback {
            override fun onComplete(responseItem: ImageResponseItem) {
                detailPhoto.value = responseItem
            }
        }, id)
    }

    fun addFavorite(photoFavorite: PhotoFavorite){
        favoriteRepository.addFavorite(object : FavoriteLocalDataSource.AddCallBack{
            override fun onComplete(result: Long) {
                Log.d("Dvm", result.toString())
            }
        },photoFavorite)
    }
}