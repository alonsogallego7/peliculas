package com.alonsogallego.peliculas_app.peliculas.domain.repositories

import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

interface PeliculaRepository {
    fun getPelicula(peliculaId: String): Pelicula?
    fun getPeliculas(): List<Pelicula>
}