package com.janatavares.contadorcontracoes.ui.instructions

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.janatavares.contadorcontracoes.data.repository.Instructions
import com.janatavares.contadorcontracoes.data.repository.instructionsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstructionsScreen(onNavigateToMain: () -> Unit) {
    val backgroundColor = MaterialTheme.colorScheme.background
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f, pageCount = {instructionsList.size})
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)

    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),

        ) {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = { Text(text = "Instruções") }
            )


            Spacer(modifier = Modifier.weight(1f))

            // Textos das instruções
            HorizontalPager(
                state = pagerState,
            ){ page ->
                InstructionPage(instruction = instructionsList[page])
            }

            //Indicador de página
            Row(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center
            ){
                repeat(pagerState.pageCount) { index  ->
                    Log.d("Indicator", "Drawing indicator for page $index")
                    val indicatorColor = if (pagerState.currentPage == index) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.secondary
                    }
                    Box(
                        modifier = Modifier
                            .size(18.dp)
                            .padding(4.dp)
                            .clip(CircleShape)
                            .background(indicatorColor)
                    )
                }
            }


            Spacer(modifier = Modifier.weight(1f))

            //Lista de informações
            /*LazyColumn (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ){
                items(contractionInfoList) { item ->
                    ContractionCard(title = item.titulo, frequency = item.frequencia, intensity = item.intensidade, duration = item.duracao)
                }
            }*/

            Spacer(modifier = Modifier.height(16.dp))
            ElevatedButton(
                onClick = onNavigateToMain,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(8.dp)
            ) {
                Text(text = "Entendi")
            }
        }
    }
}

@Composable
fun InstructionPage(instruction: Instructions){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = instruction.imageRes),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        Box(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
           contentAlignment = Alignment.Center
        ){
            Text(
                text = instruction.annotatedText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

/*@Composable
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
}*/

