package com.binar.myphoto.presentation.screen.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.myphoto.data.remote.model.getallphotos.ImageResponseItem
import com.binar.myphoto.data.remote.model.getallphotos.datasource.PhotoRemoteDataSource
import com.binar.myphoto.data.remote.model.getallphotos.datasource.PhotoRepository

class SearchViewModel(private val repository: PhotoRepository): ViewModel() {
    private val searchResult : MutableLiveData<List<ImageResponseItem>> by lazy { MutableLiveData<List<ImageResponseItem>>() }

    fun searchResult(): LiveData<List<ImageResponseItem>>{
        return searchResult
    }

    fun getSearch(query:String){
        repository.getSearch(object : PhotoRemoteDataSource.SearchResultCallBack{
            override fun onComplete(result: List<ImageResponseItem>) {
                searchResult.value=result
            }
        },query)
    }

}