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
package com.example.marsphotos.data

import com.example.marsphotos.network.MarsApiService
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    /**
     * Propiedad que expone el repositorio de fotos de Marte.
     */
    val marsPhotosRepository: MarsPhotosRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer {
    // URL base para la API de Mars.
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        // Agrega un convertidor de fábrica para JSON utilizando kotlinx.serialization.
        // Se especifica el tipo de medio como "application/json".
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        // Establece la URL base para todas las solicitudes API.
        .baseUrl(baseUrl)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: MarsApiService by lazy {
        // Crea una implementación de la interfaz MarsApiService usando la instancia de Retrofit.
        retrofit.create(MarsApiService::class.java)
    }


    /**
     * Implementación del repositorio de fotos de Marte.
     *
     * Se inicializa de forma perezosa, utilizando la instancia de [retrofitService].
     * Esta es la dependencia que se expone a través del contenedor.
     */
    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        // Retorna una nueva instancia de NetworkMarsPhotosRepository, inyectándole el servicio de Retrofit.
        NetworkMarsPhotosRepository(retrofitService)
    }
}
