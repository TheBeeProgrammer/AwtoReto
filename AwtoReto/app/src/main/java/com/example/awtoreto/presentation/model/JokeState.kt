package com.example.awtoreto.presentation.model

import com.example.awtoreto.core.Event
import com.example.awtoreto.domain.model.Joke

data class JokeState(
    val joke: Joke? = null,
    val isAJokeState: Boolean = false,
    val failure: Event<Throwable>? = null,
    val noResultsState: Boolean = false,
)
