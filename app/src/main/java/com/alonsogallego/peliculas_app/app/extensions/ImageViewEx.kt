package com.alonsogallego.peliculas_app.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(urlImage: String) {
    Glide.with(this).load(urlImage).into(this)
}