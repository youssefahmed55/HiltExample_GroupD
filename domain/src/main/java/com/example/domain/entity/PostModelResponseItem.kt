package com.example.domain.entity

import java.io.Serializable

data class PostModelResponseItem(
    val body: String ?= "",
    val id: Int ?= null,
    val title: String ?= "",
    val userId: Int ?= null
) : Serializable