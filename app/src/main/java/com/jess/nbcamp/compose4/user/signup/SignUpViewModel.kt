package com.jess.nbcamp.compose4.user.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jess.nbcamp.compose4.data.UserManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState.empty())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess: StateFlow<Boolean> = _isSuccess.asStateFlow()

    fun onChangedId(id: String) {
        _uiState.update { prev ->
            prev.copy(id = id)
        }
    }

    fun onChangedName(name: String) {
        _uiState.update { prev ->
            prev.copy(name = name)
        }
    }

    fun onChangedPassword(password: String) {
        _uiState.update { prev ->
            prev.copy(password = password)
        }
    }

    fun signUp(user: SignUpUiState) {
        if (UserManager.saveUser(user)) {
            _uiState.value = user
            _isSuccess.value = true
            Log.d("SignUpViewModel", "signUp: $user")
        } else {
            _isSuccess.value = false
            Log.e("SignUpViewModel", "signUp: failed")
        }
    }

    fun signIn(user: SignUpUiState) {
        val currentUser = UserManager.getUser(user)
        if (currentUser != null) {
            _uiState.value = currentUser
            _isSuccess.value = true
        } else {
            _isSuccess.value = false
        }
    }

//    fun getCurrentUser(userId: String): SignUpUiState? {
//        return UserManager.getCurrentUser(user)
//    }
}