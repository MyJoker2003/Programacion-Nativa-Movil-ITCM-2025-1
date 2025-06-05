package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

// La clase principal de la actividad de la aplicación.
class MainActivity : ComponentActivity() {
    // Se llama cuando la actividad se crea por primera vez.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama a la implementación de la superclase.
        // Habilita el contenido de borde a borde para una experiencia inmersiva.
        enableEdgeToEdge()
        // Establece el contenido de la UI utilizando Jetpack Compose.
        setContent {
            DiceRollerApp() // Llama a la función Composable principal de la aplicación.
        }
    }
}

// Anotación para previsualizar este Composable en el entorno de diseño de Android Studio.
@Preview(showBackground = true) // Muestra un fondo para la previsualización.
@Composable // Indica que esta función es un Composable.
fun DiceRollerApp(){
    // Aplica el tema definido para la aplicación.
    DiceRollerTheme {
        // Llama al Composable que contiene el botón y la imagen del dado.
        DiceWithButtonAndImage()
    }
}


//Date: 11-04-2025 by Anastasio Salas Juan Carlos
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize() //Ocupa el espacio disponible
    .wrapContentSize(Alignment.Center)){

    /* Se declara una variable de estado 'result' utilizando 'remember' y 'mutableStateOf'.
     * 'result' almacenará el número actual del dado. 'by' es una delegación de propiedades. */
    var result by remember { mutableStateOf(1) }

    //Estado componible, that can trigger a recomposition
    /*Se crea una varible cuyo valor depende del estado de la variable
    * result.
    *
    * Esta variable hace referencia a la ruta donde se guardan las
    * imagenes de los dados*/
    val imageResource = when (result) {
        1 -> R.drawable.dice_1 // Si result es 1, usa la imagen dice_1.
        2 -> R.drawable.dice_2 // Si result es 2, usa la imagen dice_2.
        3 -> R.drawable.dice_3 // Si result es 3, usa la imagen dice_3.
        4 -> R.drawable.dice_4 // Si result es 4, usa la imagen dice_4.
        5 -> R.drawable.dice_5 // Si result es 5, usa la imagen dice_5.
        else -> R.drawable.dice_6 // Si result es cualquier otro valor (es decir, 6), usa la imagen dice_6.
    }

    // Composable Column para organizar los elementos verticalmente.
    Column (
        modifier = modifier, // Aplica el modificador pasado como argumento a la columna.
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente los hijos de la columna.
    ) {
        // Composable Image para mostrar la imagen del dado.
        Image(
            painterResource(imageResource), // Carga la imagen del recurso determinado por 'imageResource'.
            contentDescription = result.toString() // Establece la descripción del contenido para accesibilidad (el número del dado).
        )
        // Un Spacer para agregar un espacio vertical entre la imagen y el botón.
        Spacer(modifier = Modifier.height(16.dp)) // Define una altura de 16 unidades de densidad de píxeles para el espacio.
        // Un Composable Button.
        Button(onClick = {
            // Cuando se hace clic en el botón, actualiza 'result' con un número aleatorio entre 1 y 6.
            // Esto provoca una recomposición y actualiza la imagen del dado.
            result = (1..6).random()
            /*se asigna un valor aleatoria en un rango de 1 al 6*/
        }) {
            // Muestra el texto del botón, cargado desde los recursos de cadena.
            Text(text = stringResource(R.string.roll)) // "roll" es el texto del botón, definido en strings.xml.
        }
    }
}