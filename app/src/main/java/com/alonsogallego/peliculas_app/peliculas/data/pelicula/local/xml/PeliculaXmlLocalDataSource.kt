package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.xml

import android.content.SharedPreferences
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.PeliculaLocalDataSource
import com.google.gson.Gson

class PeliculaXmlLocalDataSource(private val sharedPref: SharedPreferences) :
    PeliculaLocalDataSource {

    private val gson = Gson()
    private val edit = sharedPref.edit()

    override fun save(peliculaId: String, pelicula: Pelicula) {
        edit.putString(peliculaId, gson.toJson(pelicula, Pelicula::class.java))
        edit.apply()
    }

    override fun getPelicula(peliculaId: String): Pelicula? {
        return sharedPref.getString(peliculaId, null)?.let {
            gson.fromJson(it, Pelicula::class.java)
        }
    }

    override fun getPeliculas(): List<Pelicula> {
        val peliculas = mutableListOf<Pelicula>()
        sharedPref.all.forEach {
            peliculas.add(gson.fromJson(it.key, Pelicula::class.java))
        }
        return peliculas
    }
}