package com.david.study.groovy.model

import com.david.study.groovy.R

class Playlist(
    val id: String,
    val name: String,
    val category: String,
    val image: Int = R.drawable.ic_launcher_foreground
)