package com.example.cryptocurrency.data.model


import com.google.gson.annotations.SerializedName

data class WhitepaperDto(
    @SerializedName("link")
    val link: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
)