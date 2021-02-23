package com.example.tasksample.domain.repo

import com.example.tasksample.domain.model.Task
import kotlinx.coroutines.flow.Flow


interface TaskRepository {
    fun tasks(): Flow<List<Task>>
}