package com.janatavares.contadorcontracoes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.janatavares.contadorcontracoes.ui.navigation.AppNavHost
import com.janatavares.contadorcontracoes.ui.theme.ContadorContracoesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContadorContracoesTheme {
                Scaffold (
                    modifier = Modifier.fillMaxSize(),
                    content = { paddingValues ->
                        val navController = rememberNavController()
                        AppNavHost(navController = navController, modifier = Modifier.padding(paddingValues))
                    }
                )

            }
        }
    }
}
