package com.example.app_dio.domain

import com.example.app_dio.core.UseCase
import com.example.app_dio.data.Repo
import com.example.app_dio.data.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(
    private val repository: RepoRepository
) : UseCase<String, List<Repo>>() {

    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }
}