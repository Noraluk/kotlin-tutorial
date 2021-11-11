package com.example.a2_epoxy.data

import androidx.annotation.DrawableRes

data class Movie(
    var id: String,
    @DrawableRes
    var imgPoster: Int,
    var name: String,
)
