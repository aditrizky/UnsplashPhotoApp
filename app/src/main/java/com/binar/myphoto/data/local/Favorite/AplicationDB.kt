package com.binar.myphoto.data.local.Favorite

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PhotoFavorite::class], version = 1,exportSchema = false)
abstract class AplicationDB:RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}