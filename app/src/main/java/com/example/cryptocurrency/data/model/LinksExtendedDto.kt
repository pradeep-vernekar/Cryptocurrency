package com.example.cryptocurrency.data.model


import com.google.gson.annotations.SerializedName

data class LinksExtendedDto(
    @SerializedName("stats")
    val stats: StatsDto?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)