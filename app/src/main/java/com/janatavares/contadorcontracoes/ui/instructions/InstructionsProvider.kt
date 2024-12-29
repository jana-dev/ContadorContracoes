package com.janatavares.contadorcontracoes.ui.instructions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.janatavares.contadorcontracoes.R
import com.janatavares.contadorcontracoes.data.model.Instructions

@Composable
fun getInstructionsList(): List<Instructions> {
    return listOf(
        Instructions(
            imageRes = R.drawable.instruction1,
            annotatedText = AnnotatedString.Builder().apply{
                append(stringResource(id = R.string.instruction_1))
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                    append(" ")
                    append(stringResource(id = R.string.instruction_1_bold))
                    append(" ")
                }
                append(stringResource(id = R.string.instruction_1_final))
            }.toAnnotatedString()
        ),
        Instructions(
            imageRes =  R.drawable.instruction2,
            annotatedText = AnnotatedString.Builder().apply {
                append(stringResource(id = R.string.instruction_2))
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(" ")
                    append(stringResource(id = R.string.instruction_2_bold))
                }
            }.toAnnotatedString()
        ),
        Instructions(
            imageRes =  R.drawable.instruction3,
            annotatedText = AnnotatedString.Builder().apply {
                append(stringResource(id = R.string.instruction_3))
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(" ")
                    append(stringResource(id = R.string.instruction_3_bold))
                }
            }.toAnnotatedString()
        )
    )
}