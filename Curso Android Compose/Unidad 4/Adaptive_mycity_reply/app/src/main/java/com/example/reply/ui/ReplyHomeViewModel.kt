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
// Importa la clase base para ViewModels de Android
import androidx.lifecycle.ViewModel

// Importa el scope para lanzar corrutinas dentro de un ViewModel
import androidx.lifecycle.viewModelScope

// Importa el modelo de datos Email
import com.example.reply.data.Email

// Importa interfaces y clases concretas del repositorio de correos
import com.example.reply.data.EmailsRepository
import com.example.reply.data.EmailsRepositoryImpl

// Importa clases de flujo (Flow) para manejar estados reactivos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch

// Importa funciones para trabajar con corrutinas
import kotlinx.coroutines.launch

// --------------------- VIEWMODEL PRINCIPAL ---------------------

/**
 * [ViewModel] que gestiona y provee el estado de la UI para la pantalla principal de la aplicación Reply.
 * Se encarga de la lógica de negocio y de la preparación de los datos para la interfaz de usuario,
 * desacoplando la lógica de la vista.
 *
 * @property emailsRepository Una implementación de [EmailsRepository] para obtener y gestionar los datos de correos electrónicos.
 * El valor por defecto es [EmailsRepositoryImpl].
 */
class ReplyHomeViewModel(
    private val emailsRepository: EmailsRepository = EmailsRepositoryImpl()
) : ViewModel() {

    // Estado interno mutable de la UI. Solo puede ser modificado dentro del ViewModel.
    // Inicialmente, se establece un estado de carga (`loading = true`).
    private val _uiState = MutableStateFlow(ReplyHomeUIState(loading = true))

    /**
     * [StateFlow] público e inmutable que expone el estado de la UI a los componentes Compose.
     * La UI observará este flujo para reaccionar a los cambios de estado.
     */
    val uiState: StateFlow<ReplyHomeUIState> = _uiState

    /**
     * Bloque de inicialización del ViewModel.
     * Cuando se crea una instancia de [ReplyHomeViewModel], se inicia la observación de los correos.
     */
    init {
        observeEmails()
    }

    /**
     * Inicia la observación de los correos electrónicos desde el repositorio.
     * Esta función lanza una corrutina en el [viewModelScope] para recolectar los datos
     * del flujo de correos emitido por [emailsRepository.getAllEmails].
     *
     * Si ocurre un error durante la recolección, el estado de la UI se actualiza con un mensaje de error.
     * Si la recolección es exitosa, el estado de la UI se actualiza con la lista de correos recibidos.
     */
    private fun observeEmails() {
        viewModelScope.launch {
            // Recolecta el flujo de todos los correos electrónicos del repositorio.
            emailsRepository.getAllEmails()
                // Captura cualquier excepción que ocurra en el flujo y actualiza el estado de la UI con el error.
                .catch { ex ->
                    _uiState.value = ReplyHomeUIState(error = ex.message)
                }
                // Recolecta los correos emitidos por el flujo y actualiza el estado de la UI con la lista de correos.
                .collect { emails ->
                    _uiState.value = ReplyHomeUIState(emails = emails)
                }
        }
    }

    /**
     * Función para establecer un correo electrónico como seleccionado en la UI.
     *
     * @param email El objeto [Email] que ha sido seleccionado por el usuario.
     * Esta función contendrá la lógica para actualizar el estado de la UI
     * con el correo electrónico seleccionado, por ejemplo, para mostrar sus detalles.
     */
    fun setSelectedEmail(email: Email) {
        // TODO: Implementar la lógica para actualizar el estado de la UI con el correo electrónico seleccionado.
        // Por ejemplo: _uiState.update { it.copy(selectedEmail = email) }
    }
}

// --------------------- ESTADO DE LA UI ---------------------

/**
 * `data class` que representa el estado completo de la interfaz de usuario para la pantalla principal.
 * Este estado es inmutable y se utiliza para renderizar la UI en un momento dado.
 *
 * @property emails La lista de correos electrónicos a mostrar. Por defecto, es una lista vacía.
 * @property loading Booleano que indica si la información está cargando. `true` si hay una operación en progreso, `false` en caso contrario.
 * @property error Un mensaje de error opcional (`String?`) en caso de que ocurra un problema al cargar los datos. `null` si no hay error.
 */
data class ReplyHomeUIState(
    val emails: List<Email> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)

