package com.example.cryptocurrency.data.model


import com.google.gson.annotations.SerializedName

data class TagDto(
    @SerializedName("coin_counter")
    val coinCounter: Int?,
    @SerializedName("ico_counter")
    val icoCounter: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
)