package com.example.hilt_demo.viewmodel.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hilt_demo.data.model.album.Album
import com.example.hilt_demo.data.repository.album.AlbumRepository
import com.example.hilt_demo.data.repository.album.AlbumRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var albumRepository: AlbumRepository

//    var getAlbumsLiveData : LiveData<List<Album>>?=null

//    fun getAlbums() {
//       getAlbumsLiveData = albumRepository.getAlbums()
//    }

    fun getAlbums() = albumRepository.getAlbums()
}