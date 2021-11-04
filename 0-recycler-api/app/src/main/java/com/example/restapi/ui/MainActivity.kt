package com.example.restapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.restapi.R
import com.example.restapi.data.model.album.Album
import com.example.restapi.databinding.ActivityMainBinding
import com.example.restapi.viewmodel.album.AlbumViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var albumViewModel: AlbumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        albumViewModel = ViewModelProvider(this)[AlbumViewModel::class.java]

        getAlbums()
    }

//    private fun getAlbumsByUserId(userId:Int) {
//        val hashMap = hashMapOf<String,String>()
//        hashMap["userId"] = "1"
//        hashMap["id"] = "2"
//
//        val call = apiService.getAlbumsByUserId(hashMap)
//
//        call.enqueue(object: Callback<List<Album>>{
//            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
//                if(response.isSuccessful) {
//                    val list = response.body()
//                    Log.i("API","${list!!.size}")
//                    for (i in list!!.indices) {
//                        val msg = "${list[i].id} \n userId: ${list[i].userId} \n title: ${list[i].album_title} \n"
//                        binding.textView.append(msg)
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
//                Log.e("API", t.message.toString())
//            }
//        })
//    }

//    private fun getAlbum(id: Int) {
//        val call = apiService.getAlbums(id)
//
//        call.enqueue(object: Callback<Album>{
//            override fun onResponse(call: Call<Album>, response: Response<Album>) {
//                if(response.isSuccessful) {
//                    val album = response.body()
//                   Log.i("API",album.toString())
//                    binding.textView.append(album.toString())
//                }
//            }
//
//            override fun onFailure(call: Call<Album>, t: Throwable) {
//                Log.e("API", t.message.toString())
//            }
//        })
//    }

    private fun getAlbums() {
        albumViewModel.getAlbums()

        albumViewModel.getAlbumsLiveData?.observe(this, Observer {
            if (it!=null) {
                var list = it as ArrayList<Album>
                for (i in list!!.indices) {
                        val msg = "${list[i].id} \n userId: ${list[i].userId} \n title: ${list[i].album_title} \n"
                        binding.textView.append(msg)
                }
            }else{
                Log.e("API","wrong")
            }
        })
    }
}