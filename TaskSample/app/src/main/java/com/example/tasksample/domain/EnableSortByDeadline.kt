package com.example.tasksample.domain

import com.example.tasksample.domain.repo.UserPreferencesRepository

class EnableSortByDeadline(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    suspend operator fun invoke(enable: Boolean) =
        userPreferencesRepository.enableSortByDeadline(enable)
}