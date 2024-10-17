package com.example.techmintassignment

import androidx.room.Query
import com.google.firebase.database.core.Repo

//interface GitHubApiService {
//}


//interface GitHubApiService {
//    @GET("search/repositories")
//    suspend fun searchRepositories(
//        @Query("q") query: String,
//        @Query("page") page: Int,
//        @Query("per_page") perPage: Int = 10
//    ): SearchResult
//
//    @GET("repos/{owner}/{repo}/contributors")
//    suspend fun getContributors(
//        @Path("owner") owner: String,
//        @Path("repo") repo: String
//    ): List<Contributor>
//}

data class SearchResponse(
    val items: List<Repo>
)

interface GitHubApiService {
    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("page") page: Int
    ): SearchResponse
}

