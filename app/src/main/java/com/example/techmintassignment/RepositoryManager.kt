package com.example.techmintassignment

import androidx.lifecycle.LiveData


class RepositoryManager (
    private val apiService: GitHubApiService,
    private val repositoryDao: RepositoryDao
) {

    suspend fun searchRepositories(query: String, page: Int): List<Repository> {
        val response = apiService.searchRepositories(query, page)
        if (page == 1) {
            val repoEntities = response.items.map { repo ->
                RepositoryEntity(
                    id = repo.id,
                    name = repo.name,
                    ownerName = repo.owner.login,
                    description = repo.description,
                    htmlUrl = repo.html_url,
                    avatarUrl = repo.owner.avatar_url
                )
            }
            repositoryDao.insertRepositories(repoEntities)
        }
        return response.items
    }

    fun getOfflineRepositories(): LiveData<List<RepositoryEntity>> {
        return repositoryDao.getOfflineRepositories()
    }
}
