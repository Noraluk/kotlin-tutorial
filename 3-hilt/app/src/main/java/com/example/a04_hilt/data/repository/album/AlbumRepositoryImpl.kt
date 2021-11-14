package com.example.a04_hilt.data.repository.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a04_hilt.data.api.album.AlbumApiInterface
import com.example.a04_hilt.data.model.album.Album
import com.example.a04_hilt.di.NetworkModule
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject
import javax.inject.Named


class AlbumRepositoryImpl @Inject constructor() : AlbumRepository {
    @Inject
    @Named(NetworkModule.RETROFIT)
    lateinit var retrofit: Retrofit

    override fun getAlbums(): LiveData<List<Album>> {
        val data = MutableLiveData<List<Album>>()

        retrofit.create(AlbumApiInterface::class.java)
            ?.getAlbums()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<List<Album>> {
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