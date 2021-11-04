package com.example.restapi.data.repository.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.restapi.data.api.album.AlbumApiInterface
import com.example.restapi.data.model.album.Album
import com.example.restapi.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumRepository {
    private var albumApiInterface: AlbumApiInterface?=null

    init {
        albumApiInterface = ApiClient.getApiClient().create(AlbumApiInterface::class.java)
    }

    fun getAlbums():LiveData<List<Album>> {
        val data = MutableLiveData<List<Album>>()

        albumApiInterface?.getAlbums()?.enqueue(object : Callback<List<Album>> {

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
               val resBody = response.body()
                if (response.isSuccessful) {
                    data.value = resBody
                }else {
                    data.value =null
                }
            }
        })

        return data
    }
}