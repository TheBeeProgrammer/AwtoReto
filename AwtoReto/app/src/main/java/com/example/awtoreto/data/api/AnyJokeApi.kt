package com.example.awtoreto.data.api

import com.example.awtoreto.data.model.ApiJoke
import io.reactivex.Flowable
import retrofit2.http.GET

interface AnyJokeApi {
    @GET("joke/Any")
    fun getJokes(): Flowable<ApiJoke>
}