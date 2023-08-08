package com.gmail.orlandroyd.repositoriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gmail.orlandroyd.repositoriesapp.ui.theme.RepositoriesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepositoriesAppTheme {
                val viewModel: RepositoriesViewModel = viewModel()
                val repos = viewModel.repositories.value
                RepositoriesScreen(repos)
            }
        }
    }
}