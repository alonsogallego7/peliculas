package com.alonsogallego.peliculas_app.peliculas.domain.repositories

import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

interface PeliculaRepository {
    suspend fun getPelicula(peliculaId: String): Pelicula?
    suspend fun getPeliculas(): List<Pelicula>
}