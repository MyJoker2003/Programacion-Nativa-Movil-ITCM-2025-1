

package com.example.reply.ui

// Importa funciones y componentes para el diseño (layout) y fondos (background)
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

// Importa componentes de Material 3
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text

// Importa herramientas de Compose para manejar estados y funciones composables
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// Importa modificadores de UI
import androidx.compose.ui.Modifier

// Permite obtener textos desde archivos de recursos (strings.xml)
import androidx.compose.ui.res.stringResource

// Importa clase Email usada como modelo de datos
import com.example.reply.data.Email

// ------------------- FUNCIÓN PRINCIPAL DE LA UI -------------------

/**
 * Función Composable principal de la aplicación Reply.
 * Este componente es el punto de entrada para construir la interfaz de usuario de toda la aplicación.
 *
 * @param replyHomeUIState El estado actual de la interfaz de usuario de la pantalla de inicio,
 * que contiene los datos a mostrar, como la lista de correos.
 * @param onEmailClick Callback que se invoca cuando un correo electrónico es clicado en la UI,
 * recibiendo el objeto [Email] correspondiente.
 */
@Composable
fun ReplyApp(
    replyHomeUIState: ReplyHomeUIState,
    onEmailClick: (Email) -> Unit,
) {
    // Envuelve el contenido principal de la aplicación con la estructura de navegación.
    ReplyNavigationWrapperUI {
        // Carga el contenido principal de la aplicación, pasando el estado y el callback.
        ReplyAppContent(
            replyHomeUIState = replyHomeUIState,
            onEmailClick = onEmailClick
        )
    }
}

// ------------------- ENVOLTORIO CON NAVEGACIÓN -------------------

@Composable
private fun ReplyNavigationWrapperUI(
    // `content` es un slot Composable que permite inyectar contenido dentro de este envoltorio.
    content: @Composable () -> Unit = {}
) {
    // `selectedDestination` es el estado que guarda la pantalla de navegación actualmente seleccionada.
    // Se inicializa en [ReplyDestination.Inbox] y se recuerda para mantener el estado a través de recomposiciones.
    var selectedDestination: ReplyDestination by remember {
        mutableStateOf(ReplyDestination.Inbox)
    }

    // `Column` es un contenedor que organiza sus elementos verticalmente.
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el espacio disponible en la pantalla.
            .background(MaterialTheme.colorScheme.inverseOnSurface) // Aplica un color de fondo del tema.
    ) {
        // `Box` actúa como un contenedor flexible para el contenido principal,
        // ocupando todo el espacio restante disponible por encima de la barra de navegación.
        Box(modifier = Modifier.weight(1f)) {
            content() // Aquí se inserta el contenido Composable proporcionado.
        }

        // `NavigationBar` es el componente de la barra de navegación inferior de Material Design.
        NavigationBar(modifier = Modifier.fillMaxWidth()) {
            // Itera sobre todos los destinos definidos en la enumeración `ReplyDestination`.
            ReplyDestination.entries.forEach { destination ->
                // Crea un `NavigationBarItem` para cada destino.
                NavigationBarItem(
                    selected = destination == selectedDestination, // Marca el ítem como seleccionado si su destino coincide con `selectedDestination`.
                    onClick = { /* TODO: Actualizar la selección de destino aquí */ }, // Callback para cuando se hace clic en un ítem. (Funcionalidad pendiente)
                    icon = {
                        // Muestra el ícono asociado al destino.
                        Icon(
                            imageVector = destination.icon,
                            contentDescription = stringResource(destination.labelRes) // Proporciona una descripción para accesibilidad.
                        )
                    },
                    label = {
                        // Muestra el texto de la etiqueta del destino.
                        Text(text = stringResource(destination.labelRes))
                    },
                )
            }
        }
    }
}

// ------------------- CONTENIDO PRINCIPAL DE LA APP -------------------

@Composable
fun ReplyAppContent(
    replyHomeUIState: ReplyHomeUIState, // El estado actual de la interfaz de usuario de la pantalla de inicio.
    onEmailClick: (Email) -> Unit,      // Callback para manejar el clic en un correo electrónico.
) {
    // Esta función solo muestra el panel de lista de correos.
    ReplyListPane(
        replyHomeUIState = replyHomeUIState,
        onEmailClick = onEmailClick,
    )
}
