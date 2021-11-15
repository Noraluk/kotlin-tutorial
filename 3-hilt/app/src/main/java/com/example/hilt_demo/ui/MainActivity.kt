package com.example.hilt_demo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hilt_demo.R
import com.example.hilt_demo.data.model.album.Album
import com.example.hilt_demo.databinding.ActivityMainBinding
import com.example.hilt_demo.ui.adapter.AlbumAdapter
import com.example.hilt_demo.viewmodel.album.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
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
        albumViewModel.getAlbums().observe(this, {
            if (it!=null) {
                val list = it as ArrayList<Album>
                albumAdapter.setData(list)
            }else{
                Log.e("API","wrong")
            }
        })
    }

    private fun initAdapter() {
        albumAdapter = AlbumAdapter()
        binding!!.rvAlbum.layoutManager = LinearLayoutManager(this)
        binding!!.rvAlbum.adapter = albumAdapter
    }
}
