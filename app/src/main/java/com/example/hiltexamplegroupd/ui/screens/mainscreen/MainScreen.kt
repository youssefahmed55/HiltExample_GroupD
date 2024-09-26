package com.example.hiltexamplegroupd.ui.screens.mainscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel = hiltViewModel()){
    val list by viewModel.postsList.collectAsState()

    LazyColumn {
        items(list){
            Text(it.title)
        }
    }

}