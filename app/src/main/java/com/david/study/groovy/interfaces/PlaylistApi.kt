package com.david.study.groovy.interfaces

import com.david.study.groovy.model.Playlist
import retrofit2.http.GET

interface PlaylistApi {
    @GET("playlists")
    suspend fun fetchAllPlaylists(): List<Playlist>
}
