package com.jess.nbcamp.compose4.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class HoistingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HoistingScreen()
        }
    }
}


@Composable
private fun HoistingScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NameTextLabel()
        }
    }
}

@Composable
private fun NameTextLabel() {
    var name by remember { mutableStateOf("") }
    if (name.isNotEmpty()) {
        Text(
            text = "Hello, $name!",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
        )
    }

    NameTextField(
        name = name,
        onValueChange = {
            name = it
        },
    )
}

@Composable
private fun NameTextField(
    name: String,
    onValueChange: ((String) -> Unit),
) {
    OutlinedTextField(
        value = name,
        onValueChange = {
            onValueChange(it)
        },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text("Name")
        },
    )
}