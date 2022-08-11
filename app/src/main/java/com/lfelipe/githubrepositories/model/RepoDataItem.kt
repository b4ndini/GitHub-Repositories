package com.lfelipe.githubrepositories.model

import com.google.gson.annotations.SerializedName

data class RepoDataItem(
    @SerializedName("full_name")
    val fullName: String,
    val description: String?,
    val id: Int,
    val language: String,
    val name: String,
    val owner: Owner,
    @SerializedName("private")
    val private: Boolean,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
)