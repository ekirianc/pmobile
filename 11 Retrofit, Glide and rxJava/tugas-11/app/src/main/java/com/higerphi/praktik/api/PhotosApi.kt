package com.higerphi.praktik.api

import com.higerphi.praktik.model.Photo
import com.higerphi.praktik.model.Posts
import io.reactivex.Single
import retrofit2.http.GET

interface PhotosApi {
    @GET("photos")
    fun getPhotos(): Single<List<Photo>>
    @GET("posts")
    fun getPosts(): Single<List<Posts>>
}