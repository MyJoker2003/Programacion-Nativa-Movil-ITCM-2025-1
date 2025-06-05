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

import android.app.Application
// Importa la clase Application de Android, que representa la aplicación completa.

import com.example.marsphotos.data.AppContainer
// Importa la interfaz o clase que define el contenedor de dependencias de la app.

import com.example.marsphotos.data.DefaultAppContainer
// Importa la implementación concreta del contenedor de dependencias.

class MarsPhotosApplication : Application() {
    // Clase personalizada que extiende Application para configurar cosas globales al iniciar la app.

    /** AppContainer instance used by the rest of classes to obtain dependencies */
    // Comentario que explica que esta propiedad contendrá el contenedor de dependencias
    lateinit var container: AppContainer
    // Variable que se inicializará después (lateinit), para almacenar el contenedor de dependencias.

    override fun onCreate() {
        // Método que se ejecuta cuando la aplicación se crea (antes que cualquier Activity).
        super.onCreate()
        // Llama a la implementación de la superclase para asegurar el correcto funcionamiento.

        container = DefaultAppContainer()
        // Inicializa la variable container con la implementación por defecto del contenedor,
        // lo que permitirá que otras clases obtengan las dependencias necesarias.
    }
}
