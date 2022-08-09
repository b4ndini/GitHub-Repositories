package com.lfelipe.githubrepositories.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.lfelipe.githubrepositories.R
import com.lfelipe.githubrepositories.databinding.ActivityMainBinding
import com.lfelipe.githubrepositories.viewmodel.ReposViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ReposViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ReposViewModel::class.java)
        viewModel.getReposList()
    }

}