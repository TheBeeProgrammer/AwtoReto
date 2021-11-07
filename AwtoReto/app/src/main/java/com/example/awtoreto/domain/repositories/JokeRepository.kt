package com.example.awtoreto.domain.repositories

import com.example.awtoreto.domain.model.Joke
import io.reactivex.Flowable

interface JokeRepository {
    fun fetchJokes(): Flowable<Joke>?
}