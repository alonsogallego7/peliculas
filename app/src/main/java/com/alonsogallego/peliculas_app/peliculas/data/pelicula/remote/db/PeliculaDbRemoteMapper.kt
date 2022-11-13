package com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.db

import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api.toDomain
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula

fun PeliculaDbRemoteModel.toDomain() = Pelicula(
    this.id,
    this.title,
    this.plot,
    this.genre,
    this.rating,
    this.year,
    this.poster
)