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
import android.app.Application
import com.example.amphibians.data.AppContainer
import com.example.amphibians.data.DefaultAppContainer

// Clase personalizada que extiende Application para inicializar dependencias globales
class AmphibiansApplication : Application() {

    /**
     * Variable que contiene una instancia de AppContainer,
     * que es un contenedor para dependencias compartidas en la app
     */
    lateinit var container: AppContainer

    // Método que se llama cuando la aplicación es creada
    override fun onCreate() {
        super.onCreate()
        // Inicializa la variable container con una instancia de DefaultAppContainer
        container = DefaultAppContainer()
    }
}
