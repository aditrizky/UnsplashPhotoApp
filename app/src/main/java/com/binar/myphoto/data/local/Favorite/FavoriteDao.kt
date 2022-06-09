package com.binar.myphoto.data.local.Favorite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface FavoriteDao {
    @Insert
    suspend fun addFavorite(photoFavorite: PhotoFavorite):Long

    @Delete
    suspend fun deleteFavorite(photoFavorite: PhotoFavorite):Int

    @Query("SELECT * FROM PhotoFavorite ORDER BY pId DESC")
    suspend fun getAllFavorite(): List<PhotoFavorite>

}