package com.david.study.groovy.model

import com.david.study.groovy.R

class Playlist(
    val id: String,
    val name: String,
    val category: String,
    var image: Int = R.drawable.playlist
)