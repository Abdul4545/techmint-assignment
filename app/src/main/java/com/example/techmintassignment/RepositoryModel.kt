package com.example.techmintassignment

data class Repository(
    val id: Long,
    val name: String,
    val owner: Owner,
    val description: String?,
    val html_url: String
)

data class Owner(
    val avatar_url: String,
    val login: String
)
