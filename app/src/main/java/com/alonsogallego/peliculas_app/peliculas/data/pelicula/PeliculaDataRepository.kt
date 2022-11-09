package com.alonsogallego.peliculas_app.peliculas.data.pelicula

import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.PeliculaLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula
import com.alonsogallego.peliculas_app.peliculas.domain.repositories.PeliculaRepository

class PeliculaDataRepository(val localSource: PeliculaLocalDataSource) : PeliculaRepository {
    override fun getPelicula(peliculaId: String): Pelicula? {
        var pelicula = localSource.getPelicula(peliculaId)
        return pelicula
    }

    override fun getPeliculas(): List<Pelicula> {
        var peliculas = localSource.getPeliculas()
        return peliculas
    }

}