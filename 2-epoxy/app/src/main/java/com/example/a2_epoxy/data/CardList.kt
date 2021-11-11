package com.example.a2_epoxy.data

import androidx.annotation.DrawableRes

data class CardList(
    var title: String,
    var description: String,
    @DrawableRes
    var profilePic: Int,
)
