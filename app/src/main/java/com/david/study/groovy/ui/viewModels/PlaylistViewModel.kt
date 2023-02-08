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
//        this.playlists.value = playlists
    }

}
