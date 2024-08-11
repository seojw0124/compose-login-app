package com.jess.nbcamp.compose4.user.detail

import android.os.Build
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jess.nbcamp.compose4.user.signup.SignUpUiState
import com.jess.nbcamp.compose4.user.signup.SignUpViewModel
import com.jess.nbcamp.compose4.util.Constants.EXTRA_USER

@Composable
fun DetailScreen(
    viewModel: SignUpViewModel,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    // intent 받아오기
    val intent = (context as DetailActivity).intent
    val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        intent.getParcelableExtra(EXTRA_USER, SignUpUiState::class.java)
    } else {
        intent.getParcelableExtra(EXTRA_USER)
    }

    Log.d("DetailScreen", "user: $user")
}