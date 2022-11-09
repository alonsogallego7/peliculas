package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.db

import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.PeliculaLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

class PeliculaDbLocalDataSource(private val dao: PeliculaDao) : PeliculaLocalDataSource {
    override fun save(peliculas: List<Pelicula>) {
        dao.save(peliculas)
    }

    override fun getPelicula(peliculaId: String): Pelicula? {
        TODO("Not yet implemented")
    }

    override fun getPeliculas(): List<Pelicula> {
        TODO("Not yet implemented")
    }
}