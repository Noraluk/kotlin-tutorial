package com.example.restapi.viewmodel.album

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.restapi.data.model.album.Album
import com.example.restapi.data.repository.album.AlbumRepository

class AlbumViewModel(application: Application): AndroidViewModel(application) {
    private var albumRepository: AlbumRepository?=null
    var getAlbumsLiveData : LiveData<List<Album>>?=null


    init {
        albumRepository = AlbumRepository()
        getAlbumsLiveData = MutableLiveData()
    }

    fun getAlbums(){
        getAlbumsLiveData = albumRepository?.getAlbums()
    }
}