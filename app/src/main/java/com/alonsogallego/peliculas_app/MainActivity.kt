package com.alonsogallego.peliculas_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alonsogallego.peliculas_app.peliculas.data.ApiClient
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.PeliculaDataRepository
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.xml.PeliculaXmlLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api.PeliculaApiRemoteDataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        /*val peliculaRepository = PeliculaDataRepository(
            PeliculaXmlLocalDataSource(this.getPreferences(MODE_PRIVATE)),
            PeliculaApiRemoteDataSource(ApiClient())
        )**/

        val peliculaRemote = PeliculaApiRemoteDataSource(ApiClient())

        Log.d("@dev", "Peliculas: ${peliculaRemote.getPeliculas()}")
        Log.d("@dev", "Pelicula: ${peliculaRemote.getPelicula("avenger-endgame")}")
    }
}