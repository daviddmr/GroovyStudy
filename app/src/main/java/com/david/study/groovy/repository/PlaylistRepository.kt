package com.david.study.groovy.repository

import com.david.study.groovy.model.Playlist
import com.david.study.groovy.service.PlaylistService

class PlaylistRepository(private val service: PlaylistService) {
    suspend fun getPlaylists(): Result<List<Playlist>> {
//        val playlists = mutableListOf<Playlist>()
//        for (i in 0..10) {
//            val playlist = Playlist("$i", "Playlist $i", "Category $i")
//            playlists.add(playlist)
//        }
//
//        return if (playlists.isNotEmpty()) {
//            Result.success(playlists)
//        } else {
//            Result.failure(java.lang.RuntimeException("No result"))
//        }
        service.fetchPlaylists()
        return Result.success(listOf())
    }
}
