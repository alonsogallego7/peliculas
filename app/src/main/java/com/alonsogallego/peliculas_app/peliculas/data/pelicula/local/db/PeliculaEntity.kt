package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PeliculaEntity(
    @PrimaryKey val id: String,
    @ColumnInfo val title: String?,
    @ColumnInfo val pilot: String?,
    @ColumnInfo val genre: String?,
    @ColumnInfo val rating: String?,
    @ColumnInfo val year: String?,
    @ColumnInfo val poster: String?
)