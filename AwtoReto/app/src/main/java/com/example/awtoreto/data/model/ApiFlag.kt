package com.example.awtoreto.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiFlag(
    @SerializedName("explicit")
    @Expose
    val explicit: Boolean?,
    @SerializedName("nsfw")
    @Expose
    val nsfw: Boolean?,
    @SerializedName("political")
    @Expose
    val political: Boolean?,
    @SerializedName("racist")
    @Expose
    val racist: Boolean?,
    @SerializedName("religious")
    @Expose
    val religious: Boolean?,
    @SerializedName("sexist")
    @Expose
    val sexist: Boolean?
)
