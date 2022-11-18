package com.alonsogallego.peliculas_app.peliculas.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alonsogallego.peliculas_app.databinding.ActivityPeliculasFeedBinding

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