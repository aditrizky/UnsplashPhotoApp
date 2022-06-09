package com.binar.myphoto.presentation.screen.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.myphoto.data.local.Favorite.FavoriteLocalDataSource
import com.binar.myphoto.data.local.Favorite.FavoriteRepository
import com.binar.myphoto.data.local.Favorite.PhotoFavorite


class FavoriteViewModel(private val repository: FavoriteRepository): ViewModel() {

    private val photo : MutableLiveData<List<PhotoFavorite>> by lazy {
        MutableLiveData<List<PhotoFavorite>>()
    }

    fun getFavorite(): LiveData<List<PhotoFavorite>> {
        return photo
    }


    fun getAllFavorite(){
     repository.getFavorite(object : FavoriteLocalDataSource.FavoriteCallBack{
         override fun onComplete(result: List<PhotoFavorite>) {
             photo.value= result
         }

     })

    }

}