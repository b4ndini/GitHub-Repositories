package com.lfelipe.githubrepositories.api

import com.lfelipe.githubrepositories.model.ReposList
import retrofit2.Response
import retrofit2.http.GET

interface GitHubApi {

    @GET("repos")
    suspend fun getReposList(
    ): Response<ReposList>

}