package com.lfelipe.githubrepositories.repository

import com.lfelipe.githubrepositories.api.ApiService
import com.lfelipe.githubrepositories.api.ResponseApi
import java.lang.Exception

class ReposRepository {

    suspend fun getReposList(): ResponseApi {
        return try {
            val response = ApiService.gitHubApi.getReposList()

            if (response.isSuccessful) {
                ResponseApi.Success(response.body())
            } else {
                ResponseApi.Error(response.code().toString())
            }
        } catch (exception: Exception) {
            ResponseApi.Error("ERRO CARREGAR")
        }
    }

}