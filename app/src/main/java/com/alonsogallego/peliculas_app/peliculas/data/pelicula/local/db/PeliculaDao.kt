package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PeliculaDao {
    @Insert
    fun save(peliculaId: Int)

    @Query
    fun getPelicula(peliculaId: Int)
}