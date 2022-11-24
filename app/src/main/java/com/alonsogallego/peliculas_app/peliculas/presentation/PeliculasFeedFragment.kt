package com.alonsogallego.peliculas_app.peliculas.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsogallego.peliculas_app.R
import com.alonsogallego.peliculas_app.databinding.FragmentPeliculasFeedBinding
import com.alonsogallego.peliculas_app.peliculas.presentation.adapter.PeliculasAdapter
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton

class PeliculasFeedFragment: Fragment() {

    private var skeleton: Skeleton? = null

    private var binding: FragmentPeliculasFeedBinding? = null
    private val peliculasAdapter = PeliculasAdapter()
    private val viewModel by lazy {
        PeliculasFactory().getPeliculasViewModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeliculasFeedBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadPeliculas()
    }

    private fun setupView() {
        binding?.apply {
            listPeliculas.apply {
                adapter = peliculasAdapter
                layoutManager =
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                    )

                skeleton = applySkeleton(R.layout.view_item_peliculas_feed, 5)
            }

        }
    }

    private fun setupObservers() {
        val peliculaFeedSubscriber =
            Observer<PeliculasFeedViewModel.PeliculasUiState> { uiState ->
                if (uiState.isLoading) {
                    skeleton?.showSkeleton()
                } else {
                    skeleton?.showOriginal()
                    peliculasAdapter.setOnClickItem { peliculaId ->
                        navigateToPeliculaDetail(peliculaId)
                    }
                    peliculasAdapter.setDataItems(uiState.peliculasFeed)
                }
            }
        viewModel.peliculasFeedPublisher.observe(viewLifecycleOwner, peliculaFeedSubscriber)
    }

    private fun navigateToPeliculaDetail(peliculaId: String) {
        findNavController().navigate(
            PeliculasFeedFragmentDirections.actionPeliculasfeedToPeliculasdetail(peliculaId)
        )
    }
}