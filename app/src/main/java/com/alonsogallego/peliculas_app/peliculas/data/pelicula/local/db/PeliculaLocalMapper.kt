package com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.db

import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

fun PeliculaEntity.toDomain() = Pelicula(
    this.id,
    this.title,
    this.plot,
    this.genre,
    this.rating,
    this.year,
    this.poster
)

fun Pelicula.toEntity() = PeliculaEntity(
    this.id,
    this.title,
    this.plot,
    this.genre,
    this.rating,
    this.year,
    this.poster
)