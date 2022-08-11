package com.lfelipe.githubrepositories.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lfelipe.githubrepositories.R
import com.lfelipe.githubrepositories.databinding.RepositoryCardItemBinding
import com.lfelipe.githubrepositories.model.RepoDataItem
import com.lfelipe.githubrepositories.model.ReposList

class MainAdapter(private val repoList: ReposList) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RepositoryCardItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repoList[position])
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    class ViewHolder(private val binding: RepositoryCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: RepoDataItem) = with(itemView) {
            Glide.with(this).load(repository.owner.ownerPicture).circleCrop().into(binding.ivOwnerPicture)
            binding.apply {
                tvRepoTitle.text = repository.name
                tvRepoDescription.text = repository.description ?: resources.getString(R.string.empty_repository_description)
                tvSourceCodeLanguage.text = repository.language
                cpStar.text = repository.stargazersCount.toString()
            }
        }
    }
}
