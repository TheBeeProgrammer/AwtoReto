package com.example.awtoreto.data.model.mapper

import com.example.awtoreto.data.model.ApiJoke
import com.example.awtoreto.domain.model.Joke
import javax.inject.Inject

class ApiJokeMapper @Inject constructor() : ApiMapper<ApiJoke?, Joke> {
    override fun mapToDomain(apiEntity: ApiJoke?): Joke {

        return Joke(
            category = apiEntity?.category,
            delivery = apiEntity?.delivery,
            error = apiEntity?.error,
            flag = ApiFlagMapper().mapToDomain(apiEntity?.flag),
            id = apiEntity?.id,
            lang = apiEntity?.lang,
            safe = apiEntity?.safe,
            setup = apiEntity?.setup,
            joke = apiEntity?.joke,
            type = apiEntity?.type
        )
    }
}