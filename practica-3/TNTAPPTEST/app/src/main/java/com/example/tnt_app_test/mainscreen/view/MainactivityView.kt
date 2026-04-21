package com.example.tnt_app_test.mainscreen.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tnt_app_test.mainscreen.logic.MainViewModel

@Composable
fun PantallaPrincipal(viewModel: MainViewModel) {
    val contador = viewModel.contador.intValue

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Contador: $contador")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.incrementar() }) {
            Text("Sumar")
        }
    }
}