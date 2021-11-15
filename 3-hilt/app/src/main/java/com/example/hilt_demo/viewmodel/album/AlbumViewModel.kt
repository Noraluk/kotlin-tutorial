package com.example.hilt_demo.viewmodel.album

import androidx.lifecycle.ViewModel
import com.example.hilt_demo.data.repository.album.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var albumRepository: AlbumRepository

    fun getAlbums() = albumRepository.getAlbums()
}