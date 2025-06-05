package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

/**
 * Clase principal de la actividad de la aplicación.
 * Es el punto de entrada para la UI basada en Jetpack Compose.
 */
class MainActivity : ComponentActivity() {
    /**
     * Se llama cuando la actividad se crea por primera vez.
     * Configura el contenido de la UI utilizando Jetpack Compose.
     *
     * @param savedInstanceState Un Bundle que contiene los datos de la actividad guardados.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la interfaz de usuario de la actividad.
        setContent {
            // Aplica el tema definido para la aplicación.
            ArtSpaceTheme {
                // Llama a la función Composable principal que construye la UI de la galería de arte.
                ArtSpaceApp()
            }
        }
    }
}

/**
 * Función Composable que define la interfaz de usuario principal de la aplicación "Art Space".
 * Muestra una obra de arte y permite navegar entre diferentes obras.
 */
@Composable
fun ArtSpaceApp() {
    // Declara y gestiona el estado del índice de la obra de arte actual.
    // 'remember' asegura que el estado se mantenga a través de las recomposiciones.
    // 'mutableStateOf' crea un objeto de estado observable.
    var index by remember { mutableStateOf(0) }

    // Define una lista de objetos ArtData, que representan las obras de arte disponibles.
    val artworks = listOf(
        ArtData(R.drawable.art1, "La noche estrellada", "Vincent van Gogh", "1889"),
        ArtData(R.drawable.art2, "La joven de la perla", "Johannes Vermeer", "1665"),
        ArtData(R.drawable.art3, "El grito", "Edvard Munch", "1893")
    )

    // Obtiene la obra de arte actual de la lista basándose en el 'index'.
    val current = artworks[index]

    // Contenedor principal de la UI, organizado en una columna.
    Column(
        modifier = Modifier
            .fillMaxSize() // Hace que la columna ocupe todo el espacio disponible.
            .padding(16.dp), // Aplica un padding de 16 dp alrededor de la columna.
        verticalArrangement = Arrangement.Center, // Centra los elementos hijos verticalmente.
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos hijos horizontalmente.
    ) {
        // Tarjeta para mostrar la imagen de la obra de arte con un diseño elevado.
        Card(
            shape = RoundedCornerShape(16.dp), // Establece esquinas redondeadas para la tarjeta.
            elevation = CardDefaults.cardElevation(8.dp), // Agrega una sombra a la tarjeta.
            modifier = Modifier.padding(16.dp) // Añade padding alrededor de la tarjeta.
        ) {
            // Componente de imagen para mostrar la obra de arte.
            Image(
                painter = painterResource(id = current.image), // Carga el recurso de imagen.
                contentDescription = null, // Establece contentDescription como null para elementos decorativos.
                modifier = Modifier
                    .height(300.dp) // Fija la altura de la imagen.
                    .fillMaxWidth() // Hace que la imagen ocupe todo el ancho disponible dentro de su padre.
            )
        }

        // Espaciador vertical para separar la imagen de la información textual.
        Spacer(modifier = Modifier.height(16.dp))

        // Muestra el título de la obra de arte.
        Text(text = current.title, fontSize = 24.sp)

        // Muestra el artista y el año de la obra.
        Text(
            text = "${current.artist} (${current.year})",
            fontSize = 16.sp,
            textAlign = TextAlign.Center // Centra el texto horizontalmente.
        )

        // Espaciador vertical para separar la información textual de los botones de navegación.
        Spacer(modifier = Modifier.height(16.dp))

        // Fila para contener los botones de navegación (Anterior y Siguiente).
        Row {
            // Botón para ir a la obra de arte anterior.
            Button(onClick = {
                // Si el índice actual es 0, salta al último elemento de la lista; de lo contrario, decrementa el índice.
                index = if (index == 0) artworks.lastIndex else index - 1
            }) {
                Text("Anterior")
            }

            // Espaciador horizontal entre los botones.
            Spacer(modifier = Modifier.width(16.dp))

            // Botón para ir a la siguiente obra de arte.
            Button(onClick = {
                // Incrementa el índice y usa el operador módulo (%) para volver a 0 si se llega al final de la lista.
                index = (index + 1) % artworks.size
            }) {
                Text("Siguiente")
            }
        }
    }
}

/**
 * Clase de datos que representa una única obra de arte.
 *
 * @property image El ID del recurso drawable de la imagen de la obra de arte.
 * @property title El título de la obra de arte.
 * @property artist El nombre del artista.
 * @property year El año de creación de la obra.
 */
data class ArtData(val image: Int, val title: String, val artist: String, val year: String)