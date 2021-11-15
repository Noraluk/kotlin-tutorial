package com.example.a03_hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a03_hilt.R
import com.example.a03_hilt.data.model.album.Album
import com.example.a03_hilt.databinding.ActivityMainBinding
import com.example.a03_hilt.ui.adapter.AlbumAdapter
import com.example.a03_hilt.viewmodel.album.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val albumViewModel by viewModels<AlbumViewModel>()
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        initAdapter()

        getAlbums()
    }

    private fun getAlbums() {
        albumViewModel.getAlbums()?.observe(this, Observer {
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
