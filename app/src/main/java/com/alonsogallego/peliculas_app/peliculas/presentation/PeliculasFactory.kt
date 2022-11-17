package com.alonsogallego.peliculas_app.peliculas.presentation

import android.content.Context
import androidx.room.Room
import com.alonsogallego.peliculas_app.app.data.db.AppDataBase
import com.alonsogallego.peliculas_app.peliculas.data.ApiClient
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.PeliculaDataRepository
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.db.PeliculaDbLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api.PeliculaApiRemoteDataSource
import com.alonsogallego.peliculas_app.peliculas.domain.repositories.PeliculaRepository
import com.alonsogallego.peliculas_app.peliculas.domain.use_cases.GetPeliculaDetailUseCase
import com.alonsogallego.peliculas_app.peliculas.domain.use_cases.GetPeliculasFeedUseCase

class PeliculasFactory {
    private fun getPeliculasUseCase(context: Context): GetPeliculasFeedUseCase {
        return GetPeliculasFeedUseCase(
            getPeliculasRepository(context)
        )
    }

    private fun getPeliculaDetailUseCase(context: Context): GetPeliculaDetailUseCase {
        return GetPeliculaDetailUseCase(
            getPeliculasRepository(context)
        )
    }

    private fun getPeliculasRepository(context: Context): PeliculaRepository {
        return PeliculaDataRepository(
            PeliculaDbLocalDataSource(
                DataBaseSingleton.getInstance(context).peliculaDao()
            ),
            PeliculaApiRemoteDataSource(getApiClient())
        )
    }

    object DataBaseSingleton {
        private var db: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java, "db-peliculas"
                ).build()
            }
            return db!!
        }
    }

    private fun getApiClient() = ApiClient()
}