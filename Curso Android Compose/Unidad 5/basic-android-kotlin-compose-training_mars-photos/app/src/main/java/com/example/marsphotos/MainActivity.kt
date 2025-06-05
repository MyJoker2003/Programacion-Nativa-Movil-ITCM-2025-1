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
// Importa Bundle, que contiene el estado previo de la Activity si la hay.

import androidx.activity.ComponentActivity
// Importa ComponentActivity, que es una Activity base compatible con Jetpack Compose.

import androidx.activity.compose.setContent
// Importa setContent para establecer el contenido Compose de la Activity.

import androidx.activity.enableEdgeToEdge
// Importa enableEdgeToEdge, función para habilitar que el contenido se extienda hasta los bordes de la pantalla.

import androidx.compose.foundation.layout.fillMaxSize
// Importa fillMaxSize, un modificador para que un componente llene todo el espacio disponible.

import androidx.compose.material3.Surface
// Importa Surface, que es un contenedor que aplica un fondo y propiedades de Material3.

import androidx.compose.ui.Modifier
// Importa Modifier, para modificar el layout o comportamiento de componentes Compose.

import com.example.marsphotos.ui.MarsPhotosApp
// Importa MarsPhotosApp, la función composable principal que define la UI de la app.

import com.example.marsphotos.ui.theme.MarsPhotosTheme
// Importa MarsPhotosTheme, que aplica el tema personalizado de la app.

class MainActivity : ComponentActivity() {
    // Clase principal de la aplicación que hereda de ComponentActivity.

    override fun onCreate(savedInstanceState: Bundle?) {
        // Método llamado al crear la Activity.

        enableEdgeToEdge()
        // Habilita que el contenido de la ventana se extienda detrás de barras del sistema (status bar, nav bar).

        super.onCreate(savedInstanceState)
        // Llama al método padre para inicializar la Activity correctamente.

        setContent {
            // Define el contenido UI con Jetpack Compose.

            MarsPhotosTheme {
                // Aplica el tema personalizado a la UI.

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    // Surface que llena todo el espacio disponible en la pantalla.
                ) {
                    MarsPhotosApp()
                    // Composable principal que construye la interfaz de usuario de la app.
                }
            }
        }
    }
}
