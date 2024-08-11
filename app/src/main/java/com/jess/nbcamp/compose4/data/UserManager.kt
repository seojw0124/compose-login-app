package com.jess.nbcamp.compose4.data

import com.jess.nbcamp.compose4.user.signup.SignUpUiState

object UserManager {

    private var userList = mutableListOf<SignUpUiState>()

    fun saveUser(user: SignUpUiState): Boolean {
        if (isExistUser(user)) {
            return false
        }
        return userList.add(user)
    }

    fun getUser(user: SignUpUiState): SignUpUiState? {
        return userList.find { it.id == user.id && it.password == user.password }
    }

    fun isExistUser(user: SignUpUiState): Boolean {
        return userList.contains(getUser(user))
    }

    fun getCurrentUser(userId: String): SignUpUiState? {
        return userList.find { it.id == userId }
    }
}