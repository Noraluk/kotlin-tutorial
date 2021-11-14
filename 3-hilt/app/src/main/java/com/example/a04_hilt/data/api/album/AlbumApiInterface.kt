package com.example.a04_hilt.data.api.album

import com.example.a04_hilt.data.model.album.Album
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET

interface AlbumApiInterface {

    @GET("albums")
    fun getAlbums(): Observable<List<Album>>
}