package com.example.android4_1.data.remote.apiservises.models


import com.google.gson.annotations.SerializedName

data class CoverImage(
    @SerializedName("large")
    val large: String,
    @SerializedName("large_webp")
    val largeWebp: String,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("original")
    val original: String,
    @SerializedName("small")
    val small: String,
    @SerializedName("small_webp")
    val smallWebp: String,
    @SerializedName("tiny")
    val tiny: String,
    @SerializedName("tiny_webp")
    val tinyWebp: String
)