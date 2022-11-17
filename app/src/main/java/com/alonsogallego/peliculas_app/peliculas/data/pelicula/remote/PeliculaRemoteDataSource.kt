package com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote

import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

interface PeliculaRemoteDataSource {
    fun getPeliculas(): List<Pelicula>
    fun getPelicula(peliculaId: String): Pelicula?
}