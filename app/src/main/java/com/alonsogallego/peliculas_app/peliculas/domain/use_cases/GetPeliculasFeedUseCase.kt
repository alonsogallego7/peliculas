package com.alonsogallego.peliculas_app.peliculas.domain.use_cases

import com.alonsogallego.peliculas_app.peliculas.domain.repositories.PeliculaRepository

class GetPeliculasFeedUseCase(private val peliculaRepository: PeliculaRepository) {
    suspend fun execute(): List<PeliculaFeed> {
        val peliculas = peliculaRepository.getPeliculas()

        return peliculas.map {
            PeliculaFeed(
                it.id,
                it.title,
                it.genre,
                it.rating,
                it.year,
                it.poster
            )
        }
    }

    data class PeliculaFeed(
        val id: String,
        val title: String,
        val genre: String,
        val rating: String,
        val year: String,
        val poster: String
    )
}