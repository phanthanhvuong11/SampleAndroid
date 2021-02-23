package com.example.tasksample.domain.model

import SortOrder

data class UserPreferences(
    val showCompleted: Boolean,
    val sortOrder: SortOrder,
)