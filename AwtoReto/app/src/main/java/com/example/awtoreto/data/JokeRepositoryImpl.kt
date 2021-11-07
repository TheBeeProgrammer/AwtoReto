package com.example.awtoreto.data

import com.example.awtoreto.data.api.AnyJokeApi
import com.example.awtoreto.data.model.mapper.ApiJokeMapper
import com.example.awtoreto.domain.model.Joke
import com.example.awtoreto.domain.repositories.JokeRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import io.reactivex.Flowable
import javax.inject.Inject

@ActivityRetainedScoped
class JokeRepositoryImpl @Inject constructor(
    private val api: AnyJokeApi,
    private val apiJokeMapper: ApiJokeMapper
) : JokeRepository {
    override  fun fetchJokes(): Flowable<Joke> {
        return api.getJokes().map { apiJokeMapper.mapToDomain(it) }
    }
}