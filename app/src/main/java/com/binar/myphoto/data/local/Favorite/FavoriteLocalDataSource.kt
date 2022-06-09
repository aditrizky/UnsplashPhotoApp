package com.binar.myphoto.data.local.Favorite

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FavoriteLocalDataSource(private val favoriteDao: FavoriteDao) {

    fun addFavorite(addCallBack: AddCallBack,photoFavorite: PhotoFavorite):Long{
        GlobalScope.launch(Dispatchers.IO) {
            val result = favoriteDao.addFavorite(photoFavorite)
            runBlocking(Dispatchers.Main) {
                addCallBack.onComplete(result)
            }
        }

        return 0
    }

     fun getAllFavorite(favoriteCallBack: FavoriteCallBack):List<PhotoFavorite>{
        GlobalScope.launch(Dispatchers.IO) {
            val result = favoriteDao.getAllFavorite()
            runBlocking(Dispatchers.Main) {
               favoriteCallBack.onComplete(result)
            }
        }
        return emptyList()
    }


    interface AddCallBack{
        fun onComplete(result: Long)
    }

    interface FavoriteCallBack{
        fun onComplete(result: List<PhotoFavorite>)
    }
}
