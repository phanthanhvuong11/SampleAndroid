package com.example.tasksample.domain

import com.example.tasksample.domain.repo.UserPreferencesRepository

class ChangeShowCompleted(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    suspend operator fun invoke(showCompleted: Boolean) =
        userPreferencesRepository.updateShowCompleted(showCompleted)
}