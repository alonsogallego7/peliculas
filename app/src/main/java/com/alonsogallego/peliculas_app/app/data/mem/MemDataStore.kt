package com.alonsogallego.peliculas_app.app.data.mem

class MemDataStore<M> {

    private val dataStore = mutableMapOf<String, M>()

    fun put(id: String, model: M) {
        dataStore.put(id, model)
    }

    fun get(id: String) = dataStore[id]

    fun getAll() = dataStore
}