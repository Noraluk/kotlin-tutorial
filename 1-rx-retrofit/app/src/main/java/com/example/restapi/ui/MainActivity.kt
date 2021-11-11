package com.example.restapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapi.R
import com.example.restapi.data.model.album.Album
import com.example.restapi.databinding.ActivityMainBinding
import com.example.restapi.ui.adapter.album.AlbumAdapter
import com.example.restapi.viewmodel.album.AlbumViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var albumViewModel: AlbumViewModel
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        albumViewModel = ViewModelProvider(this)[AlbumViewModel::class.java]

        initAdapter()

        getAlbums()
    }

    private fun getAlbums() {
        albumViewModel.getAlbums()

        albumViewModel.getAlbumsLiveData?.observe(this, Observer {
            if (it!=null) {
                var list = it as ArrayList<Album>
                albumAdapter.setData(list)
            }else{
                Log.e("API","wrong")
            }
        })
    }

    private fun initAdapter() {
        albumAdapter = AlbumAdapter()
        binding.rvAlbum.layoutManager = LinearLayoutManager(this)
        binding.rvAlbum.adapter = albumAdapter
    }
}