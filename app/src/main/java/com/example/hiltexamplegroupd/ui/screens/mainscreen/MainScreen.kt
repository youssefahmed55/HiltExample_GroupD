package com.example.hiltexamplegroupd.ui.screens.mainscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.gson.Gson

@Composable
fun MainScreen(navController: NavController,viewModel: MainScreenViewModel = hiltViewModel()){
    val list by viewModel.postsList.collectAsState()

    LazyColumn {
        items(list){
            val gson = Gson()
            val postDataJson = gson.toJson(it)
            Text(it.title ?: "",modifier = Modifier.clickable {navController.navigate("postDetailsScreen/$postDataJson")})
        }
    }

}