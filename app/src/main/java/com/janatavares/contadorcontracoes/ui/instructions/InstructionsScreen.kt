package com.janatavares.contadorcontracoes.ui.instructions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.janatavares.contadorcontracoes.data.repository.contractionInfoList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstructionsScreen(onNavigateToMain: () -> Unit) {
    val backgroundColor = MaterialTheme.colorScheme.background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)

    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = { Text(text = "Instruções") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Texto de introdução
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Assim que você sentir que sua barriga começou a endurecer ou que a dor esteja vindo, clique em 'início da contração'. E após sentir que a contração terminou, clique em 'fim da contração'. O aplicativo irá começar a gerar a frequência média de contrações."
            )

            Spacer(modifier = Modifier.height(16.dp))

            //Lista de informações
            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ){
                items(contractionInfoList) { item ->
                    ContractionCard(title = item.titulo, frequency = item.frequencia, intensity = item.intensidade, duration = item.duracao)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            ElevatedButton(onClick = onNavigateToMain) {
                Text(text = "Entendi")
            }
        }
    }
}

@Composable
fun ContractionCard(title: String, frequency: String, intensity: String, duration: String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
        ){
            Text(text = title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = frequency)
            Text(text = intensity)
            Text(text = duration)
        }
    }
}

