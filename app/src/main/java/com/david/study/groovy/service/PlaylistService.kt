package com.david.study.groovy.service

import com.david.study.groovy.interfaces.PlaylistApi
import com.david.study.groovy.model.Playlist

class PlaylistService(private val api: PlaylistApi) {

    suspend fun fetchPlaylists(): Result<List<Playlist>> {
        return try {
            Result.success(api.fetchAllPlaylists())
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}
