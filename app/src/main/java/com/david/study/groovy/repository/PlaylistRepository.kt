package com.david.study.groovy.repository

import com.david.study.groovy.model.Playlist
import com.david.study.groovy.service.PlaylistService

class PlaylistRepository(val service: PlaylistService) {

    suspend fun getPlaylists(): Result<List<Playlist>> {
        return service.fetchPlaylists()
    }
}
