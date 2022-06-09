package com.binar.myphoto.data.local.Favorite

class FavoriteRepository constructor(private val favoriteLocalDataSource: FavoriteLocalDataSource) {
    fun addFavorite (addCallBack: FavoriteLocalDataSource.AddCallBack,photoFavorite: PhotoFavorite):Long{
        return favoriteLocalDataSource.addFavorite(addCallBack,photoFavorite)
    }

    fun getFavorite(favoriteCallBack: FavoriteLocalDataSource.FavoriteCallBack):List<PhotoFavorite>{
        return favoriteLocalDataSource.getAllFavorite(favoriteCallBack)
    }
}