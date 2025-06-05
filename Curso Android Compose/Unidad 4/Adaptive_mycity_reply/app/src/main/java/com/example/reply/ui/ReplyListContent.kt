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

// Importaciones necesarias para diseño y layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

// Importaciones para diseño adaptable a barras de navegación y áreas seguras
import androidx.compose.foundation.layout.WindowInsets.*
import androidx.compose.foundation.layout.WindowInsetsSides.*
import androidx.compose.foundation.layout.safeDrawing

// Importaciones para listas con desplazamiento
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

// Para dar forma redonda a elementos
import androidx.compose.foundation.shape.CircleShape

// Iconos por defecto
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.StarBorder

// Componentes de Material Design 3
import androidx.compose.material3.*

// Soporte para funciones composables y layout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

// Para obtener recursos desde res/
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

// Para ajustar textos y alineación
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

// Modelo de datos Email
import com.example.reply.R
import com.example.reply.data.Email

// ------------------- PANE PRINCIPAL CON LISTA DE CORREOS -------------------

/**
 * Composable que muestra un panel con una lista desplazable de correos electrónicos.
 * Incluye una barra de búsqueda en la parte superior y renderiza cada correo como un [ReplyEmailListItem].
 *
 * @param replyHomeUIState El estado de la UI que contiene la lista de [Email]s a mostrar.
 * @param onEmailClick Callback que se invoca cuando se hace clic en un [Email] individual de la lista.
 * @param modifier Un [Modifier] para aplicar ajustes de diseño a este componente.
 */
@Composable
fun ReplyListPane(
    replyHomeUIState: ReplyHomeUIState,
    onEmailClick: (Email) -> Unit,
    modifier: Modifier = Modifier
) {
    // [LazyColumn] es un componente que renderiza solo los elementos visibles, optimizando el rendimiento para listas largas.
    LazyColumn(
        modifier = modifier.fillMaxWidth(), // Ocupa todo el ancho disponible.
        // Añade padding para respetar las barras del sistema (estado y navegación), solo en horizontal y arriba.
        contentPadding = safeDrawing.only(androidx.compose.foundation.layout.WindowInsetsSides.Horizontal + androidx.compose.foundation.layout.WindowInsetsSides.Top).asPaddingValues()
    ) {
        // Agrega un solo elemento en la parte superior de la lista: la barra de búsqueda.
        item {
            ReplySearchBar(modifier = Modifier.fillMaxWidth()) // La barra de búsqueda ocupa todo el ancho.
        }
        // Itera sobre la lista de correos electrónicos en el estado de la UI.
        items(replyHomeUIState.emails) { email ->
            // Para cada correo, renderiza un [ReplyEmailListItem] individual y pasa el callback de clic.
            ReplyEmailListItem(
                email = email,
                onEmailClick = onEmailClick
            )
        }
    }
}

// ------------------- PANEL DETALLE DE UN CORREO Y SUS RESPUESTAS -------------------

/**
 * Composable que muestra el detalle de un correo electrónico y sus respuestas en un panel desplazable.
 *
 * @param email El objeto [Email] cuyo detalle y respuestas se van a mostrar.
 * @param modifier Un [Modifier] para aplicar ajustes de diseño a este componente.
 */
@Composable
fun ReplyDetailPane(
    email: Email,
    modifier: Modifier = Modifier
) {
    // [LazyColumn] para permitir el desplazamiento del contenido del detalle del correo.
    LazyColumn(
        modifier = modifier.fillMaxWidth(), // Ocupa todo el ancho disponible.
        // Añade padding para respetar las barras del sistema (estado y navegación), solo en horizontal y arriba.
        contentPadding = safeDrawing.only(androidx.compose.foundation.layout.WindowInsetsSides.Horizontal + androidx.compose.foundation.layout.WindowInsetsSides.Top).asPaddingValues()
    ) {
        // Renderiza el correo original como el primer elemento en el hilo.
        item {
            ReplyEmailThreadItem(email)
        }
        // Itera sobre las respuestas del correo para mostrarlas en el hilo.
        items(email.replies) { reply ->
            ReplyEmailThreadItem(reply) // Cada respuesta se muestra como un [ReplyEmailThreadItem].
        }
    }
}


