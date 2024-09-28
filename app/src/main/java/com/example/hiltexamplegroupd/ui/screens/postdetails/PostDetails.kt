package com.example.hiltexamplegroupd.ui.screens.postdetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.entity.PostModelResponseItem

@Composable
fun PostDetailsScreen(viewModel: DetailScreenViewModel = hiltViewModel()) {

    val post by viewModel.post.collectAsState()

    Text(text = post.title ?: "")
}