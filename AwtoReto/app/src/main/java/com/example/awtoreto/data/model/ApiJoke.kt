package com.example.awtoreto.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiJoke(
    @SerializedName("category")
    @Expose
    val category: String?,
    @SerializedName("delivery")
    @Expose
    val delivery: String?,
    @SerializedName("error")
    @Expose
    val error: Boolean?,
    @SerializedName("flags")
    @Expose
    val flag: ApiFlag?,
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("lang")
    @Expose
    val lang: String?,
    @SerializedName("safe")
    @Expose
    val safe: Boolean?,
    @SerializedName("setup")
    @Expose
    val setup: String?,
    @SerializedName("joke")
    @Expose
    val joke: String?,
    @SerializedName("type")
    @Expose
    val type: String?
)