package com.lfelipe.githubrepositories.model

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("avatar_url")
    val ownerPicture: String,
    val id: Int,
    val login: String,
    val repos_url: String,
    val type: String,
    val url: String
)