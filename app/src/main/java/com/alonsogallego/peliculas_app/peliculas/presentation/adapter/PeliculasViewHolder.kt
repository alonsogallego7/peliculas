package com.alonsogallego.peliculas_app.peliculas.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alonsogallego.peliculas_app.app.extensions.loadUrl
import com.alonsogallego.peliculas_app.databinding.ViewItemPeliculasFeedBinding
import com.alonsogallego.peliculas_app.peliculas.domain.use_cases.GetPeliculasFeedUseCase

class PeliculasViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(pelicula: GetPeliculasFeedUseCase.PeliculaFeed, itemClick: ((String) -> Unit)?) {
        val binding = ViewItemPeliculasFeedBinding.bind(view)
        binding.poster.loadUrl(pelicula.poster)
        binding.title.text = pelicula.title
        binding.genre.text = pelicula.genre
        binding.year.text = pelicula.year
        binding.rating.text = pelicula.rating
        view.setOnClickListener {
            itemClick?.invoke(pelicula.id)
        }
    }

}