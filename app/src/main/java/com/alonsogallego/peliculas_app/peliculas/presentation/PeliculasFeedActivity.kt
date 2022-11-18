package com.alonsogallego.peliculas_app.peliculas.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alonsogallego.peliculas_app.R
import com.alonsogallego.peliculas_app.databinding.ActivityPeliculasFeedBinding
import com.alonsogallego.peliculas_app.peliculas.data.ApiClient
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.PeliculaDataRepository
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.xml.PeliculaXmlLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api.PeliculaApiRemoteDataSource
import kotlin.concurrent.thread

class PeliculasFeedActivity : AppCompatActivity() {
    private var binding: ActivityPeliculasFeedBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        binding = ActivityPeliculasFeedBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }
}