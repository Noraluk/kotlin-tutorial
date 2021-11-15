package com.example.a03_hilt.viewmodel.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a03_hilt.data.model.album.Album
import com.example.a03_hilt.data.repository.album.AlbumRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var albumRepository: AlbumRepositoryImpl

    var getAlbumsLiveData : LiveData<List<Album>>?=null

//    fun getAlbums() {
//       getAlbumsLiveData = albumRepository.getAlbums()
//    }

    fun getAlbums() = albumRepository.getAlbums()
}