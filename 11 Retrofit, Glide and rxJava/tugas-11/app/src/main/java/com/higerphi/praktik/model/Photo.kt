package com.higerphi.praktik.model

import com.google.gson.annotations.SerializedName

class Photo (
    @SerializedName("id")
    val id: Int?,
    @SerializedName("albumId")
    val albumId: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String?
)

class Posts (
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("body")
    val body: String?
)