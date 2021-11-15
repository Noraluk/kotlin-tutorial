package com.example.a03_hilt.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    companion object {
        const val GSON = "GSON"
        const val HTTP_CLIENT =  "HTTP_CLIENT"
        const val RETROFIT = "RETROFIT"
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @Singleton
    @Provides
    @Named(GSON)
    fun provideGson() : Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Singleton
    @Provides
    @Named(HTTP_CLIENT)
    fun provideHttpClient() : OkHttpClient {
        return  OkHttpClient.Builder()
            .readTimeout(100, TimeUnit.SECONDS)
            .connectTimeout(100, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    @Named(RETROFIT)
    fun provideRetrofit(
        @Named(HTTP_CLIENT) okHttpClient: OkHttpClient,
        @Named(GSON) gson: Gson,
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}