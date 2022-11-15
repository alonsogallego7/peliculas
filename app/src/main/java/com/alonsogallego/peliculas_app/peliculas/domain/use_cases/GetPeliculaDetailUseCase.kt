package com.alonsogallego.peliculas_app.peliculas.domain.use_cases

import com.alonsogallego.peliculas_app.peliculas.domain.repositories.PeliculaRepository

class GetPeliculaDetailUseCase(private val peliculaRepository: PeliculaRepository) {
    suspend fun execute(peliculaId: String): PeliculaDetail {
        val pelicula = peliculaRepository.getPelicula(peliculaId)!!

        return PeliculaDetail(
            pelicula.id,
            pelicula.title,
            pelicula.plot,
            pelicula.genre,
            pelicula.rating,
            pelicula.year,
            pelicula.poster
        )
    }

    data class PeliculaDetail(
        val id: String,
        val title: String,
        val plot: String,
        val genre: String,
        val rating: String,
        val year: String,
        val poster: String
    )
}