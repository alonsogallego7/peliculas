package com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.db

import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.PeliculaRemoteDataSource
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class PeliculaDbRemoteDataSource : PeliculaRemoteDataSource {
    override suspend fun getPeliculas(): List<Pelicula> {
        val peliculas = mutableListOf<Pelicula>()
        val dbRemote = Firebase
            .database
            .reference
        val snapshots = dbRemote.get().await()
        snapshots.children.map {
            it.getValue(PeliculaDbRemoteModel::class.java)!!.toDomain()
        }
        return peliculas
    }

    override suspend fun getPelicula(peliculaId: String): Pelicula? {
        val dbRemote = Firebase
            .database
            .reference
            .child(peliculaId)
        val snapshots = dbRemote.get().await()
        return snapshots.getValue(PeliculaDbRemoteModel::class.java)?.toDomain()
    }

}