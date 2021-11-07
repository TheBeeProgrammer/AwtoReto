package com.example.awtoreto.domain.usecases

import com.example.awtoreto.core.DataNotFound
import com.example.awtoreto.domain.model.Joke
import com.example.awtoreto.domain.repositories.JokeRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetJokes @Inject constructor(private val jokeRepository: JokeRepository) {
    operator fun invoke(): Flowable<Joke> {
        val joke = jokeRepository.fetchJokes()
        return joke ?: throw DataNotFound("Not Jokes Founds :(")
    }
}