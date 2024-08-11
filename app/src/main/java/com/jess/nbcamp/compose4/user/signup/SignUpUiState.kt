package com.jess.nbcamp.compose4.user.signup

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignUpUiState(
    val name: String,
    val id: String,
    val password: String,
) : Parcelable {
    companion object {

        fun empty(
            name: String = "",
            id: String = "",
            password: String = "",
        ) = SignUpUiState(
            name = name,
            id = id,
            password = password,
        )

    }
}