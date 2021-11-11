package com.example.restapi.data.repository.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.restapi.data.api.album.AlbumApiInterface
import com.example.restapi.data.model.album.Album
import com.example.restapi.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class AlbumRepository {
    private var albumApiInterface: AlbumApiInterface?=null

    init {
        albumApiInterface = ApiClient.getApiClient().create(AlbumApiInterface::class.java)
    }

    fun getAlbums():LiveData<List<Album>> {
        val data = MutableLiveData<List<Album>>()

        albumApiInterface?.getAlbums()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<List<Album>>{
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: List<Album>) {
                    data.value = t
                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }
            })

        return data
    }
}