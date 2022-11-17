package com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api

import com.alonsogallego.peliculas_app.peliculas.data.ApiClient
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.PeliculaRemoteDataSource
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

class PeliculaApiRemoteDataSource(private val apiClient: ApiClient) : PeliculaRemoteDataSource {
    override suspend fun getPeliculas(): List<Pelicula> {
        val peliculas = mutableListOf<Pelicula>()
        apiClient.getPeliculas().map {
            peliculas.add(it.toDomain())
        }
        return peliculas
    }

    override suspend fun getPelicula(peliculaId: String): Pelicula? {
        return apiClient.getPelicula(peliculaId)?.toDomain()
    }
}