package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.db

import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.PeliculaLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

class PeliculaDbLocalDataSource(private val dao: PeliculaDao) : PeliculaLocalDataSource {
    override fun save(peliculas: List<Pelicula>) {
        peliculas.forEach {
            dao.save(it.toEntity())
        }
    }

    override fun getPelicula(peliculaId: String): Pelicula? {
        return dao.getPelicula(peliculaId)?.toDomain()
    }

    override fun getPeliculas(): List<Pelicula> {
        val peliculas = mutableListOf<Pelicula>()
        dao.getPeliculas().forEach {
            peliculas.add(it.toDomain())
        }
        return peliculas
    }
}