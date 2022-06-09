@file:OptIn(DelicateCoroutinesApi::class)

package com.binar.myphoto.di

import com.binar.myphoto.presentation.screen.detail.DetailViewModel
import com.binar.myphoto.presentation.screen.favorite.FavoriteViewModel
import com.binar.myphoto.presentation.screen.home.HomeViewModel
import com.binar.myphoto.presentation.screen.search.SearchViewModel
import com.binar.myphoto.data.local.Favorite.FavoriteRepository
import com.binar.myphoto.data.remote.model.getallphotos.datasource.PhotoRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import org.koin.dsl.module

val repositoryModule = module {
    single {
        PhotoRepository(get())
    }
    single {
        FavoriteRepository(get())
    }
}

val viewModelModule = module {
    single {
        HomeViewModel(get())
    }
    single {
        DetailViewModel(get(),get())
    }
    single {
        SearchViewModel(get())
    }
    single {
        FavoriteViewModel(get())
    }
}