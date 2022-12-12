package com.alonsogallego.peliculas_app.peliculas.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.alonsogallego.peliculas_app.app.extensions.loadUrl
import com.alonsogallego.peliculas_app.databinding.FragmentPeliculasDetailBinding
import com.alonsogallego.peliculas_app.peliculas.domain.use_cases.GetPeliculaDetailUseCase
import com.faltenreich.skeletonlayout.Skeleton

class PeliculasDetailFragment: Fragment() {

    private var viewModel: PeliculasDetailViewModel? = null
    private var binding: FragmentPeliculasDetailBinding? = null
    private var skeleton: Skeleton? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeliculasDetailBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = PeliculasFactory().getPeliculaDetailViewModel(
            requireContext()
        )
        setupObservers()
        viewModel?.loadPelicula(getPeliculaId())
    }

    private fun setupView() {
        binding?.apply {

            skeleton = skeletonDetail
        }
    }

    private fun bind(model: GetPeliculaDetailUseCase.PeliculaDetail) {
        binding?.apply {
            title.text = model.title
            genre.text = model.genre
            rating.text = model.rating
            year.text = model.year
            plot.text = model.plot
            poster.loadUrl(model.poster)
        }
    }

    private fun setupObservers() {
        val peliculaFeedSubscriber =
            Observer<PeliculasDetailViewModel.PeliculaDetailUiState> { uiState ->
                if (uiState.isLoading) {
                    skeleton?.showSkeleton()
                } else {
                    skeleton?.showOriginal()
                    uiState.peliculasDetail?.let {
                        bind(it)
                    }
                }
            }

        viewModel?.peliculaDetailPublisher?.observe(viewLifecycleOwner, peliculaFeedSubscriber)
    }

    private fun getPeliculaId(): String {
        return arguments?.let {
            PeliculasDetailFragmentArgs.fromBundle(it).peliculaId
        } ?: run {
            ""
        }
    }
}