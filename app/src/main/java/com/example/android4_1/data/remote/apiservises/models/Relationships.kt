package com.example.android4_1.data.remote.apiservises.models


import com.google.gson.annotations.SerializedName

data class Relationships(
    @SerializedName("castings")
    val castings: Castings,
    @SerializedName("categories")
    val categories: Categories,
    @SerializedName("chapters")
    val chapters: Chapters,
    @SerializedName("characters")
    val characters: Characters,
    @SerializedName("genres")
    val genres: Genres,
    @SerializedName("installments")
    val installments: Installments,
    @SerializedName("mangaCharacters")
    val mangaCharacters: MangaCharacters,
    @SerializedName("mangaStaff")
    val mangaStaff: MangaStaff,
    @SerializedName("mappings")
    val mappings: Mappings,
    @SerializedName("mediaRelationships")
    val mediaRelationships: MediaRelationships,
    @SerializedName("productions")
    val productions: Productions,
    @SerializedName("quotes")
    val quotes: Quotes,
    @SerializedName("reviews")
    val reviews: Reviews,
    @SerializedName("staff")
    val staff: Staff
)