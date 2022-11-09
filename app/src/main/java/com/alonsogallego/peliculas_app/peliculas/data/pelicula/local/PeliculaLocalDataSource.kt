package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local

import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

interface PeliculaLocalDataSource {
    fun save(peliculaId: String, pelicula: Pelicula)
    fun getPelicula(peliculaId: String): Pelicula?
    fun getPeliculas(): List<Pelicula>
}