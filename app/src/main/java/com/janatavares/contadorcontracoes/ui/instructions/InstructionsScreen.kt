package com.janatavares.contadorcontracoes.ui.instructions

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InstructionsScreen(onNavigateToMain: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Aqui estão algumas instruções para usar o app.")
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(onClick = onNavigateToMain) {
            Text(text = "Entendi")
        }
    }
}