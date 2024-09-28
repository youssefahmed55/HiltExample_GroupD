package com.example.hiltexamplegroupd.ui.screens.postdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.entity.PostModelResponseItem
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class DetailScreenViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _post = MutableStateFlow(PostModelResponseItem())
    val post = _post.asStateFlow()

    private val argsCurrent: String? = savedStateHandle["postDataJson"]

    init {
        val gson = Gson()
        val postData = gson.fromJson(argsCurrent, PostModelResponseItem::class.java)
        _post.value = postData
    }

}