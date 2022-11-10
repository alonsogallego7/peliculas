package com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api

import com.alonsogallego.peliculas_app.peliculas.data.ApiClient
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.PeliculaRemoteDataSource
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

class PeliculaApiRemoteDataSource(private val apiClient: ApiClient) : PeliculaRemoteDataSource {
    override fun getPeliculas(): List<Pelicula> {
        return apiClient.getPeliculas().map {
            it.toDomain()
        }
    }

    override fun getPelicula(peliculaId: String): Pelicula? {
        return apiClient.getPelicula(peliculaId)?.toDomain()
    }
}