package com.alonsogallego.peliculas_app.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.db.PeliculaDao
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

@Database(entities = [Pelicula::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun peliculaDao(): PeliculaDao
}