package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.db

import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

fun PeliculaEntity.toDomain() = Pelicula(
    this.id,
    this.title,
    this.pilot,
    this.genre,
    this.rating,
    this.year,
    this.poster,
)