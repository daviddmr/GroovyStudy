package com.david.study.groovy.interfaces

import com.david.study.groovy.model.Playlist

interface PlaylistApi {
    suspend fun fetchAllPlaylists(): List<Playlist> {
        TODO("Not implemented yet")
    }
}
