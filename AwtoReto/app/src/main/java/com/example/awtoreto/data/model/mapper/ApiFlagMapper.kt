package com.example.awtoreto.data.model.mapper

import com.example.awtoreto.data.model.ApiFlag
import com.example.awtoreto.domain.model.Flag

class ApiFlagMapper : ApiMapper<ApiFlag, Flag> {
    override fun mapToDomain(apiEntity: ApiFlag?): Flag {
        return Flag(
            explicit = apiEntity?.explicit,
            nsfw = apiEntity?.nsfw,
            political = apiEntity?.political,
            racist = apiEntity?.racist,
            religious = apiEntity?.religious,
            sexist = apiEntity?.sexist
        )
    }
}