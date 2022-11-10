package com.alonsogallego.peliculas_app.peliculas.data

import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api.PeliculaApiModel
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("movies")
    fun getPeliculas(): Call<List<PeliculaApiModel>>

    @GET("movies/{peliculaId}")
    fun getPelicula(@Path("peliculaId") peliculaId: String): Call<PeliculaApiModel>
}