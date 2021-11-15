package com.example.hilt_demo.di

import com.example.hilt_demo.data.repository.album.AlbumRepository
import com.example.hilt_demo.data.repository.album.AlbumRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AlbumModule {

    @Binds
    abstract fun bindAlbumRepository(
        albumRepositoryImpl: AlbumRepositoryImpl
    ) : AlbumRepository
}