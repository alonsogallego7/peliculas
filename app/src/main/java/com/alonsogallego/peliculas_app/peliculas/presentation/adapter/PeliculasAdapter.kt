package com.alonsogallego.peliculas_app.peliculas.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsogallego.peliculas_app.R
import com.alonsogallego.peliculas_app.peliculas.domain.use_cases.GetPeliculasFeedUseCase

class PeliculasAdapter: RecyclerView.Adapter<PeliculasViewHolder>() {

    private val dataItems = mutableListOf<GetPeliculasFeedUseCase.PeliculaFeed>()
    private var itemClick: ((String) -> Unit)? = null

    fun setOnClickItem(itemClick: (String) -> Unit) {
        this.itemClick = itemClick
    }

    fun setDataItems(peliculas: List<GetPeliculasFeedUseCase.PeliculaFeed>) {
        dataItems.clear()
        dataItems.addAll(peliculas)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_peliculas_feed, parent, false)
        return PeliculasViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        holder.bind(dataItems[position], itemClick)
    }

    override fun getItemCount(): Int = dataItems.size
}