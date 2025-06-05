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

import com.example.marsphotos.model.MarsPhoto
import com.example.marsphotos.network.MarsApiService

/**
 * Repository that fetch mars photos list from marsApi.
 */
interface MarsPhotosRepository {
    /** Fetches list of MarsPhoto from marsApi
     * Suspende la función para obtener una lista de [MarsPhoto] desde la API de Marte.
     *
     * @return Una lista de objetos [MarsPhoto] que representan las fotos de Marte.
     */
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

/**
 * Network Implementation of Repository that fetch mars photos list from marsApi.
 * Implementación de [MarsPhotosRepository] que obtiene las fotos de Marte desde una fuente de red.
 *
 * @param marsApiService El servicio de la API de Marte, a través del cual se realizarán las llamadas de red.
 */
class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    /**
     * Implementación de la función para obtener la lista de fotos de Marte.
     *
     * Delega la llamada real a la API al [marsApiService] inyectado.
     * @return Una lista de objetos [MarsPhoto].
     */
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}