// ------------------- CADA ELEMENTO DE LA LISTA DE CORREOS -------------------

/**
 * Composable que representa un elemento individual de la lista de correos electrónicos (una tarjeta clicable).
 * Muestra información clave del correo como remitente, asunto, fecha y una vista previa del cuerpo.
 *
 * @param email El objeto [Email] que se va a mostrar.
 * @param onEmailClick Callback que se invoca cuando se hace clic en esta tarjeta de correo.
 * @param modifier Un [Modifier] para aplicar ajustes de diseño a este componente.
 */
@Composable
fun ReplyEmailListItem(
    email: Email,
    onEmailClick: (Email) -> Unit,
    modifier: Modifier = Modifier
) {
    // [Card] proporciona un contenedor con elevación y esquinas redondeadas, y es clicable.
    Card(
        onClick = { onEmailClick(email) }, // Define la acción al hacer clic en la tarjeta.
        modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp) // Añade padding alrededor de la tarjeta.
    ) {
        // Columna que organiza los elementos del correo verticalmente dentro de la tarjeta.
        Column(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho de la tarjeta.
                .padding(20.dp) // Padding interno para el contenido.
        ) {
            // Fila para el remitente, fecha y botón de favorito.
            Row(modifier = Modifier.fillMaxWidth()) {
                // Muestra la imagen de perfil del remitente.
                ReplyProfileImage(
                    drawableResource = email.sender.avatar,
                    description = email.sender.fullName,
                )
                // Columna para el nombre del remitente y la fecha de creación.
                Column(
                    modifier = Modifier
                        .weight(1f) // Ocupa el espacio restante horizontalmente.
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center // Centra el contenido verticalmente.
                ) {
                    // Muestra el nombre de pila del remitente.
                    Text(
                        text = email.sender.firstName,
                        style = MaterialTheme.typography.labelMedium // Estilo de texto del tema.
                    )
                    // Muestra la fecha de creación del correo.
                    Text(
                        text = email.createAt,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline // Color de texto del tema.
                    )
                }
                // Botón de ícono para marcar/desmarcar como favorito.
                IconButton(
                    onClick = { /*TODO: Implementar funcionalidad de favorito*/ },
                    modifier = Modifier
                        .clip(CircleShape) // Recorta el botón en forma circular.
                        .background(MaterialTheme.colorScheme.surface) // Fondo del botón.
                ) {
                    // Ícono de estrella.
                    Icon(
                        imageVector = Icons.Default.StarBorder,
                        contentDescription = "Favorite", // Descripción para accesibilidad.
                        tint = MaterialTheme.colorScheme.outline // Color del ícono.
                    )
                }
            }

            // Muestra el asunto del correo.
            Text(
                text = email.subject,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 12.dp, bottom = 8.dp), // Padding vertical.
            )
            // Muestra una vista previa del cuerpo del correo (máximo 2 líneas, con elipsis si excede).
            Text(
                text = email.body,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2, // Limita a dos líneas.
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                overflow = TextOverflow.Ellipsis // Añade "..." si el texto es muy largo.
            )
        }
    }
}

// ------------------- CADA ELEMENTO DE LA CONVERSACIÓN -------------------


/**
 * Composable que representa un correo electrónico individual dentro de un hilo de conversación.
 * Es similar a [ReplyEmailListItem] pero incluye botones de "Responder" y "Responder a todos".
 *
 * @param email El objeto [Email] que se va a mostrar como parte del hilo.
 * @param modifier Un [Modifier] para aplicar ajustes de diseño a este componente.
 */
