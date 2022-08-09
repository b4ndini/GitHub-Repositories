package com.lfelipe.githubrepositories.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lfelipe.githubrepositories.R
import com.lfelipe.githubrepositories.model.RepoDataItem
import com.lfelipe.githubrepositories.model.ReposList

class MainAdapter(private val repoList: ReposList) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repoList[position])
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(repository: RepoDataItem) = with(itemView) {
            findViewById<TextView>(R.id.tvRepoTitle).text = repository.fullName
            findViewById<TextView>(R.id.tvRepoDescription).text = repository.description
            findViewById<TextView>(R.id.tvSourceCodeLanguage).text = repository.language
            findViewById<TextView>(R.id.cpStar).text = repository.stargazersCount.toString()
        }
    }
}
