package com.example.tasksample.data

import SortOrder
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.example.tasksample.domain.model.UserPreferences
import com.example.tasksample.domain.repo.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserPreferencesRepositoryImpl(
    private val dataStore: DataStore<Preferences>,
) : UserPreferencesRepository {
    private object Keys {
        val showCompleted = booleanPreferencesKey("show_completed")
        val sortOrder = stringPreferencesKey("sort_order")
    }

    private inline val Preferences.showCompleted
        get() = this[Keys.showCompleted] ?: false

    private inline val Preferences.sortOrder
        get() = this[Keys.sortOrder]?.let(SortOrder::valueOf) ?: SortOrder.NONE
    override val userPreferences: Flow<UserPreferences> = dataStore.data
        .catch {
            // throws an IOException when an error is encountered when reading data
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            UserPreferences(
                showCompleted = preferences.showCompleted,
                sortOrder = preferences.sortOrder,
            )
        }
        .distinctUntilChanged()

    override suspend fun enableSortByDeadline(enabled: Boolean) {
        dataStore.edit {
            val sortOrder = it.sortOrder

            val newSortOrder = if (enabled) {
                when (sortOrder) {
                    SortOrder.NONE -> SortOrder.BY_DEADLINE
                    SortOrder.BY_DEADLINE -> SortOrder.BY_DEADLINE
                    SortOrder.BY_PRIORITY -> SortOrder.BY_DEADLINE_AND_PRIORITY
                    SortOrder.BY_DEADLINE_AND_PRIORITY -> SortOrder.BY_DEADLINE
                }
            } else {
                when (sortOrder) {
                    SortOrder.NONE -> SortOrder.NONE
                    SortOrder.BY_DEADLINE -> SortOrder.NONE
                    SortOrder.BY_PRIORITY -> SortOrder.NONE
                    SortOrder.BY_DEADLINE_AND_PRIORITY -> SortOrder.BY_PRIORITY
                }
            }

            it[Keys.sortOrder] = newSortOrder.name
        }
    }

    override suspend fun enableSortByPriority(enabled: Boolean) {
        dataStore.edit {
            val sortOrder = it.sortOrder

            val newSortOrder = if (enabled) {
                when (sortOrder) {
                    SortOrder.NONE -> SortOrder.BY_PRIORITY
                    SortOrder.BY_DEADLINE -> SortOrder.BY_DEADLINE_AND_PRIORITY
                    SortOrder.BY_PRIORITY -> SortOrder.BY_PRIORITY
                    SortOrder.BY_DEADLINE_AND_PRIORITY -> SortOrder.BY_PRIORITY
                }
            } else {
                when (sortOrder) {
                    SortOrder.NONE -> SortOrder.NONE
                    SortOrder.BY_DEADLINE -> SortOrder.NONE
                    SortOrder.BY_PRIORITY -> SortOrder.NONE
                    SortOrder.BY_DEADLINE_AND_PRIORITY -> SortOrder.BY_DEADLINE
                }
            }

            it[Keys.sortOrder] = newSortOrder.name
        }
    }

    override suspend fun updateShowCompleted(showCompleted: Boolean) {
        dataStore.edit { it[Keys.showCompleted] = showCompleted }
        Log.d("UserPreferencesRepo", "updateShowCompleted $showCompleted")
    }
}