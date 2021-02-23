package com.example.tasksample

import android.app.Application
import androidx.datastore.preferences.createDataStore
import com.example.tasksample.data.TaskRepositoryImp
import com.example.tasksample.data.UserPreferencesRepositoryImpl
import com.example.tasksample.domain.ChangeShowCompleted
import com.example.tasksample.domain.EnableSortByDeadline
import com.example.tasksample.domain.FilterSortTasks
import com.example.tasksample.ui.MainViewModel

object Locator {
    private var application: Application? = null

    private inline val requireApplication
        get() = application ?: error("Missing call: initWith(application)")

    fun initWith(application: Application) {
        this.application = application
    }

    val mainViewModelFactory
        get() = MainViewModel.Factory(
            filterSortTasks,
            changeShowCompleted,
            enableSortByDeadline,
        )

    private val filterSortTasks
        get() = FilterSortTasks(
            taskRepository = taskRepository,
            userPreferencesRepository = userPreferencesRepository
        )

    private val changeShowCompleted get() = ChangeShowCompleted(userPreferencesRepository)

    private val enableSortByDeadline get() = EnableSortByDeadline(userPreferencesRepository)

    private val taskRepository by lazy { TaskRepositoryImp() }
    private val userPreferencesRepository by lazy {
        val dataStore = requireApplication.createDataStore(name = "user_preferences")
        UserPreferencesRepositoryImpl(dataStore)
    }
}