package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.mem

import com.alonsogallego.peliculas_app.app.data.mem.MemDataStore
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.PeliculaLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

class PeliculasMemLocalDataSource(private val dataStore: MemDataStore<Pelicula>) :
    PeliculaLocalDataSource {
    override fun save(peliculaId: String, pelicula: Pelicula) {
        dataStore.put(peliculaId, pelicula)
    }

    override fun getPelicula(peliculaId: String): Pelicula? {
        return dataStore.get(peliculaId)
    }

    override fun getPeliculas(): List<Pelicula> {
        val peliculas = mutableListOf<Pelicula>()
        dataStore.getAll().forEach {
            peliculas.add(it.key.toInt(), it.value)
        }
        return peliculas
    }
}