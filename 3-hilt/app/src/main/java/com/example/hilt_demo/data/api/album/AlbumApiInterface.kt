package com.example.hilt_demo.data.api.album

import com.example.hilt_demo.data.model.album.Album
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface AlbumApiInterface {

    @GET("albums")
    fun getAlbums(): Observable<List<Album>>
}