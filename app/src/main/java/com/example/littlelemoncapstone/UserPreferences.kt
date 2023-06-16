package com.example.littlelemoncapstone

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "userData")
        private val FIRST_NAME = stringPreferencesKey("")
        private val LAST_NAME = stringPreferencesKey("")
        private val EMAIL = stringPreferencesKey("")
    }

    val firstNameFlow: Flow<String> =
        context.dataStore.data.map { preferences -> preferences[FIRST_NAME] ?: "" }

    val lastNameFlow: Flow<String> =
        context.dataStore.data.map { preferences -> preferences[LAST_NAME] ?: "" }

    val emailFlow: Flow<String> =
        context.dataStore.data.map { preferences -> preferences[EMAIL] ?: "" }

    suspend fun setUserData(name: String, lastName: String, email: String) {
        context.dataStore.edit { preferences ->
            preferences[FIRST_NAME] = name
            preferences[LAST_NAME] = lastName
            preferences[EMAIL] = email
        }
    }
}