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
@file:OptIn(ExperimentalMaterial3Api::class) // Indica que se están utilizando APIs experimentales de Material 3.

package com.example.marsphotos.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marsphotos.R
import com.example.marsphotos.ui.screens.HomeScreen
import com.example.marsphotos.ui.screens.MarsViewModel

/**
 * Composable principal de la aplicación Mars Photos.
 *
 * Configura la estructura básica de la UI, incluyendo la barra superior y el contenido principal.
 */
@Composable
fun MarsPhotosApp() {
    // Define el comportamiento de desplazamiento para la barra superior, haciéndola "entrar siempre".
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    // Scaffold proporciona la estructura visual básica de Material Design.
    Scaffold(
        // Aplica el comportamiento de desplazamiento anidado a todo el Scaffold.
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        // Define la barra superior de la aplicación.
        topBar = { MarsTopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        // Superficie que cubre todo el espacio disponible, aplicando el tema de Material.
        Surface(
            modifier = Modifier.fillMaxSize() // Asegura que la superficie ocupe todo el espacio.
        ) {
            // Obtiene una instancia de MarsViewModel utilizando el factory definido.
            val marsViewModel: MarsViewModel =
                viewModel(factory = MarsViewModel.Factory)
            // Muestra la pantalla principal, pasando el estado de la UI, la acción de reintento
            // y el padding proporcionado por el Scaffold.
            HomeScreen(
                marsUiState = marsViewModel.marsUiState, // Estado actual de la UI de las fotos de Marte.
                retryAction = marsViewModel::getMarsPhotos, // Función para reintentar la carga de fotos.
                contentPadding = it // Padding necesario para evitar que el contenido se superponga con la barra superior.
            )
        }
    }
}

/**
 * Composable para la barra superior de la aplicación Mars Photos.
 *
 * @param scrollBehavior El comportamiento de desplazamiento de la barra superior.
 * @param modifier Modificador opcional para aplicar a este composable.
 */
@Composable
fun MarsTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    // Barra superior centrada.
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior, // Aplica el comportamiento de desplazamiento.
        title = {
            // Texto del título de la barra superior, obtenido de los recursos de strings.
            Text(
                text = stringResource(R.string.app_name), // Título de la aplicación.
                style = MaterialTheme.typography.headlineSmall, // Estilo de texto para el título.
            )
        },
        modifier = modifier // Aplica modificadores pasados al composable.
    )
}