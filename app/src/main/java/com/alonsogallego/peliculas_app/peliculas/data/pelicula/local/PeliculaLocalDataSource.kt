package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local

import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

interface PeliculaLocalDataSource {
    fun save(peliculaId: String, pelicula: Pelicula)
    fun get(peliculaId: String): Pelicula?
    fun getAll(): List<Pelicula>
}