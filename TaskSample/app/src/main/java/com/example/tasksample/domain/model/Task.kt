package com.example.tasksample.domain.model

import com.hoc081098.datastoresample.domain.model.TaskPriority
import java.util.*

data class Task(
    val name: String,
    val deadline: Date,
    val priority: TaskPriority,
    val completed: Boolean = false,
)