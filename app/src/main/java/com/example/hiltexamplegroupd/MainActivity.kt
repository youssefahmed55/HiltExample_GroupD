package com.example.hiltexamplegroupd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.domain.entity.PostModelResponseItem
import com.example.hiltexamplegroupd.ui.screens.mainscreen.MainScreen
import com.example.hiltexamplegroupd.ui.screens.postdetails.PostDetailsScreen
import com.example.hiltexamplegroupd.ui.theme.HiltExampleGroupDTheme
import com.google.gson.Gson
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HiltExampleGroupDTheme {
                HiltExampleCompose()
            }
        }
    }
}

@Composable
fun HiltExampleCompose(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") { MainScreen(navController) }
        composable(
            route = "postDetailsScreen/{postDataJson}",
            arguments = listOf(
                navArgument("postDataJson") { type = NavType.StringType }
            )
        ) {
            PostDetailsScreen()
        }
    }

}
