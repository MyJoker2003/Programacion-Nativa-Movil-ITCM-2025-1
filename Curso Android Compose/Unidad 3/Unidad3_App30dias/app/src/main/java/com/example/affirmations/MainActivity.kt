
package com.example.affirmations
// Importa la clase Bundle para manejar datos cuando se crea una Activity
import android.os.Bundle

// Importa ComponentActivity, la base para actividades que usan Jetpack Compose
import androidx.activity.ComponentActivity

// Importa setContent, que define la interfaz de usuario usando funciones Composable
import androidx.activity.compose.setContent

// Importa Image, un Composable para mostrar imágenes
import androidx.compose.foundation.Image

// Importa Column, un layout que coloca elementos de forma vertical
import androidx.compose.foundation.layout.Column

// Hace que un componente llene todo el tamaño disponible (ancho y alto)
import androidx.compose.foundation.layout.fillMaxSize

// Hace que un componente llene todo el ancho disponible
import androidx.compose.foundation.layout.fillMaxWidth

// Define la altura de un componente
import androidx.compose.foundation.layout.height

// Agrega espacio alrededor de un componente
import androidx.compose.foundation.layout.padding

// Importa LazyColumn, un Composable que lista elementos de forma eficiente
import androidx.compose.foundation.lazy.LazyColumn

// items permite iterar sobre una lista dentro de una LazyColumn
import androidx.compose.foundation.lazy.items

// Importa Card de Material3 para crear tarjetas con estilo
import androidx.compose.material3.Card

// Importa MaterialTheme para acceder a los estilos y colores del tema Material 3
import androidx.compose.material3.MaterialTheme

// Surface es un contenedor de fondo que respeta el tema actual
import androidx.compose.material3.Surface

// Composable para mostrar texto en la UI
import androidx.compose.material3.Text

// Anotación para declarar funciones Composable
import androidx.compose.runtime.Composable

// Modificador para aplicar cambios visuales o estructurales a composables
import androidx.compose.ui.Modifier

// Define cómo se ajusta una imagen a su contenedor
import androidx.compose.ui.layout.ContentScale

// Permite acceder al contexto actual (por ejemplo, para obtener strings)
import androidx.compose.ui.platform.LocalContext

// Carga imágenes desde recursos con ID
import androidx.compose.ui.res.painterResource

// Carga cadenas desde recursos con ID
import androidx.compose.ui.res.stringResource

// Habilita la vista previa del Composable en Android Studio
import androidx.compose.ui.tooling.preview.Preview

// Unidad de medida en píxeles independientes de densidad (dp)
import androidx.compose.ui.unit.dp

// Importa la clase Datasource, que carga la lista de afirmaciones
import com.example.affirmations.data.Datasource

// Importa la clase Affirmation, que representa un objeto con texto e imagen
import com.example.affirmations.model.Affirmation

// Importa el tema personalizado para la aplicación
import com.example.affirmations.ui.theme.AffirmationsTheme

/**
 * [MainActivity] es la actividad principal de la aplicación Affirmations.
 * Configura la interfaz de usuario utilizando Jetpack Compose y muestra una lista de afirmaciones.
 */
class MainActivity : ComponentActivity() {
    /**
     * Se llama cuando la actividad es creada por primera vez.
     * Configura la vista de contenido de la actividad usando Jetpack Compose.
     *
     * @param savedInstanceState Si la actividad está siendo recreada después de haber sido destruida,
     * este Bundle contiene los datos que más recientemente se suministraron en [onSaveInstanceState].
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define la interfaz de usuario de la actividad con Jetpack Compose.
        setContent {
            // Aplica el tema Material 3 personalizado para la aplicación.
            AffirmationsTheme {
                // Un contenedor de superficie que utiliza el color de fondo del tema actual.
                Surface(
                    modifier = Modifier.fillMaxSize(), // El contenedor ocupa todo el tamaño disponible en la pantalla.
                    color = MaterialTheme.colorScheme.background // Usa el color de fondo definido en el tema.
                ) {
                    // Llama al Composable principal de la aplicación para construir la UI.
                    AffirmationsApp()
                }
            }
        }
    }
}

/**
 * [AffirmationsApp] es el composable de nivel superior que define la estructura principal de la UI de la aplicación.
 * Carga las afirmaciones desde el [Datasource] y las pasa a la lista para su visualización.
 */
@Composable
fun AffirmationsApp() {
    // Carga la lista de afirmaciones usando la clase Datasource.
    // Pasa esta lista al Composable AffirmationList para mostrarla.
    AffirmationList(
        affirmationList = Datasource().loadAffirmations(),
    )
}

/**
 * [AffirmationList] es un composable que muestra una lista eficiente de [Affirmation] usando [LazyColumn].
 *
 * @param affirmationList La lista de objetos [Affirmation] a mostrar.
 * @param modifier Un [Modifier] para aplicar a este composable.
 */
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    // LazyColumn es un componente de lista de Compose que renderiza solo los elementos visibles,
    // lo que lo hace eficiente para listas largas.
    LazyColumn(modifier = modifier) {
        // Itera sobre cada afirmación en la lista y crea un [AffirmationCard] para cada una.
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation, // Pasa la afirmación individual a la tarjeta.
                modifier = Modifier.padding(8.dp) // Agrega un relleno de 8dp alrededor de cada tarjeta.
            )
        }
    }
}

/**
 * [AffirmationCard] es un composable que muestra una única [Affirmation] dentro de una tarjeta de Material Design.
 * Incluye una imagen y el texto de la afirmación.
 *
 * @param affirmation El objeto [Affirmation] que contiene el texto y la imagen a mostrar.
 * @param modifier Un [Modifier] para aplicar a este composable.
 */
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    // El componente Card de Material Design proporciona un contenedor elevado con esquinas redondeadas.
    Card(modifier = modifier) {
        // Organiza el contenido de la tarjeta verticalmente.
        Column {
            // Muestra la imagen de la afirmación.
            Image(
                painter = painterResource(affirmation.imageResourceId), // Carga la imagen usando su ID de recurso.
                contentDescription = stringResource(affirmation.stringResourceId), // Proporciona una descripción de contenido para accesibilidad.
                modifier = Modifier
                    .fillMaxWidth() // La imagen ocupa todo el ancho disponible.
                    .height(194.dp), // La imagen tiene una altura fija de 194dp.
                contentScale = ContentScale.Crop // La imagen se recorta para llenar los límites del contenedor.
            )
            // Muestra el texto de la afirmación.
            Text(
                // Carga el texto de la afirmación usando su ID de recurso de cadena y el contexto local.
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp), // Agrega un relleno de 16dp alrededor del texto.
                style = MaterialTheme.typography.headlineSmall // Aplica el estilo de texto `headlineSmall` del tema.
            )
        }
    }
}


// Vista previa en Android Studio de una tarjeta de afirmación
/**
 * [AffirmationCardPreview] es un composable para la vista previa de [AffirmationCard] en Android Studio.
 * Muestra cómo se verá una [AffirmationCard] con datos de ejemplo.
 */
@Preview
@Composable
private fun AffirmationCardPreview() {
    // Se muestra una vista previa de AffirmationCard utilizando el primer texto y la primera imagen de recursos.
    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
}
