package com.higerphi.praktik.api

import com.higerphi.praktik.model.Photo
import com.higerphi.praktik.model.Posts
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PhotosService {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val api: PhotosApi

    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PhotosApi::class.java)
    }

    fun getPhotos(): Single<List<Photo>>{
        return api.getPhotos()
    }
    fun getPosts(): Single<List<Posts>>{
        return api.getPosts()
    }
}