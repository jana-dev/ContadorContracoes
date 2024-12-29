package com.janatavares.contadorcontracoes.data.repository

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.janatavares.contadorcontracoes.R

data class Instructions(
    val imageRes: Int,
    val text: String,
    val annotatedText: AnnotatedString
)

val instructionsList = listOf(
    Instructions(
        imageRes = R.drawable.instruction1,
        text ="Quando sua barriga começar a endurecer ou sentir que a dor está vindo, aperte no botão inicio da contração e uma contagem irá começar",
        annotatedText = AnnotatedString.Builder().apply{
            append("Quando sua barriga começar a endurecer ou sentir que a dor está vindo, aperte no botão ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                append("inicio da contração")
            }
            append(" e uma contagem irá começar")
        }.toAnnotatedString()
    ),
    Instructions(
       imageRes =  R.drawable.instruction2,
       text = "Quando sentir que a contração parou, clique em Fim da contração",
        annotatedText = AnnotatedString.Builder().apply {
            append("Quando sentir que a contração parou, clique em ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("fim da contração")
            }
        }.toAnnotatedString()
    ),
    Instructions(
       imageRes =  R.drawable.instruction3,
       text =  "O app irá gerar as informações sobre as contrações, não esqueça de marcar as próximas",
        annotatedText = AnnotatedString.Builder().apply {
            append("O app irá gerar as informações sobre as contrações, ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("não esqueça de marcar as próximas")
            }
        }.toAnnotatedString()
    )

)
