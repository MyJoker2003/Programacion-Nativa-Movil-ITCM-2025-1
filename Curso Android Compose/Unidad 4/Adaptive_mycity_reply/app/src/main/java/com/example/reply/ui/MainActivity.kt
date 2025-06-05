

package com.example.reply.ui
// Importa clases necesarias del sistema operativo Android y Jetpack Compose
import android.os.Build // Proporciona información sobre la versión del sistema operativo
import android.os.Bundle // Contenedor para pasar datos entre componentes de Android

// Importa clases para actividades con Jetpack Compose
import androidx.activity.ComponentActivity // Actividad base para Compose
import androidx.activity.compose.setContent // Permite establecer contenido Compose en una actividad
import androidx.activity.enableEdgeToEdge // Habilita el diseño de borde a borde (sin barras visibles)
import androidx.activity.viewModels // Permite obtener ViewModels vinculados al ciclo de vida

// Importa funciones y anotaciones de Compose
import androidx.compose.runtime.Composable // Marca funciones que generan UI con Compose
import androidx.compose.runtime.getValue // Permite desestructurar valores de estados con 'by'
import androidx.compose.ui.tooling.preview.Preview // Permite crear vistas previas de componentes Compose

// Importa extensiones de Compose para trabajar con LiveData o StateFlow
import androidx.lifecycle.compose.collectAsStateWithLifecycle // Observa flujos con el ciclo de vida de Compose

// Importa datos simulados (falsos) para mostrar correos electrónicos
import com.example.reply.data.local.LocalEmailsDataProvider

// Importa el tema de la aplicación personalizado
import com.example.reply.ui.theme.ReplyTheme

/**
 * Actividad principal de la aplicación Reply.
 * Esta actividad es el punto de entrada de la interfaz de usuario basada en Jetpack Compose.
 */
class MainActivity : ComponentActivity() {

    // Instancia del ViewModel asociada al ciclo de vida de la actividad.
    // Permite que la UI observe y reaccione a los cambios de estado de forma reactiva.
    private val viewModel: ReplyHomeViewModel by viewModels()

    /**
     * Método de callback que se invoca cuando la actividad es creada por primera vez.
     * Aquí se inicializa la interfaz de usuario y se configuran los ajustes iniciales de la ventana.
     *
     * @param savedInstanceState Un [Bundle] que contiene el estado de la actividad guardado previamente,
     * o `null` si la actividad se está creando por primera vez.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita el modo de pantalla completa (edge-to-edge), permitiendo que el contenido
        // se dibuje detrás de las barras del sistema (barra de estado y barra de navegación).
        enableEdgeToEdge()

        // Verifica la versión del SDK de Android para aplicar ajustes específicos.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Desactiva la aplicación de un contraste forzado en la barra de navegación en Android 10 (Q) o superior,
            // lo que evita que su color cambie automáticamente en ciertos escenarios.
            window.isNavigationBarContrastEnforced = false
        }

        // Establece el contenido de la interfaz de usuario utilizando Jetpack Compose.
        setContent {
            // Aplica el tema visual definido en `ReplyTheme` a toda la jerarquía de la UI.
            ReplyTheme {
                // Recopila el estado de la UI del ViewModel como un State de Compose.
                // `collectAsStateWithLifecycle` asegura que la recopilación se detenga
                // cuando el componente no esté en un estado de ciclo de vida activo, optimizando el rendimiento.
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                // Función Composable principal que construye la interfaz de usuario de la aplicación Reply.
                ReplyApp(
                    replyHomeUIState = uiState, // Pasa el estado actual de la UI a la aplicación.
                    onEmailClick = viewModel::setSelectedEmail // Proporciona un callback para manejar clics en los correos electrónicos,
                    // actualizando el correo seleccionado en el ViewModel.
                )
            }
        }
    }
}
// ---------- VISTAS PREVIAS (Previews) ----------

// Vista previa de la aplicación en tamaño de teléfono con fondo visible
@Preview(showBackground = true)
@Composable
fun ReplyAppPreview() {
    // Aplica el tema de la aplicación para la vista previa.
    ReplyTheme {
        // Renderiza la [ReplyApp] con datos de correo electrónico de prueba.
        ReplyApp(
            replyHomeUIState = ReplyHomeUIState(
                emails = LocalEmailsDataProvider.allEmails // Utiliza todos los correos simulados como estado inicial.
            ),
            onEmailClick = {} // Se proporciona una lambda vacía ya que no se necesita funcionalidad de clic en la vista previa.
        )
    }
}

// Vista previa para dispositivos tipo tablet (700dp de ancho)
@Preview(showBackground = true, widthDp = 700)
@Composable
fun ReplyAppPreviewTablet() {
    ReplyTheme {
        ReplyApp(
            replyHomeUIState = ReplyHomeUIState(
                emails = LocalEmailsDataProvider.allEmails
            ),
            onEmailClick = {}
        )
    }
}

// Vista previa para escritorio o pantallas grandes (1000dp de ancho)
@Preview(showBackground = true, widthDp = 1000)
@Composable
fun ReplyAppPreviewDesktop() {
    ReplyTheme {
        ReplyApp(
            replyHomeUIState = ReplyHomeUIState(
                emails = LocalEmailsDataProvider.allEmails
            ),
            onEmailClick = {}
        )
    }
}


