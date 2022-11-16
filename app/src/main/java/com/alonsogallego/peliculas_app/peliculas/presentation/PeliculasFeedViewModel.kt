package com.alonsogallego.peliculas_app.peliculas.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogallego.peliculas_app.peliculas.domain.use_cases.GetPeliculasFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeliculasFeedViewModel(private val getPeliculasFeed: GetPeliculasFeedUseCase): ViewModel() {

    val peliculasFeedPublisher: MutableLiveData<PeliculasUiState> by lazy {
        MutableLiveData<PeliculasUiState>()
    }

    fun loadPeliculas() {
        peliculasFeedPublisher.postValue(PeliculasUiState(true))

        viewModelScope.launch(Dispatchers.IO) {
            val peliculasFeed = getPeliculasFeed.execute()
            peliculasFeedPublisher.postValue(
                PeliculasUiState(
                    false,
                    peliculasFeed
                )
            )
        }
    }

    data class PeliculasUiState(
        val isLoading: Boolean = false,
        val peliculasFeed: List<GetPeliculasFeedUseCase.PeliculaFeed> = emptyList()
    )

}