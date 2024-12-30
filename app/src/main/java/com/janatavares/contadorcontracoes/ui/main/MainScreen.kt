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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Contrações")
                },
                navigationIcon = {
                    IconButton(onClick = { /*Abrir modal das informações de contração*/ }) {
                        Icon(Icons.Default.Info, contentDescription = "Informações")
                    }
                },
                actions = {
                    IconButton(onClick = { /*Abrir configurações*/ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Setteing")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary, // Ajusta a cor do fundo da top app bar
                    titleContentColor = MaterialTheme.colorScheme.onPrimary // Cor do texto
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                // Barra de informações principais com fundo destacado
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.2f)) // Fundo destacado
                        //.border(1.dp, MaterialTheme.colorScheme.primary) // Borda ao redor da "tabelinha"
                        .padding(16.dp) // Padding interno para espaçamento
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        // Linha dos títulos
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp), // Espaçamento entre os títulos e os valores
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Última hora",
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold) // Título em negrito
                            )
                            Text(
                                text = "Duração média",
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold) // Título em negrito
                            )
                            Text(
                                text = "Freq. média",
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold) // Título em negrito
                            )
                        }
                        // Linha dos valores
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "3 contrações",
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyMedium // Estilo normal
                            )
                            Text(
                                text = "50s",
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyMedium // Estilo normal
                            )
                            Text(
                                text = "3m",
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyMedium // Estilo normal
                            )
                        }
                    }
                }

                // Lista rolável de contrações
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f) // Para ocupar o espaço restante
                        .padding(horizontal = 16.dp)
                ) {
                    items(10) { index -> // Exemplo com 10 itens
                        ContractionItem(
                            duration = "1:20",
                            number = index + 1,
                            timestamp = "12:34 - 25/12",
                            intensity = "Alta"
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.BottomCenter
                ){
                    LargeFloatingActionButton(
                        onClick = {  },
                        containerColor = MaterialTheme.colorScheme.primary
                    ) {
                        Text(
                            """
                            Inicio
                            da
                            contração
                        """.trimIndent(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

    )
}

@Composable
fun ContractionItem(duration: String, number: Int, timestamp: String, intensity: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f), // Certifique-se de que o Row ocupe toda a largura disponível
            horizontalArrangement = Arrangement.Center // Para garantir que todos os itens dentro do Row fiquem centralizados
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp) // Tamanho fixo do fundo circular
                    .clip(CircleShape) // Faz o fundo circular
                    .background(MaterialTheme.colorScheme.secondary), // Cor de fundo
                contentAlignment = Alignment.Center // Alinha o texto no centro da bolinha
            ) {
                Text(
                    text = "$number",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black), // Cor do texto
                    textAlign = TextAlign.Center
                )
            }
        }
        Text(
            text = duration,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = timestamp,
                fontSize = 12.sp,
            )
            Text(
                text = intensity,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}