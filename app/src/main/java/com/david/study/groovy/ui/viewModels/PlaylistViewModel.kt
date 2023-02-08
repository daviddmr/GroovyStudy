package com.david.study.groovy.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.david.study.groovy.model.Playlist
import com.david.study.groovy.repository.PlaylistRepository

class PlaylistViewModel(
    repository: PlaylistRepository
) : ViewModel() {

    val playlists = MutableLiveData<List<Playlist>>()

    init {
        mockPlaylistsList()
        repository.getPlaylists()
    }

    private fun mockPlaylistsList() {
        val playlists = mutableListOf<Playlist>()
        for (i in 0..10) {
            val playlist = Playlist("$i", "Playlist $i", "Category $i")
            playlists.add(playlist)
        }
//        this.playlists.value = playlists
    }

}
