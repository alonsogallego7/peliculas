package com.alonsogallego.peliculas_app.peliculas.data.pelicula

import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.PeliculaLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.xml.PeliculaXmlLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.PeliculaRemoteDataSource
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api.PeliculaApiRemoteDataSource
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula
import com.alonsogallego.peliculas_app.peliculas.domain.repositories.PeliculaRepository

class PeliculaDataRepository(
    val localSource: PeliculaLocalDataSource,
    val remoteSource: PeliculaRemoteDataSource
) : PeliculaRepository {
    override suspend fun getPelicula(peliculaId: String): Pelicula? {
        var pelicula = localSource.getPelicula(peliculaId)
        if (pelicula == null) {
            pelicula = remoteSource.getPelicula(peliculaId)
        }
        return pelicula
    }

    override suspend fun getPeliculas(): List<Pelicula> {
        var peliculas = localSource.getPeliculas()
        if (peliculas.isEmpty()) {
            peliculas = remoteSource.getPeliculas()
            if (peliculas.isNotEmpty()) {
                localSource.save(peliculas)
            }
        }
        return peliculas
    }

}