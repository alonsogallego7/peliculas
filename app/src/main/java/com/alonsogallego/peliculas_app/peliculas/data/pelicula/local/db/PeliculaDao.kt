package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PeliculaDao {
    @Insert
    fun save(peliculas: List<PeliculaEntity>)

    @Query("SELECT * FROM $TABLE_NAME_PELICULA WHERE id = :peliculaId LIMIT 1")
    fun getPelicula(peliculaId: String): PeliculaEntity?

    @Query("SELECT * FROM $TABLE_NAME_PELICULA")
    fun getPeliculas(): List<PeliculaEntity>
}