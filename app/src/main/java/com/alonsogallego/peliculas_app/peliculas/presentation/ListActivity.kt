package com.alonsogallego.peliculas_app.peliculas.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alonsogallego.peliculas_app.R
import com.alonsogallego.peliculas_app.peliculas.data.ApiClient
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.PeliculaDataRepository
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.xml.PeliculaXmlLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api.PeliculaApiRemoteDataSource

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        init()
    }

    private fun init() {
        val peliculaRepository = PeliculaDataRepository(
            PeliculaXmlLocalDataSource(this.getPreferences(MODE_PRIVATE)),
            PeliculaApiRemoteDataSource(ApiClient())
        )

        Log.d("@dev", "Peliculas: ${peliculaRepository.getPeliculas()}")
        Log.d("@dev", "Pelicula: ${peliculaRepository.getPelicula("avenger-endgame")}")
    }
}