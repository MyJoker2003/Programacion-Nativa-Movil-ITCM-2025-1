/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.amphibians
import android.os.Bundle                          // Importa Bundle para el ciclo de vida de Android
import androidx.activity.ComponentActivity       // Importa ComponentActivity para usar con Compose
import androidx.activity.compose.setContent      // Importa setContent para definir UI con Compose en Activity
import androidx.compose.foundation.layout.fillMaxSize  // Modifier para que un componente ocupe todo el espacio disponible
import androidx.compose.material3.MaterialTheme   // Importa el tema Material3 para acceder a colores y estilos
import androidx.compose.material3.Surface         // Composable que representa una superficie (fondo, forma, sombra)
import androidx.compose.ui.Modifier               // Para modificar composables (como tamaño, padding, etc.)
import com.example.amphibians.ui.AmphibiansApp  // Importa el composable principal de la app (definido en otro archivo)
import com.example.amphibians.ui.theme.AmphibiansTheme // Tema personalizado para la app

// Clase principal de la app que hereda de ComponentActivity para usar Compose
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // Llama al onCreate del padre

        // Define la UI con Jetpack Compose
        setContent {
            // Aplica el tema personalizado AmphibiansTheme a toda la app
            AmphibiansTheme {
                // Surface es una "superficie" que llena la pantalla y usa el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),  // Ocupa toda la pantalla
                    color = MaterialTheme.colorScheme.background  // Usa el color de fondo del tema Material3
                ) {
                    AmphibiansApp()  // Llama al composable principal que contiene el resto de la UI
                }
            }
        }
    }
}
