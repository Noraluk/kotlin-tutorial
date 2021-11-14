package com.example.a04_hilt.data.model.album

import com.google.gson.annotations.SerializedName

data class Album(
    val userId:Int,
    val id: Int,
    @SerializedName("title")
    val album_title: String
)
