package com.example.a2_epoxy.factory

import com.example.a2_epoxy.R
import com.example.a2_epoxy.data.CardList
import com.example.a2_epoxy.data.Movie

object DataFactory {
    fun getTopMovies() = listOf(
        Movie("001", R.drawable.movie, "Naruto" ),
        Movie( "002", R.drawable.movie, "Naruto1"),
        Movie( "003", R.drawable.movie, "Naruto2"),
        Movie( "004", R.drawable.movie, "Naruto"),
        Movie("005", R.drawable.movie, "Naruto"),
        Movie("006", R.drawable.movie, "Naruto"),
        Movie("007", R.drawable.movie, "Naruto"),
        Movie( "008", R.drawable.movie, "Naruto")
    )

    fun getLists() = listOf<CardList>(
        CardList("title_01","desc_01",R.drawable.profile),
        CardList("title_02","desc_02",R.drawable.profile),
        CardList("title_03","desc_03",R.drawable.profile),
        CardList("title_04","desc_04",R.drawable.profile),
        CardList("title_05","desc_05",R.drawable.profile),
        CardList("title_06","desc_06",R.drawable.profile),
        CardList("title_07","desc_07",R.drawable.profile),
    )
}