package com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote

import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

interface PeliculaRemoteDataSource {
    suspend fun getPeliculas(): List<Pelicula>
    suspend fun getPelicula(peliculaId: String): Pelicula?
}