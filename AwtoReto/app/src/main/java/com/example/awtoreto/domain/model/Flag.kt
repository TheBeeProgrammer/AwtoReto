package com.example.awtoreto.domain.model

data class Flag(
    val explicit: Boolean?,
    val nsfw: Boolean?,
    val political: Boolean?,
    val racist: Boolean?,
    val religious: Boolean?,
    val sexist: Boolean?
)