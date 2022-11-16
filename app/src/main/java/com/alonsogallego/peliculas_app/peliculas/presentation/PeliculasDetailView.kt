package com.alonsogallego.peliculas_app.peliculas.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogallego.peliculas_app.peliculas.domain.use_cases.GetPeliculaDetailUseCase
import com.alonsogallego.peliculas_app.peliculas.domain.use_cases.GetPeliculasFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeliculasDetailView(private val getPeliculaDetail: GetPeliculaDetailUseCase): ViewModel() {

    val peliculaDetailPublisher: MutableLiveData<PeliculaDetailUiState> by lazy {
        MutableLiveData<PeliculaDetailUiState>()
    }

    fun loadPelicula(peliculaId: String) {
        peliculaDetailPublisher.postValue(PeliculaDetailUiState(true))

        viewModelScope.launch(Dispatchers.IO) {
            val pelicula = getPeliculaDetail.execute(peliculaId)
            peliculaDetailPublisher.postValue(PeliculaDetailUiState(true, pelicula))
        }
    }

    data class PeliculaDetailUiState(
        val isLoading: Boolean = false,
        val peliculasFeed: GetPeliculaDetailUseCase.PeliculaDetail? = null
    )

}