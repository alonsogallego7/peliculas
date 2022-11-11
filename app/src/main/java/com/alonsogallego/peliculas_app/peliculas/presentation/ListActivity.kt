package com.alonsogallego.peliculas_app.peliculas.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.alonsogallego.peliculas_app.R
import com.alonsogallego.peliculas_app.app.data.db.AppDataBase
import com.alonsogallego.peliculas_app.app.data.mem.MemDataStore
import com.alonsogallego.peliculas_app.peliculas.data.ApiClient
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.PeliculaDataRepository
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.db.PeliculaDbLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.mem.PeliculasMemLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.local.xml.PeliculaXmlLocalDataSource
import com.alonsogallego.peliculas_app.peliculas.data.pelicula.remote.api.PeliculaApiRemoteDataSource
import com.alonsogallego.peliculas_app.peliculas.domain.models.Pelicula
import kotlin.concurrent.thread

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        init()
    }

    private fun init() {
        val peliculaRepository = PeliculaDataRepository(
            PeliculaXmlLocalDataSource(this.getPreferences(MODE_PRIVATE)),
            PeliculaApiRemoteDataSource(ApiClient())
        )
        thread {
            peliculaRepository.getPeliculas()
            peliculaRepository.getPelicula("avenger-endgame")
        }
    }

    object DataBaseSingleton {
        private var db: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java, "db-peliculas"
                ).build()
            }
            return db!!
        }
    }
}

