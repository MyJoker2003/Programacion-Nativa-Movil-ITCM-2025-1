/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.marsphotos
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.marsphotos.ui.MarsPhotosApp
import com.example.marsphotos.ui.theme.MarsPhotosTheme

// Esta es la actividad principal de la aplicación MarsPhotos
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Habilita el modo Edge-to-Edge para que la UI se extienda bajo
        // la barra de estado y la barra de navegación del sistema
        enableEdgeToEdge()

        // Llama al método onCreate de la superclase para inicializar la actividad
        super.onCreate(savedInstanceState)

        // Configura el contenido Compose de la actividad
        setContent {
            // Aplica el tema personalizado de MarsPhotos
            MarsPhotosTheme {
                // Surface es un contenedor que aplica el fondo y otros estilos
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa todo el espacio disponible
                ) {
                    // Composable principal que contiene toda la app MarsPhotos
                    MarsPhotosApp()
                }
            }
        }
    }
}
