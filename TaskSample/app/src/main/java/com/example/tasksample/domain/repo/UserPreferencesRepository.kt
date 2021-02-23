package com.example.tasksample.domain.repo

import com.example.tasksample.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    val userPreferences: Flow<UserPreferences>

    suspend fun enableSortByDeadline(enabled: Boolean)

    suspend fun enableSortByPriority(enabled: Boolean)

    suspend fun updateShowCompleted(showCompleted: Boolean)
}