package com.janatavares.contadorcontracoes.data.repository

data class ContractionInfo(val titulo: String, val frequencia: String, val intensidade: String, val duracao: String)

val contractionInfoList = listOf(
    ContractionInfo(
        titulo = "Contrações de Treinamento (Braxton Hicks)",
        frequencia = "Frequência: Irregulares",
        intensidade = "Intensidade: Indolor",
        duracao = "Duração: 30 a 60 segundos"
    ),
    ContractionInfo(
        titulo = "Pródomos",
        frequencia = "Frequência: Irregular, pode durar dias e até semanas",
        intensidade = "Intensidade: desde desconforto até cólicas leves mas não intensas",
        duracao = "Duração: 30 a 60 segundos"
    ),
    ContractionInfo(
        titulo = "Fase Latente do Trabalho de Parto",
        frequencia = "Frequência: A cada 5 a 20 minutos",
        intensidade = "Intensidade: Dolorosa, mas tolerável",
        duracao = "Duração: 30 a 60 segundos"
    ),
    ContractionInfo(
        titulo = "Fase Ativa do Trabalho de Parto",
        frequencia = "Frequência: A cada 3 a 5 minutos",
        intensidade = "Intensidade: Dor intensa",
        duracao = "Duração: 45 a 60 segundos"
    ),
    ContractionInfo(
        titulo = "Fase de Expulsão",
        frequencia = "Frequência: A cada 2 a 3 minutos",
        intensidade = "Intensidade: Muito intensa",
        duracao = "Duração: 60 a 90 segundos"
    )
)
