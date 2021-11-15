package com.example.hilt_demo.data.repository.album

import androidx.lifecycle.LiveData
import com.example.hilt_demo.data.model.album.Album

interface AlbumRepository {
    fun getAlbums() : LiveData<List<Album>>
}