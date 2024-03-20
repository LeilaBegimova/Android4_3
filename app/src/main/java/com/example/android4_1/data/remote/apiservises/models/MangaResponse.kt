package com.example.android4_1.data.remote.apiservises.models


import com.google.gson.annotations.SerializedName

data class MangaResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("links")
    val links: LinksXXXXXXXXXXXXXXX,
    @SerializedName("meta")
    val meta: MetaXX
)