package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.xml

import android.content.SharedPreferences
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.PeliculaLocalDataSource
import com.google.gson.Gson

class PeliculaXmlLocalDataSource (private val sharedPref: SharedPreferences):
    PeliculaLocalDataSource {

    private val gson = Gson()
    private val edit = sharedPref.edit()

    override fun save(peliculaId: String, pelicula: Pelicula) {

    }

    override fun get(peliculaId: String): Pelicula? {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Pelicula> {
        TODO("Not yet implemented")
    }
}