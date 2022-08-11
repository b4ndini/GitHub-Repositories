package com.lfelipe.githubrepositories.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lfelipe.githubrepositories.databinding.ActivityMainBinding
import com.lfelipe.githubrepositories.viewmodel.ReposViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ReposViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ReposViewModel::class.java]
        viewModel.getReposList()
        setObservers()
    }

    private fun setObservers() {
        viewModel.reposLiveData.observe(this) { list ->
            list.let {
                binding.rvReposList.apply {
                    layoutManager =
                        LinearLayoutManager(context)
                    adapter = MainAdapter(list)
                }
            }
        }
        viewModel.errorMsgLiveData.observe(this){ errorMsg ->
            Toast.makeText(this, "Erro: $errorMsg", Toast.LENGTH_LONG).show()
        }
    }
}