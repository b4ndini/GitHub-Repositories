package com.lfelipe.githubrepositories.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lfelipe.githubrepositories.api.ResponseApi
import com.lfelipe.githubrepositories.model.ReposList
import com.lfelipe.githubrepositories.repository.ReposRepository
import kotlinx.coroutines.launch

class ReposViewModel : ViewModel(){

    var reposLiveData: MutableLiveData<ReposList> = MutableLiveData()
    private val repository = ReposRepository()

    fun getReposList() {
        viewModelScope.launch {
            when (val response = repository.getReposList()) {
                is ResponseApi.Success -> {
                    reposLiveData.postValue(response.data as ReposList?)
                }
                is ResponseApi.Error -> {

                }
            }
        }
    }
}