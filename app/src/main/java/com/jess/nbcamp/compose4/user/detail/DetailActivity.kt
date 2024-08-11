package com.jess.nbcamp.compose4.user.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.jess.nbcamp.compose4.user.signin.SignInScreen
import com.jess.nbcamp.compose4.user.signup.SignUpViewModel

class DetailActivity : ComponentActivity() {

    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DetailScreen(
                viewModel = viewModel,
            )
        }
    }
}