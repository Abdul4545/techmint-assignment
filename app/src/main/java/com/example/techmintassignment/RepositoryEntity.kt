package com.example.techmintassignment

import androidx.room.Entity

@Entity(tableName = "repositories")
data class RepositoryEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val ownerName: String,
    val description: String?,
    val htmlUrl: String,
    val avatarUrl: String
)