@Composable
fun ReplyEmailThreadItem(
    email: Email,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 16.dp), // Padding horizontal para la tarjeta.
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface) // Color de fondo de la tarjeta.
    ) {
        // Columna para organizar el contenido del correo.
        Column(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho.
                .padding(horizontal = 20.dp) // Padding horizontal interno.
        ) {
            // Fila para la imagen del remitente, nombre, fecha y botón de favorito.
            Row(modifier = Modifier.fillMaxWidth()) {
                ReplyProfileImage(
                    drawableResource = email.sender.avatar,
                    description = email.sender.fullName,
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = email.sender.firstName,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = email.createAt,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                IconButton(
                    onClick = { /*TODO: Implementar funcionalidad de favorito*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Icon(
                        imageVector = Icons.Default.StarBorder,
                        contentDescription = "Favorite",
                        tint = MaterialTheme.colorScheme.outline
                    )
                }
            }

            // Asunto del correo (en este contexto, puede ser un asunto de respuesta).
            Text(
                text = email.subject,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
            )

            // Cuerpo completo del correo en el hilo de conversación.
            Text(
                text = email.body,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            // Fila de botones para acciones de respuesta.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp), // Padding vertical para los botones.
                horizontalArrangement = Arrangement.spacedBy(4.dp), // Espacio entre los botones.
            ) {
                // Botón "Responder".
                Button(
                    onClick = { /*TODO: Implementar acción de responder*/ },
                    modifier = Modifier.weight(1f), // Ocupa la mitad del espacio disponible.
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.inverseOnSurface) // Color del botón.
                ) {
                    Text(
                        text = stringResource(id = R.string.reply), // Texto del botón desde recursos.
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                // Botón "Responder a todos".
                Button(
                    onClick = { /*TODO: Implementar acción de responder a todos*/ },
                    modifier = Modifier.weight(1f), // Ocupa la otra mitad del espacio disponible.
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.inverseOnSurface)
                ) {
                    Text(
                        text = stringResource(id = R.string.reply_all), // Texto del botón desde recursos.
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}


// ------------------- IMAGEN DE PERFIL REDONDA -------------------

/**
 * Composable para mostrar una imagen de perfil circular.
 *
 * @param drawableResource El ID del recurso drawable (imagen) a mostrar.
 * @param description Una descripción para la accesibilidad de la imagen.
 * @param modifier Un [Modifier] para aplicar ajustes de diseño a este componente.
 */
@Composable
fun ReplyProfileImage(
    drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = modifier
            .size(40.dp) // Establece un tamaño fijo para la imagen.
            .clip(CircleShape), // Recorta la imagen para que sea circular.
        painter = painterResource(id = drawableResource), // Carga la imagen desde los recursos.
        contentDescription = description, // Proporciona una descripción para lectores de pantalla.
    )
}

// ------------------- BARRA DE BÚSQUEDA -------------------

/**
 * Composable que representa la barra de búsqueda de la aplicación Reply.
 * Contiene un ícono de búsqueda, un texto de marcador de posición y una imagen de perfil.
 *
 * @param modifier Un [Modifier] para aplicar ajustes de diseño a este componente.
 */
@Composable
fun ReplySearchBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth() // Ocupa todo el ancho disponible.
            .padding(horizontal = 16.dp) // Padding horizontal.
            .background(MaterialTheme.colorScheme.surface, CircleShape), // Fondo con color del tema y forma circular.
        verticalAlignment = Alignment.CenterVertically // Alinea los elementos verticalmente al centro.
    ) {
        // Ícono de búsqueda.
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(id = R.string.search), // Descripción para accesibilidad.
            modifier = Modifier.padding(start = 16.dp), // Padding al inicio del ícono.
            tint = MaterialTheme.colorScheme.outline // Color del ícono.
        )
        // Texto de marcador de posición "Search replies".
        Text(
            text = stringResource(id = R.string.search_replies),
            modifier = Modifier
                .weight(1f) // Permite que el texto ocupe el espacio restante.
                .padding(16.dp), // Padding alrededor del texto.
            style = MaterialTheme.typography.bodyMedium, // Estilo de texto del tema.
            color = MaterialTheme.colorScheme.outline // Color del texto.
        )
        // Imagen de perfil del usuario actual (avatar).
        ReplyProfileImage(
            drawableResource = R.drawable.avatar_6, // Recurso drawable del avatar.
            description = stringResource(id = R.string.profile), // Descripción para accesibilidad.
            modifier = Modifier
                .padding(12.dp) // Padding alrededor de la imagen.
                .size(32.dp) // Tamaño fijo de la imagen.
        )
    }
}
