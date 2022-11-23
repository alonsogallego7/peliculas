package com.alonsogallego.peliculas_app.peliculas.data

import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api.PeliculaApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val baseEndPoints: String = "https://movies-and-shows-api.cyclic.app/"

    private val apiServices: ApiServices

    init {
        apiServices = buildApiEndPoints()
    }

    fun createRetrofitClient() = Retrofit.Builder()
        .baseUrl(baseEndPoints)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildApiEndPoints() = createRetrofitClient().create(ApiServices::class.java)

    fun getPeliculas(): List<PeliculaApiModel> {
        val peliculas = apiServices.getPeliculas()
        val response = peliculas.execute()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

    fun getPelicula(peliculaId: String): PeliculaApiModel? {
        val call = apiServices.getPelicula(peliculaId).execute()
        return call.body()
    }
}