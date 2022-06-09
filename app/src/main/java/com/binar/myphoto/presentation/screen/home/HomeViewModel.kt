package com.binar.myphoto.presentation.screen.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.myphoto.data.remote.model.getallphotos.ImageResponseItem
import com.binar.myphoto.data.remote.model.getallphotos.datasource.PhotoRemoteDataSource
import com.binar.myphoto.data.remote.model.getallphotos.datasource.PhotoRepository
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class HomeViewModel(private val repository:PhotoRepository): ViewModel() {

    private val photo : MutableLiveData<List<ImageResponseItem>> by lazy { MutableLiveData<List<ImageResponseItem>>().also {
        loadPhoto()
    }}

    fun listPhoto(): LiveData<List<ImageResponseItem>>{
        return photo
    }



   private fun loadPhoto(){
        repository.getPhotos(object : PhotoRemoteDataSource.PhotoCallBack{
            override fun onComplete(result: List<ImageResponseItem>) {
               photo.value=result
                Log.d("vm",photo.toString())
            }

        })

    }
}