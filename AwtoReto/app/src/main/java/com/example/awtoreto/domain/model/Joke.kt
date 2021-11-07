package com.example.awtoreto.domain.model


data class Joke(
    val category: String? = "",
    val delivery: String? = "",
    val error: Boolean? = false,
    val flag: Flag? = null,
    val id: Int? = 0,
    val lang: String? = "",
    val safe: Boolean? = false,
    val setup: String? = "",
    val joke: String? = "",
    val type: String? = ""
)