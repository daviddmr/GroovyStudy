package com.david.study.groovy.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.david.study.groovy.model.Playlist
import com.david.study.groovy.repository.PlaylistRepository

class PlaylistViewModel(
    private val repository: PlaylistRepository
) : ViewModel() {

    val playlists = MutableLiveData<List<Playlist>>()

    fun getPlaylistList() {
        val result = repository.getPlaylists()
        this.playlists.value = result
    }
}
