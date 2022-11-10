package com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api

import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

fun PeliculaApiModel.toDomain() = Pelicula(
    this.id,
    this.title,
    this.pilot,
    this.genre,
    this.rating,
    this.year,
    this.poster
)