package com.example.a2_epoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a2_epoxy.databinding.ActivityMainBinding
import com.example.a2_epoxy.factory.DataFactory
import com.example.a2_epoxy.ui.adapter.Controller

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val controller = Controller().apply {
            movies = DataFactory.getTopMovies()
            cardLists = DataFactory.getLists()
        }

        controller.onclickItem = { movie ->
            Toast.makeText(this,movie.name,Toast.LENGTH_LONG).show()
        }

        binding.apply{
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.setHasFixedSize(false)
            recyclerView.setController(controller)
        }
    }
}