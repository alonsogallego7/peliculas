package com.alonsogallego.peliculas_app.peliculas.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.alonsogallego.peliculas_app.databinding.FragmentPeliculasDetailBinding
import com.faltenreich.skeletonlayout.Skeleton

class PeliculasDetailFragment: Fragment() {
    private var viewModel: PeliculasDetailViewModel? = null
    private var binding: FragmentPeliculasDetailBinding? = null
    private var skeleton: Skeleton? = null

    private fun setupView() {

    }

    private fun setupObservers() {
        val peliculaFeedSubscriber =
            Observer<PeliculasDetailViewModel.PeliculaDetailUiState> { uiState ->
                if (uiState.isLoading) {
                    skeleton?.showSkeleton()
                } else {
                    skeleton?.showOriginal()
                }
            }
        viewModel?.peliculaDetailPublisher?.observe(viewLifecycleOwner, peliculaFeedSubscriber)
    }

    companion object {
        private val KEY_PELICULA_ID = "key_pelicula_id"

        fun getBundle(peliculaId: String): Bundle {
            val bundle = Bundle()
            bundle.putString(KEY_PELICULA_ID, peliculaId)
            return bundle
        }
    }
}