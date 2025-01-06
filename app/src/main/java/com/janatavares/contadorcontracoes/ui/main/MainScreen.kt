// Novo pacote: ui.main
package com.janatavares.contadorcontracoes.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.janatavares.contadorcontracoes.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    val isContractionStarted by viewModel.isContractionStarted.collectAsState()
    val showInitialMessage by viewModel.showInitialMessage.collectAsState()

    Scaffold(
        topBar = { MainTopBar() },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (showInitialMessage) {
                        InitialMessage()
                    } else {
                        MainContent(viewModel = viewModel, isContractionStarted = isContractionStarted)
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    ContractionActionButton(
                        isContractionStarted = isContractionStarted,
                        onClick = {
                            if (isContractionStarted) viewModel.stopContraction() else viewModel.startContraction()
                        }
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Contrações") },
        navigationIcon = {
            IconButton(onClick = { /* Abrir modal das informações */ }) {
                Icon(Icons.Default.Info, contentDescription = "Informações")
            }
        },
        actions = {
            IconButton(onClick = { /* Abrir configurações */ }) {
                Icon(Icons.Default.Settings, contentDescription = "Configurações")
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
fun InitialMessage() {
    Text(
        text = "Quando sentir a contração, clique no botão abaixo para começar a gravar a frequência em que elas acontecem. Iremos analisar sempre as 3 últimas para te darmos dicas se deve ou não ir para a maternidade.",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun ContractionActionButton(isContractionStarted: Boolean, onClick: () -> Unit) {
    LargeFloatingActionButton(
        onClick = onClick,
        containerColor = if (isContractionStarted) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary,
        shape = CircleShape
    ) {
        Text(
            text = if (isContractionStarted) "Fim\n da \n contração" else "Início \n da \n contração",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MainContent(viewModel: MainScreenViewModel, isContractionStarted: Boolean) {
    Column(modifier = Modifier.fillMaxSize()) {
        InfoBar()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            items(10) { index ->
                ContractionItem(
                    number = index + 1,
                    duration = "5:00",
                    timestamp = "12:34 - 25/12",
                    intensity = "Alta"
                )
            }
        }
    }
}

@Composable
fun InfoBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.2f))
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Última hora",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "Duração média",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "Freq. média",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "3 contrações",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "50s",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "3m",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))
}
