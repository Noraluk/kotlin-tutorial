package com.example.a04_hilt.data.repository.album

import androidx.lifecycle.LiveData
import com.example.a04_hilt.data.model.album.Album

interface AlbumRepository {
    fun getAlbums() : LiveData<List<Album>>
}