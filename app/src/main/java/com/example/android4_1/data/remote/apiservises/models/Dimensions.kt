package com.example.android4_1.data.remote.apiservises.models


import com.google.gson.annotations.SerializedName

data class Dimensions(
    @SerializedName("large")
    val large: Large,
    @SerializedName("large_webp")
    val largeWebp: LargeWebp,
    @SerializedName("small")
    val small: Small,
    @SerializedName("small_webp")
    val smallWebp: SmallWebp,
    @SerializedName("tiny")
    val tiny: Tiny,
    @SerializedName("tiny_webp")
    val tinyWebp: TinyWebp
)