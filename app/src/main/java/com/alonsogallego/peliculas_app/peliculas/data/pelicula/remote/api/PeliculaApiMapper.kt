package com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api

import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

fun PeliculaApiModel.toDomain() = Pelicula(
    this.id,
    this.title,
    this.plot,
    this.genre,
    this.rating.toString(),
    this.year,
    this.poster
)