/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * [Affirmation] is the data class to represent the Affirmation text and imageResourceId
 * @property stringResourceId El ID del recurso de cadena (R.string.name) que contiene el texto de la afirmación.
 * @property imageResourceId El ID del recurso de imagen (R.drawable.name) que acompaña a la afirmación.
 */
data class Affirmation(
    @StringRes val stringResourceId: Int, // ID del recurso de cadena para el texto de la afirmación.
    @DrawableRes val imageResourceId: Int // ID del recurso de imagen para la imagen de la afirmación.
)