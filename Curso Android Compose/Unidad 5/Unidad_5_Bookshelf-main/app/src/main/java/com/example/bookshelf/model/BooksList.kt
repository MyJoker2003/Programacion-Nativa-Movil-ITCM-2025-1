package com.example.bookshelf.model
import kotlinx.serialization.Serializable

// Clase de datos serializable que representa la lista de libros recibida de la API
@Serializable
data class BooksList(
    val items: List<Item> // Lista de elementos (libros)
)

// Clase de datos serializable que representa cada libro individual
@Serializable
data class Item(
    val id: String,            // Identificador único del libro
    val volumeInfo: VolumeInfo // Información detallada del libro
)

// Clase de datos serializable con información principal del libro
@Serializable
data class VolumeInfo(
    val title: String,           // Título del libro
    val authors: List<String>,   // Lista de autores del libro
    val imageLinks: ImageLinks   // Enlaces a imágenes relacionadas con el libro
)

// Clase de datos serializable que contiene el enlace a la imagen miniatura
@Serializable
data class ImageLinks(
    val thumbnail: String // URL de la imagen miniatura del libro
)
