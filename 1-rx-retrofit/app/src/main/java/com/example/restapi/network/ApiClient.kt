package com.example.restapi.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class ApiClient {
    companion object {
        private  var retrofit:Retrofit?=null

        fun getApiClient(): Retrofit {
            val gson = GsonBuilder()
                    .setLenient()
                    .create()
            val okHttpClient = OkHttpClient.Builder()
                    .readTimeout(100, TimeUnit.SECONDS)
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .build()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .build()
            }

            return retrofit!!
        }
    }
}