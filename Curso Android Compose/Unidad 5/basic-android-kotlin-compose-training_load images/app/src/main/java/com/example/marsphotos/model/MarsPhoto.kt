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

package com.example.marsphotos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Clase de datos que representa una foto de Marte.
 *
 * Esta clase está diseñada para ser serializada y deserializada automáticamente por Kotlinx Serialization.
 * Contiene la información esencial de una foto: su identificador único y la URL de la imagen.
 *
 * @property id El identificador único de la foto de Marte.
 * @property imgSrc La URL de origen de la imagen de la foto de Marte.
 * Se mapea al campo "img_src" del JSON de la API.
 */
@Serializable // Indica que esta clase puede ser serializada a (y deserializada desde) un formato como JSON.
data class MarsPhoto(
    val id: String, // Propiedad para almacenar el ID de la foto.
    @SerialName(value = "img_src") // Mapea esta propiedad al nombre "img_src" en el JSON recibido.
    val imgSrc: String // Propiedad para almacenar la URL de la imagen.
)
