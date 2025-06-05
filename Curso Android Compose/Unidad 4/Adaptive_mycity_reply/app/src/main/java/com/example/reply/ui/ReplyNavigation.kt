/*
 * Copyright 2022 Google LLC
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

package com.example.reply.ui
// Importa la anotación @StringRes para indicar que un parámetro representa un recurso de tipo string (R.string.*)
import androidx.annotation.StringRes

// Importa el conjunto de íconos por defecto de Material (Material Icons)
import androidx.compose.material.icons.Icons

// Importa el ícono "Article" en su versión rellena (filled)
import androidx.compose.material.icons.filled.Article

// Importa el ícono "Inbox" en su versión rellena (filled)
import androidx.compose.material.icons.filled.Inbox

// Importa el ícono "Chat" en su versión contorneada (outlined)
import androidx.compose.material.icons.outlined.Chat

// Importa el ícono "People" en su versión contorneada (outlined)
import androidx.compose.material.icons.outlined.People

// Importa el tipo ImageVector, que representa un vector gráfico como un ícono
import androidx.compose.ui.graphics.vector.ImageVector

// Importa el archivo de recursos R generado automáticamente, donde están los strings (como R.string.tab_inbox)
import com.example.reply.R


/**
 * Define los destinos de navegación disponibles dentro de la aplicación Reply.
 * Cada destino incluye un recurso de cadena para su etiqueta y un [ImageVector] para su ícono.
 *
 * @property labelRes El ID del recurso de cadena (de `strings.xml`) que representa la etiqueta de texto para este destino.
 * @property icon El [ImageVector] que se utilizará como ícono visual para este destino de navegación.
 */
enum class ReplyDestination(
    @StringRes val labelRes: Int,
    val icon: ImageVector,
) {
    /**
     * Destino para la bandeja de entrada de correos electrónicos.
     * Muestra la etiqueta "Inbox" y el ícono de bandeja de entrada rellena.
     */
    Inbox(R.string.tab_inbox, Icons.Default.Inbox),

    /**
     * Destino para la sección de artículos.
     * Muestra la etiqueta "Articles" y el ícono de artículo relleno.
     */
    Articles(R.string.tab_article, Icons.Default.Article),

    /**
     * Destino para los mensajes directos.
     * Muestra la etiqueta "Messages" y el ícono de chat contorneado.
     */
    Messages(R.string.tab_dm, Icons.Outlined.Chat),

    /**
     * Destino para la sección de grupos.
     * Muestra la etiqueta "Groups" y el ícono de personas contorneado.
     */
    Groups(R.string.tab_groups, Icons.Outlined.People),
}
